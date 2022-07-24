package com.epam.test.apis;

import com.epam.test.dtos.FilmsSearchResponseData;

public interface FilmsAPI {
    FilmsSearchResponseData searchFilmByName(String filmName);
}