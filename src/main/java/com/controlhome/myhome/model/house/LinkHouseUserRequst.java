package com.controlhome.myhome.model.house;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkHouseUserRequst {

    @JsonProperty("house")
    private String house;

    @JsonProperty("username")
    private String username;
}
