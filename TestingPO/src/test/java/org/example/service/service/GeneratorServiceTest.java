package org.example.service.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.example.model.Schema;
import org.example.model.UltimateImp;
import org.example.model.Vector;
import org.example.model.enums.ImpType;
import org.example.model.enums.OrientationType;
import org.example.model.enums.SchemaType;
import org.example.service.GeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GeneratorServiceTest {

    @Test
    void emptyQueueTest() {
        GeneratorService generatorService = new GeneratorService(new ArrayDeque<>());
        assertNull(generatorService.generateNewImpWithType(ImpType.SIMPLE));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("notEmptyQueueSource")
    void notEmptyQueueTest(
            String description,
            ArrayDeque<Schema> schemaDeque,
            ImpType impType,
            List<UltimateImp> expectedImps
    ) {
        GeneratorService generatorService = new GeneratorService(schemaDeque);
        List<UltimateImp> impList = new ArrayList<>();
        do {
            UltimateImp generatedImp = generatorService.generateNewImpWithType(impType);
            if (generatedImp == null) {
                break;
            }
            impList.add(generatedImp);
        } while (true);
        assertIterableEquals(expectedImps, impList);
    }

    private static Stream<Arguments> notEmptyQueueSource() {
        return Stream.of(
                Arguments.of(
                        "Default input",
                        new ArrayDeque<>(List.of(
                                new Schema(
                                        "Name 1",
                                        List.of(),
                                        SchemaType.EASY
                                ),
                                new Schema(
                                        "Name 2",
                                        List.of(
                                                new Vector(1, 10.0, OrientationType.OPPOSITE),
                                                new Vector(2, 12.0, OrientationType.OPPOSITE),
                                                new Vector(3, 10.0, OrientationType.OPPOSITE)
                                        ),
                                        SchemaType.EASY
                                ),
                                new Schema(
                                        "Name 3",
                                        List.of(
                                                new Vector(1, 15.0, OrientationType.DIRECT),
                                                new Vector(2, 10.0, OrientationType.OPPOSITE)
                                        ),
                                        SchemaType.DEFAULT
                                ),
                                new Schema(
                                        "Name 4",
                                        List.of(
                                                new Vector(1, 40.0, OrientationType.DIRECT),
                                                new Vector(2, 13.0, OrientationType.DIRECT)
                                        ),
                                        SchemaType.HARD
                                )
                        )),
                        ImpType.SIMPLE,
                        List.of(
                                new UltimateImp("Name 1_0", 0.0, false),
                                new UltimateImp("Name 2_1", 3.162, false),
                                new UltimateImp("Name 2_2", 3.464, false),
                                new UltimateImp("Name 2_3", 3.162, false),
                                new UltimateImp("Name 3_4", 3.873, false),
                                new UltimateImp("Name 3_5", 3.162, false),
                                new UltimateImp("Name 4_6", 6.325, false),
                                new UltimateImp("Name 4_7", 3.606, false)
                        )
                )
        );
    }
}
