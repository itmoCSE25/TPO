package org.example.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.example.model.Clothes;
import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.ClothesType;
import org.example.model.enums.PersonType;
import org.example.model.enums.PreferredPerson;
import org.example.service.MoodService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MoodServiceTest {

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("changeMoodInPlaceSource")
    void changeMoodInPlaceTest(
            @SuppressWarnings("unused")
            String name,
            Place place,
            List<UltimateImp> impList,
            PreferredPerson preferredPerson,
            Place expectedPlace
    ) {
        MoodService moodService = new MoodService();
        moodService.moveImpsInPlace(place, new ArrayList<>(impList), preferredPerson);

        assertEquals(expectedPlace.getPlaceName(), place.getPlaceName());
        assertIterableEquals(expectedPlace.getPersonList(), place.getPersonList());
    }

    private static Stream<Arguments> changeMoodInPlaceSource() {
        return Stream.of(
                Arguments.of(
                    "Empty place",
                        new Place("Place 1", List.of()),
                        List.of(
                                new UltimateImp("Name 1", 10.0),
                                new UltimateImp("Name 3", 25.0)
                        ),
                        PreferredPerson.EASY_TO_MOOD_UP,
                        new Place("Place 1", List.of())
                ),
                Arguments.of(
                        "Default data",
                        new Place("Place 1", List.of(
                                new Person(
                                        "Person 1",
                                        PersonType.SANGVINIC,
                                        0.0,
                                        2.0,
                                        new ArrayList<>(List.of(
                                                new Clothes("UNDERWEAR", ClothesType.UNDERWEAR),
                                                new Clothes("SWEATER", ClothesType.SWEATER)
                                        ))
                                ),
                                new Person(
                                        "Person 2",
                                        PersonType.FLIGMATIC,
                                        0.0,
                                        3.0,
                                        new ArrayList<>(List.of(
                                                new Clothes("SWEATER", ClothesType.SWEATER)
                                        ))
                                )
                        )),
                        List.of(
                                new UltimateImp("Name 1", 1.0),
                                new UltimateImp("Name 1", 1.5),
                                new UltimateImp("Name 1", 3.5)
                        ),
                        PreferredPerson.WITH_LOW_MOOD,
                        new Place("Place 1", List.of(
                                new Person(
                                        "Person 1",
                                        PersonType.SANGVINIC,
                                        4.0,
                                        2.0,
                                        new ArrayList<>(List.of(
                                                new Clothes("SWEATER", ClothesType.SWEATER)
                                        ))
                                ),
                                new Person(
                                        "Person 2",
                                        PersonType.FLIGMATIC,
                                        0.0,
                                        3.0,
                                        new ArrayList<>(List.of(
                                                new Clothes("SWEATER", ClothesType.SWEATER)
                                        ))
                                )
                        ))
                )
        );
    }
}