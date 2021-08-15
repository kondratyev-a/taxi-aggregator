package com.kondratyev.taxiaggregator.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import lombok.Data;

@Data
public class CreateTripRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("price_id")
    private Long priceId;

    // Не вижу смысла передавать эти данные при создании поездки.
    // Мы по сути подтверждаем ценовое предложение. А там информация откуда/куда уже есть.
    // Хотя в API iway они передаются.
    @JsonProperty("start_location")
    private LocationResponse from;

    @JsonProperty("finish_location")
    private LocationResponse to;

}
