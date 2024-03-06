package org.example.service.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.example.model.Schema;
import org.example.model.UltimateImp;
import org.example.model.enums.SchemaType;
import org.example.service.GeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeneratorServiceTest {

    private final GeneratorService generatorService = new GeneratorService();

    @ParameterizedTest
    @MethodSource("schemasSource")
    void testGenerateSchemas(
            @SuppressWarnings("unused")
            String name,
            List<Schema> schemaList,
            Map<String, UltimateImp> expected
    ) {
        generatorService.generate(schemaList)
                .forEach(imp -> assertImpEquals(expected.get(imp.getUuid()), imp));
        schemaList.forEach(schema -> assertFalse(schema.isNotUsed()));
    }

    @Test
    void testGenerateSchema() {
        assertImpEquals(
                new UltimateImp("Test name 1_1", -1.5),
                generatorService.generate(new Schema("Test name 1", 1, true, SchemaType.HARD))
        );
    }

    @Test
    void testGenerateUndefinedSchema() {
        assertThrows(
                IllegalArgumentException.class,
                () -> generatorService.generate(new Schema("Test name 1", 1, true, SchemaType.UNDEFINED))
        );
    }

    private void assertImpEquals(UltimateImp expected, UltimateImp actual) {
        assertEquals(expected.getPower(), actual.getPower());
        assertEquals(expected.getUuid(), actual.getUuid());
    }

    private static Stream<Arguments> schemasSource() {
        return Stream.of(
                Arguments.of(
                        "Empty list",
                        List.of(),
                        Map.of()
                ),
                Arguments.of(
                        "List with used schema",
                        List.of(
                                new Schema("Test name 1", 1, true, SchemaType.HARD),
                                new Schema("Test name 2", 10, true, SchemaType.DEFAULT),
                                new Schema("Test name 3", 20, false, SchemaType.EASY)
                        ),
                        Map.of(
                                "Test name 1_1", new UltimateImp("Test name 1_1", -1.5),
                                "Test name 2_10", new UltimateImp("Test name 2_10", 0)
                        )
                ),
                Arguments.of(
                        "Only one schema",
                        List.of(
                                new Schema("Test name 1", 1, true, SchemaType.EASY)
                        ),
                        Map.of(
                                "Test name 1_1", new UltimateImp("Test name 1_1", 1.5)
                        )
                )
        );
    }
}
