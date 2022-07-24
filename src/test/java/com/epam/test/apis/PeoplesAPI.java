package com.epam.test.apis;

import com.epam.test.dtos.CharacterData;
import com.epam.test.dtos.FilmsSearchResponseData;
import com.epam.test.dtos.StarshipData;

import java.util.Optional;

public interface PeoplesAPI {
    Optional<CharacterData> findPilotByNameOnAStarship(String pilotName, StarshipData starship);

    CharacterData findPersonFromFilmByName(String personName, FilmsSearchResponseData searchResult);
}