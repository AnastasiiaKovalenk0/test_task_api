package com.epam.test.impl;

import com.epam.test.apis.FilmsAPI;
import com.epam.test.dtos.FilmsSearchResponseData;

import static com.epam.test.constants.SwapiConstants.FILMS_URL;
import static com.epam.test.constants.SwapiConstants.SEARCH_REQUEST_ATTRIBUTE;

/**
 * Class for Films.
 *
 * @author Anastasiia_Kovalenko
 */
public class DefaultFilmsAPI extends AbstractAPI implements FilmsAPI {

    @Override
    public FilmsSearchResponseData searchFilmByName(String filmName) {
        String searchUrl = FILMS_URL + SEARCH_REQUEST_ATTRIBUTE + filmName;
        return getWithSuccessCheck(searchUrl, FilmsSearchResponseData.class);
    }
}