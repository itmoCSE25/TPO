package org.example.service;

import java.util.List;

import org.example.model.Schema;
import org.example.model.UltimateImp;

public class GeneratorService {

    public UltimateImp generate(Schema schema) {
        return generateBySchema(schema);
    }

    public List<UltimateImp> generate(List<Schema> schemaList) {
        return schemaList.stream()
                .filter(Schema::isNotUsed)
                .map(this::generateBySchema).toList();
    }

    private UltimateImp generateBySchema(Schema schema) {
        schema.setNotUsed(false);
        UltimateImp result = new UltimateImp();
        switch (schema.getSchemaType()) {
            case DEFAULT -> {
                result.setPower(0.0);
            }
            case EASY -> {
                result.setPower(1.5 * schema.getCountOfVectors());
            }
            case HARD -> {
                result.setPower(-1.5 * schema.getCountOfVectors());
            }
            case UNDEFINED -> {
                throw new IllegalArgumentException("Undefined type");
            }
        }
        result.setUuid("%s_%d".formatted(schema.getName(), schema.getCountOfVectors()));
        return result;
    }
}
