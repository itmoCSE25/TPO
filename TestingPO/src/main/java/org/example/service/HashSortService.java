package org.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashSortService {

    public static List<Integer> hashSort(List<Integer> array) {
        if (array.isEmpty()) {
            return new ArrayList<>();
        }

        int maxArrayValue = Collections.max(array);

        List<List<Integer>> hashTable = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            hashTable.add(new ArrayList<>());
        }

        for (int value : array) {
            int index = (int) (1.0 * value * array.size() / (maxArrayValue + 1));
            hashTable.get(index).add(value);
        }

        List<Integer> sortedArray = new ArrayList<>();
        for (List<Integer> chain : hashTable) {
            Collections.sort(chain);
            sortedArray.addAll(chain);
        }

        return sortedArray;
    }
}
