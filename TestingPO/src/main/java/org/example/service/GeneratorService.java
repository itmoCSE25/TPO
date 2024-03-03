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
        return new UltimateImp()
                .setUuid("%s_%d".formatted(schema.getName(), schema.getCountOfVectors()))
                .setPower(ArctgFunctionService.arctg(schema.getCountOfVectors()));
    }
}
