package com.search;

public class JumpSearch {

    /**
     * Метод для выполнения поиска прыжками в массиве.
     *
     * @param array Отсортированный массив, в котором выполняется поиск.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    public static int search(int[] array, int target) {
        int length = array.length;
        int step = (int) Math.sqrt(length); // Размер блока
        int prev = 0; // Начало текущего блока

        // Прыгаем по блокам
        while (array[Math.min(step, length) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(length);
            if (prev >= length) {
                return -1; // Элемент не найден
            }
        }

        // Выполняем линейный поиск в найденном блоке
        while (array[prev] < target) {
            prev++;
            if (prev == Math.min(step, length)) {
                return -1; // Элемент не найден
            }
        }

        // Проверяем, найден ли элемент
        if (array[prev] == target) {
            return prev; // Элемент найден
        }

        return -1; // Элемент не найден
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int target = 55;

        int result = search(array, target);

        if (result != -1) {
            System.out.println("Элемент найден на индексе: " + result);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
