package com.search;

public class ExponentialSearch {

    /**
     * Метод для выполнения бинарного поиска в массиве.
     *
     * @param array Отсортированный массив, в котором выполняется поиск.
     * @param left Начальный индекс диапазона поиска.
     * @param right Конечный индекс диапазона поиска.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    private static int binarySearch(int[] array, int left, int right, int target) {
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

    /**
     * Метод для выполнения экспоненциального поиска в массиве.
     *
     * @param array Отсортированный массив, в котором выполняется поиск.
     * @param target Элемент, который нужно найти.
     * @return Индекс элемента, если он найден, иначе -1.
     */
    public static int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        // Если первый элемент равен целевому, возвращаем его индекс
        if (array[0] == target) {
            return 0;
        }

        int i = 1;
        // Находим диапазон, в котором может находиться целевой элемент
        while (i < array.length && array[i] <= target) {
            i *= 2;
        }

        // Выполняем бинарный поиск в найденном диапазоне
        return binarySearch(array, i / 2, Math.min(i, array.length - 1), target);
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
