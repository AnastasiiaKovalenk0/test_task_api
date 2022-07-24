package com.epam.test.dtos;

import lombok.Data;

import java.util.List;

/**
 * Class for response films dto.
 *
 * @author Anastasiia_Kovalenko
 */
@Data
public class FilmsSearchResponseData {
    private int count;
    private Object next;
    private Object previous;
    private List<FilmData> results;
}