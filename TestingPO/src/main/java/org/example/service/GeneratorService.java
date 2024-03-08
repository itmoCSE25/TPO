package org.example.service;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import org.example.model.Schema;
import org.example.model.UltimateImp;
import org.example.model.Vector;
import org.example.model.enums.ImpType;

public class GeneratorService {


    public Queue<Schema> schemaQueue = new ArrayDeque<>();

    private int uuid = 0;

    public GeneratorService(Queue<Schema> schemaQueue) {
        this.schemaQueue = schemaQueue;
    }

    public UltimateImp generateNewImpWithType(ImpType impType) {
        if (schemaQueue.isEmpty()) {
            return null;
        }
        Schema schema = schemaQueue.peek();
        UltimateImp ultimateImp = generateImp(schema, impType);
        if (schema.getVectorList().isEmpty()) {
            schemaQueue.poll();
        }
        return ultimateImp;
    }

    private UltimateImp generateImp(Schema schema, ImpType impType) {
        List<Vector> vectorList = takeSomeVectors(schema, impType);
        double resultPower = 0.0;
        for (Vector vector : vectorList) {
            resultPower += calculateSquareRoot(vector.getWeight());
        }
        DecimalFormat dc = new DecimalFormat("#.###");
        return new UltimateImp(schema.getName()+ "_" + uuid++, Double.parseDouble(dc.format(resultPower)));
    }

    private List<Vector> takeSomeVectors(Schema schema, ImpType impType) {
        List<Vector> vectorsToUse = schema.getVectorList().stream().limit(impType.getCount()).toList();
        List<Integer> idsToRemove = vectorsToUse.stream().map(Vector::getId).toList();
        schema.setVectorList(schema.getVectorList().stream().filter(item -> !idsToRemove.contains(item.getId())).toList());
        return vectorsToUse;
    }

    private double calculateSquareRoot(double number) {
        return Math.sqrt(number);
    }


}

