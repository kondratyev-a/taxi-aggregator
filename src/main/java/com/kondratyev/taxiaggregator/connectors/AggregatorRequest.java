package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.services.PriceService;
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

    AggregatorRequest(List<AggregatorConnector> aggregatorConnectors, PriceService priceService) {
        this.aggregatorConnectors = aggregatorConnectors;
        this.priceService = priceService;
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

}
