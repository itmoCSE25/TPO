package org.example.service.service;

import org.example.service.HashSortService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashSortServiceTest {

    @Test
    public void testHashSort() {
        List<Integer> array = Arrays.asList(420, 993, 363, 881, 99, 499, 440, 168, 233, 845, 765, 380, 659, 560, 802, 558, 478, 833, 172, 198, 77, 911, 589, 446, 726, 596, 666, 851, 699, 309);
        List<Integer> sortedArray = HashSortService.hashSort(array);
        List<Integer> expectedSortedArray = Arrays.asList(77, 99, 168, 172, 198, 233, 309, 363, 380, 420, 440, 446, 478, 499, 558, 560, 589, 596, 659, 666, 699, 726, 765, 802, 833, 845, 851, 881, 911, 993);
        assertEquals(expectedSortedArray, sortedArray);
    }

    @Test
    public void testEmptyArray() {
        List<Integer> array = new ArrayList<>();
        List<Integer> sortedArray = HashSortService.hashSort(array);
        assertEquals(array, sortedArray);
    }

    @Test
    public void testAlreadySortedArray() {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sortedArray = HashSortService.hashSort(array);
        assertEquals(array, sortedArray);
    }

    @Test
    public void testReverseHashSort() {
        List<Integer> array = Arrays.asList(999, 537, 378, 342, 211, 109, 43, 21, 7);
        List<Integer> sortedArray = HashSortService.hashSort(array);
        List<Integer> expectedSortedArray = Arrays.asList(7, 21, 43, 109, 211, 342, 378, 537, 999);
        assertEquals(expectedSortedArray, sortedArray);
    }

    @Test
    public void testSingleElementArray() {
        List<Integer> array = List.of(5);
        List<Integer> sortedArray = HashSortService.hashSort(array);
        assertEquals(array, sortedArray);
    }
}
