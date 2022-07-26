package com.epam.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Class for Starship dto.
 *
 * @author Anastasiia_Kovalenko
 */
@Data
public class StarshipData {
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    @JsonProperty("MGLT")
    private String MGLT;
    private String starship_class;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}