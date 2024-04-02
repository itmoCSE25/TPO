package org.example.service.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ArgumentsProvider {

    public static double getTestedValue(String pathFile, double x) throws IOException {
        File file = new File(pathFile);

        List<Map<String, Double>> list = read(file);
        for (Map<String, Double> map : list) {
            if (compareWithFormat(map.get("x"), x)) {
                return map.get("y");
            }
        }
        throw new IllegalArgumentException("Value %f is not tested".formatted(x));
    }

    public static List<Map<String, Double>> read(File file) throws IOException {
        List<Map<String, Double>> response = new LinkedList<>();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class)
                .with(schema)
                .readValues(file);
        while (iterator.hasNext()) {
            List<Double> values = new ArrayList<>(iterator.next().values()).stream()
                    .map(Double::valueOf).toList();
            if (!values.isEmpty()) {
                response.add(Map.of("x",values.get(0), "y", values.get(1)));
            }
        }
        return response;
    }

    private static boolean compareWithFormat(double val1, double val2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        return decimalFormat.format(val1).equals(decimalFormat.format(val2));
    }
}
