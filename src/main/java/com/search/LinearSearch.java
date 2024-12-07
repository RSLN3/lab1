package com.search;

public class LinearSearch {

    /**
     * Метод для выполнения линейного поиска в массиве.
     *
     * @param array Массив, в котором выполняется поиск.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    public static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Элемент найден, возвращаем его индекс
            }
        }
        return -1; // Элемент не найден
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int target = 30;

        int result = search(array, target);

        if (result != -1) {
            System.out.println("Элемент найден на индексе: " + result);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}

