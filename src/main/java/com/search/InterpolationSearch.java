package com.search;

public class InterpolationSearch {

    /**
     * Метод для выполнения интерполяционного поиска в массиве.
     *
     * @param array Отсортированный массив, в котором выполняется поиск.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            if (low == high) {
                if (array[low] == target) {
                    return low;
                }
                return -1;
            }

            // Применяем формулу интерполяции для определения позиции
            int pos = low + ((target - array[low]) * (high - low)) / (array[high] - array[low]);

            // Проверяем, равен ли элемент на позиции целевому
            if (array[pos] == target) {
                return pos;
            }

            // Если целевой элемент меньше элемента на позиции, ищем в левой части
            if (array[pos] < target) {
                low = pos + 1;
            } else {
                // Иначе ищем в правой части
                high = pos - 1;
            }
        }

        return -1; // Элемент не найден
    }

    public static void main(String[] args) {
        int[] array = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int target = 18;

        int result = search(array, target);

        if (result != -1) {
            System.out.println("Элемент найден на индексе: " + result);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
