package com.epam.test.apis;

import com.epam.test.dtos.CharacterData;
import com.epam.test.dtos.StarshipData;
public interface StarshipsAPI {
    StarshipData getFirstStarshipForCharacter(CharacterData character);
}