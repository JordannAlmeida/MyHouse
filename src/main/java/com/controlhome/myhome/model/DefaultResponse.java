package com.controlhome.myhome.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse<T> {

    @JsonProperty("sucess")
    private Boolean sucess;

    @JsonProperty("message")
    private String message;

    @JsonProperty("content")
    private T content;
}
