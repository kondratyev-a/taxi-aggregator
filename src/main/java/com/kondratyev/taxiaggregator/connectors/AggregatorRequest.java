package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import com.kondratyev.taxiaggregator.services.PriceService;
import com.kondratyev.taxiaggregator.services.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Component
public class AggregatorRequest {

    // Spring автоматически привяжет все имплементации и при добавлении нового провайдера
    // не нужно будет переписывать существующие классы.
    private final List<AggregatorConnector> aggregatorConnectors;

    private final PriceService priceService;
    private final TripService tripService;

    AggregatorRequest(List<AggregatorConnector> aggregatorConnectors, PriceService priceService,
                      TripService tripService) {
        this.aggregatorConnectors = aggregatorConnectors;
        this.priceService = priceService;
        this.tripService = tripService;
    }

    public PriceResponse getPrice(Long userId, String fromLocation, String toLocation) {

        log.debug("Determining the best price");

        // Вызываем все реализованные коннекторы
        List<PriceResponse> prices = new ArrayList<>();
        for (AggregatorConnector aggregatorConnector: aggregatorConnectors) {
            prices.add(aggregatorConnector.getPrice(userId, fromLocation, toLocation));
        }

        // Выбираем лучшее предложение (ближайший автомобиль, самая дешевая цена)
        // Тут должен быть какой-то алгоритм. Для тестового задания - берем минимальную цену.
        PriceResponse bestPrice = chooseBestPrice(prices);

        // Конвертируем во внутренний объект и сохраняем лучшее предложение в базу
        // т.к. мы отправляем его клиенту и по нему он может создать заказ.
        // Затем конвертируем обратно и возвращаем в качестве ответа.
        // Сохранять все варианты цен я не вижу смысла т.к. по сути это сеансовые данные.
        return priceService.savePriceResponse(bestPrice);
    }

    private PriceResponse chooseBestPrice(List<PriceResponse> prices) {

        return prices
                .stream()
                .min(Comparator.comparing(PriceResponse::getPrice))
                .orElseThrow(NoSuchElementException::new);

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
            if (aggregatorConnector.getId() == aggregatorId) {
                TripResponse tripResponse = aggregatorConnector.createTrip(tripRequest, price);
                return tripService.saveTripResponse(tripResponse);
            }
        }
        return null;
    }
}
