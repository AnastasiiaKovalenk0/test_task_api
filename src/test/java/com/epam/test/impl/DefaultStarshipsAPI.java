package com.epam.test.impl;

import com.epam.test.apis.StarshipsAPI;
import com.epam.test.dtos.CharacterData;
import com.epam.test.dtos.StarshipData;

import static java.text.MessageFormat.format;

/**
 * Class for Starship.
 *
 * @author Anastasiia_Kovalenko
 */
public class DefaultStarshipsAPI extends AbstractAPI implements StarshipsAPI {

    private static final String SHIPS_NOT_FOUND_ERROR_TEMPLATE = "Character with name {0} is not a member of any starship";

    @Override
    public StarshipData getFirstStarshipForCharacter(CharacterData character) {
        String firstStarshipUrl = getFirstStarshipUrl(character);
        return getWithSuccessCheck(firstStarshipUrl, StarshipData.class);
    }

    private String getFirstStarshipUrl(CharacterData character) {
        return character.getStarships().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format(SHIPS_NOT_FOUND_ERROR_TEMPLATE, character.getName())));
    }
}