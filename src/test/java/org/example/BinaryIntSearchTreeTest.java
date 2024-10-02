package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {

    @Test
    void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
    }

    // -1 означает отсутствие ответа
    @ParameterizedTest(name = "digits {0} count {1} upperbound {2} expected {3}")
    @CsvSource(value = {
            "7,4,5,6,1,10,9:3:7:7,6,5",
            "1,2,3,4,5:3:4:4,3,2",
            "7,4,5,6,1,10,9,15,14,20,21,22,19:6:14:14,10,9,7,6,5",
            "7,4,5,6,1,10,9,15,14,20,21,22,19:3:14:14,10,9",
            "10:1:10:10",
            "10:5:10:10",
            "10:1:9:-1"
    }
            , delimiter = ':')
    void findMaxDigitsTest(String digits, int count, int upperBound, String expected) {
        HomeWork homeWork = new HomeWork();
        addFromString(digits, homeWork);

        assertEquals(createList(expected), homeWork.findMaxDigits(count, upperBound));
    }

    private void addFromString(String digits, HomeWork tree) {
        List<Integer> list = Arrays.stream(digits.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        list.forEach(tree::add);
    }

    private List<Integer> createList(String integers) {
        if (integers.equals("-1")) {
            return List.of();
        }
        return Arrays.stream(integers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}