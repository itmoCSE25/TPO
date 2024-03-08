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
//        moodService.moveImpsInPlace();
    }

    private void assertPersonEquals(Person expected, Person actual) {
        assertEquals(expected.getMoodLevel(), actual.getMoodLevel());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPersonType(), actual.getPersonType());
    }

    private static Stream<Arguments> changeMoodInPlaceSource() {
        return Stream.of(
                Arguments.of(

                )
        );
    }
}