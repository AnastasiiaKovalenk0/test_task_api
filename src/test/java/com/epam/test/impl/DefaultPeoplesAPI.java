package com.epam.test.impl;

import com.epam.test.apis.PeoplesAPI;
import com.epam.test.dtos.CharacterData;
import com.epam.test.dtos.FilmsSearchResponseData;
import com.epam.test.dtos.StarshipData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

/**
 * Class for Peoples.
 *
 * @author Anastasiia_Kovalenko
 */
public class DefaultPeoplesAPI extends AbstractAPI implements PeoplesAPI {

    @Override
    public Optional<CharacterData> findPilotByNameOnAStarship(String pilotName, StarshipData starship) {
        return starship.getPilots().stream()
                .map(currentPilotUrl -> getWithSuccessCheck(currentPilotUrl, CharacterData.class))
                .filter(currentPilot -> pilotName.equals(currentPilot.getName()))
                .findFirst();
    }

    @Override
    public CharacterData findPersonFromFilmByName(String personName, FilmsSearchResponseData searchResult) {
        return getAllCharactersFromSearchResult(searchResult).stream()
                .map(characterUrl -> getWithSuccessCheck(characterUrl, CharacterData.class))
                .filter(currentCharacter -> personName.equals(currentCharacter.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Character with name {0} not found",
                        personName)));
    }

    private List<String> getAllCharactersFromSearchResult(FilmsSearchResponseData searchResult) {
        return searchResult.getResults().stream()
                .flatMap(currentFilm -> currentFilm.getCharacters().stream())
                .collect(Collectors.toList());
    }
}