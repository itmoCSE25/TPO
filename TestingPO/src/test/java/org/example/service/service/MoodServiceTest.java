package org.example.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.PersonType;
import org.example.model.enums.PreferredPerson;
import org.example.service.MoodService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MoodServiceTest {

    @ParameterizedTest
    @MethodSource("changeMoodInPlaceSource")
    void changeMoodInPlaceTest(
            @SuppressWarnings("unused")
            String name,
            Place place,
            List<UltimateImp> impList,
            Double enoughMoodLevel,
            PreferredPerson preferredPerson,
            Place expectedPlace
    ) {
        MoodService moodService = new MoodService(enoughMoodLevel);
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
                        10.0,
                        PreferredPerson.EASY_TO_MOOD_UP,
                        new Place("Place 1", List.of())
                ),
                Arguments.of(
                        "Empty ImpList",
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, 0.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 1.0)
                        )),
                        List.of(
                        ),
                        10.0,
                        PreferredPerson.EASY_TO_MOOD_UP,
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, 0.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 1.0)
                        ))
                ),
                Arguments.of(
                        "Empty ImpList",
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, 0.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 1.0)
                        )),
                        List.of(
                                new UltimateImp("Name 1", 10.0),
                                new UltimateImp("Name 3", 25.0)
                        ),
                        10.0,
                        PreferredPerson.EASY_TO_MOOD_UP,
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, 100.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 31.0)
                        ))
                ),
                Arguments.of(
                        "Empty ImpList",
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, -1.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 1.0)
                        )),
                        List.of(
                                new UltimateImp("Name 1", 10.0),
                                new UltimateImp("Name 3", 25.0)
                        ),
                        10.0,
                        PreferredPerson.WITH_LOW_MOOD,
                        new Place("Place 1", List.of(
                                new Person("Person 1", PersonType.SANGVINIC, 39.0),
                                new Person("Person 1", PersonType.FLIGMATIC, 76.0)
                        ))
                )
        );
    }
}