package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]
     *
     * @param count      максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()) {
            Node current = stack.pop();
            if (current == null) {
                continue;
            }
            if (list.contains(current.value)) {
                continue;
            }
            if (current.left != null) {
                if (!list.contains(current.left.value)) {
                    stack.push(current);
                    stack.push(current.left);
                    continue;
                }
                list.add(current.value);
            }
            if (current.right != null) {
                if (!list.contains(current.value)) {
                    list.add(current.value);
                }
                stack.push(current.right);
                continue;
            }
            if (current.left == null) {
                list.add(current.value);
            }
        }

        List<Integer> result = new ArrayList<>(List.of());

        if (list.size() > 1) {
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i) <= upperBound && count > 0) {
                    result.add(list.get(i));
                    count--;
                }
            }
        }
        if (list.size() == 1 && list.get(0) <= upperBound && count > 0) {
            result.add(list.get(0));
        }

        return result;
    }
}
