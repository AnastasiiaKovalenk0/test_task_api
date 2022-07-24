package com.epam.test.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Class for film dto.
 *
 * @author Anastasiia_Kovalenko
 */
@Data
public class FilmData {
    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private Date release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;
}