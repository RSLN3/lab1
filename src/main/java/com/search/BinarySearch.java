package com.search;

public class BinarySearch {

    /**
     * Метод для выполнения бинарного поиска в массиве.
     *
     * @param array Отсортированный массив, в котором выполняется поиск.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Проверяем, равен ли средний элемент целевому
            if (array[mid] == target) {
                return mid; // Элемент найден, возвращаем его индекс
            }

            // Если целевой элемент меньше среднего, ищем в левой половине
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                // Иначе ищем в правой половине
                left = mid + 1;
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
