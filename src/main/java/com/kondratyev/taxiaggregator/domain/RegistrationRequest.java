package com.kondratyev.taxiaggregator.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegistrationRequest {

    private String name;

    @NonNull
    private String login;

    @NonNull
    private String password;
}
