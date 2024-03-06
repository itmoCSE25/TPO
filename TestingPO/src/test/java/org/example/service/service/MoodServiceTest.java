package org.example.service.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.PersonType;
import org.example.service.MoodService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MoodServiceTest {

    private final MoodService moodService = new MoodService();

    @ParameterizedTest
    @MethodSource("changeMoodInPlaceSource")
    void changeMoodInPlaceTest(
            @SuppressWarnings("unused")
            String name,
            Place place,
            List<UltimateImp> impList,
            Map<String, Person> expected
    ) {
        moodService.changeMoodInPlace(place, impList);
        place.getPersonList()
                .forEach(person -> assertPersonEquals(
                        expected.get(person.getName()), person
                ));
    }

    private void assertPersonEquals(Person expected, Person actual) {
        assertEquals(expected.getMoodLevel(), actual.getMoodLevel());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPersonType(), actual.getPersonType());
        assertEquals(expected.isWantToMoodGrade(), actual.isWantToMoodGrade());
    }

    private static Stream<Arguments> changeMoodInPlaceSource() {
        return Stream.of(
                Arguments.of(
                        "Empty place and imps",
                        new Place(List.of()),
                        List.of(),
                        Map.of()
                ),
                Arguments.of(
                        "Empty imps, not empty place",
                        new Place(
                                List.of(new Person("test name", 1.0, true, PersonType.HOLERIC))
                        ),
                        List.of(),
                        Map.of(
                                "test name", new Person("test name", 1.0, true, PersonType.HOLERIC)
                        )
                ),
                Arguments.of(
                        "Default",
                        new Place(
                                List.of(
                                        new Person("Test name 1", 1.0, false, PersonType.HOLERIC),
                                        new Person("Test name 2", 1.0, true, PersonType.SANGVINIC)
                                )
                        ),
                        List.of(
                                new UltimateImp("_", 1.5),
                                new UltimateImp("_", 2.5)
                        ),
                        Map.of(
                                "Test name 1", new Person("Test name 1", 1.0, false, PersonType.HOLERIC),
                                "Test name 2", new Person("Test name 2", 7.0, true, PersonType.SANGVINIC)
                        )
                )
        );
    }
}