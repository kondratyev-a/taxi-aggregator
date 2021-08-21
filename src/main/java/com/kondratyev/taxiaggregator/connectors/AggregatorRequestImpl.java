package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import com.kondratyev.taxiaggregator.services.PriceService;
import com.kondratyev.taxiaggregator.services.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class AggregatorRequestImpl implements AggregatorRequest {

    // Spring автоматически привяжет все имплементации и при добавлении нового провайдера
    // не нужно будет переписывать существующие классы.
    private final List<AggregatorConnector> aggregatorConnectors;

    private final PriceService priceService;
    private final TripService tripService;

    AggregatorRequestImpl(List<AggregatorConnector> aggregatorConnectors, PriceService priceService,
                      TripService tripService) {
        this.aggregatorConnectors = aggregatorConnectors;
        this.priceService = priceService;
        this.tripService = tripService;
    }

    public PriceResponse getPrice(Long userId, String fromLocation, String toLocation) {

        PriceResponse bestPrice = PriceAggregatorRequest.getPriceResponse(aggregatorConnectors, userId, fromLocation, toLocation);

        // Конвертируем во внутренний объект и сохраняем лучшее предложение в базу
        // т.к. мы отправляем его клиенту и по нему он может создать заказ.
        // Затем конвертируем обратно и возвращаем в качестве ответа.
        // Сохранять все варианты цен я не вижу смысла т.к. по сути это сеансовые данные.
        return priceService.savePriceResponse(bestPrice);
    }

    public TripResponse createTrip(CreateTripRequest tripRequest) {

        // Получаем цену по идентификатору
        Price price = priceService.findByPriceId(tripRequest.getPriceId());
        Long aggregatorId = price.getAggregatorId();

        // Вызываем все реализованные коннекторы
        for (AggregatorConnector aggregatorConnector: aggregatorConnectors) {
            // Вообще мне этот перебор совсем не нравится. Я думал реализовать через Factory Pattern,
            // но это добавляет необходимость явно указывать нового агрегатора при добавлении.
            // В общем сделал пока так, но хорошо бы переделать. Еще бы знать как.
            if (Objects.equals(aggregatorConnector.getId(), aggregatorId)) {
                TripResponse tripResponse = aggregatorConnector.createTrip(tripRequest, price);
                return tripService.saveTripResponse(tripResponse);
            }
        }
        return null;
    }

    public DeleteTripResponse deleteTrip(DeleteTripRequest deleteTripRequest) {

        Trip tripToDelete = tripService.findByTripId(deleteTripRequest.getTripId());
        Long aggregatorId = tripToDelete.getAggregatorId();

        // Вызываем все реализованные коннекторы
        for (AggregatorConnector aggregatorConnector: aggregatorConnectors) {
            if (Objects.equals(aggregatorConnector.getId(), aggregatorId)) {
                DeleteTripResponse deleteTripResponse = aggregatorConnector.deleteTrip(deleteTripRequest);
                // Вообще, конечно лучше не удалять объект из базы, а взводить какой-то флаг.
                tripService.deleteById(tripToDelete.getId());
                return deleteTripResponse;
            }
        }
        return null;
    }
}
