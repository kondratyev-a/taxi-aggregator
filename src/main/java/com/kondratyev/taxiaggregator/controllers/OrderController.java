package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class OrderController {

    private final AggregatorRequest aggregatorRequest;

    public OrderController(AggregatorRequest aggregatorRequest) {
        this.aggregatorRequest = aggregatorRequest;
    }

    // Создание заказа
    @PostMapping("/orders")
    Map<String, Object> createOrder(@RequestParam(name = "user_id") Long userId,
                               @RequestParam(name = "start_place_point") String fromLocation,
                               @RequestParam(name = "finish_place_point") String toLocation) {

        log.debug("Creating an order");

        Map<String, Object> response = new HashMap<>();
        response.put("result", null);
        response.put("error", null);

        return response;
    }

    // Получение информации по заказу
    @GetMapping("/orders")
    Map<String, Object> getOrder(@RequestParam(name = "user_id") Long userId,
                               @RequestParam(name = "start_place_point") String fromLocation,
                               @RequestParam(name = "finish_place_point") String toLocation) {

        log.debug("Getting info about the order");

        Map<String, Object> response = new HashMap<>();
        response.put("result", null);
        response.put("error", null);

        return response;
    }

    // Обновление информации по заказу
    @PutMapping("/orders")
    Map<String, Object> updateOrder(@RequestParam(name = "user_id") Long userId,
                                 @RequestParam(name = "start_place_point") String fromLocation,
                                 @RequestParam(name = "finish_place_point") String toLocation) {

        log.debug("Updating info about the order");

        Map<String, Object> response = new HashMap<>();
        response.put("result", null);
        response.put("error", null);

        return response;
    }

    // Удаление заказа
    @DeleteMapping("/orders")
    Map<String, Object> deleteOrder(@RequestParam(name = "user_id") Long userId,
                                    @RequestParam(name = "start_place_point") String fromLocation,
                                    @RequestParam(name = "finish_place_point") String toLocation) {

        log.debug("Deleting the order");

        Map<String, Object> response = new HashMap<>();
        response.put("result", null);
        response.put("error", null);

        return response;
    }

}
