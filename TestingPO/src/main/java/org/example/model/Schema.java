package org.example.model;

import java.util.List;

import org.example.model.enums.SchemaType;

public class Schema{

    private String name;
    private List<Vector> vectorList;
    private SchemaType schemaType;

    public Schema(String name, List<Vector> vectorList, SchemaType schemaType) {
        this.name = name;
        this.vectorList = vectorList;
        this.schemaType = schemaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vector> getVectorList() {
        return vectorList;
    }

    public void setVectorList(List<Vector> vectorList) {
        this.vectorList = vectorList;
    }

    public SchemaType getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(SchemaType schemaType) {
        this.schemaType = schemaType;
    }
}
