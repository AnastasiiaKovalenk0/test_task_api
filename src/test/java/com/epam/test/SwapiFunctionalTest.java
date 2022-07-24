package com.epam.test;

import com.epam.test.apis.FilmsAPI;
import com.epam.test.apis.PeoplesAPI;
import com.epam.test.apis.StarshipsAPI;
import com.epam.test.dtos.CharacterData;
import com.epam.test.dtos.FilmsSearchResponseData;
import com.epam.test.dtos.StarshipData;
import com.epam.test.impl.DefaultFilmsAPI;
import com.epam.test.impl.DefaultPeoplesAPI;
import com.epam.test.impl.DefaultStarshipsAPI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SwapiFunctionalTest {
    protected FilmsAPI filmsAPI;
    protected PeoplesAPI peoplesAPI;
    protected StarshipsAPI starshipsAPI;

    @BeforeClass
    public void setUp() {
        filmsAPI = new DefaultFilmsAPI();
        peoplesAPI = new DefaultPeoplesAPI();
        starshipsAPI = new DefaultStarshipsAPI();
    }

    @Test
    public void checkThatBiggsDarklighterAndLukeSkywalkerWasOnTheSameStarfighterShip() {
        FilmsSearchResponseData searchResult = filmsAPI.searchFilmByName("A New Hope");
        CharacterData character = peoplesAPI.findPersonFromFilmByName("Biggs Darklighter", searchResult);
        StarshipData starship = starshipsAPI.getFirstStarshipForCharacter(character);
        assertThat(starship.getStarship_class()).isEqualTo("Starfighter");
        assertThatPilotIsAMemberOfStarship("Luke Skywalker", starship);
    }

    private void assertThatPilotIsAMemberOfStarship(String pilotName, StarshipData starship) {
        Optional<CharacterData> foundPilot = peoplesAPI.findPilotByNameOnAStarship(pilotName, starship);
        assertThat(foundPilot).isPresent();
        assertThat(foundPilot.get()).extracting(CharacterData::getName).isEqualTo(pilotName);
    }
}