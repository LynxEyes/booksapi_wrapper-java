package com.ivojesus.adapters.googleapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse {
    @JsonProperty("items")
    public Volume[] items;
}
