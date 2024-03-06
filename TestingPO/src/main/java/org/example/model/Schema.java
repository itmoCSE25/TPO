package org.example.model;

import org.example.model.enums.SchemaType;

public class Schema{

    private String name;
    private long countOfVectors;
    private boolean isNotUsed;
    private SchemaType schemaType;

    public Schema(String name, long countOfVectors, boolean isNotUsed, SchemaType schemaType) {
        this.name = name;
        this.countOfVectors = countOfVectors;
        this.isNotUsed = isNotUsed;
        this.schemaType = schemaType;
    }

    public String getName() {
        return name;
    }

    public long getCountOfVectors() {
        return countOfVectors;
    }

    public boolean isNotUsed() {
        return isNotUsed;
    }

    public void setNotUsed(boolean notUsed) {
        isNotUsed = notUsed;
    }

    public SchemaType getSchemaType() {
        return schemaType;
    }
}
