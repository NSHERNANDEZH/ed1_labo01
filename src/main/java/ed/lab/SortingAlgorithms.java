package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, PivotType.HIGH);

    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, PivotType.LOW);

    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, PivotType.RANDOM);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, PivotType pivotType) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, pivotType);
            quickSort(array, low, pivotIndex - 1, pivotType);
            quickSort(array, pivotIndex + 1, high, pivotType);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, PivotType pivotType) {
        T pivot = selectPivot(array, low, high, pivotType);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static <T extends Comparable<T>> T selectPivot(T[] array, int low, int high, PivotType pivotType) {
        switch (pivotType) {
            case LOW:
                // Asegurarse de que el pivote (primer elemento) esté en la última posición para la partición
                T pivotLow = array[low];
                swap(array, low, high);
                return pivotLow;
            case RANDOM:
                int randomIndex = new Random().nextInt(high - low + 1) + low;
                swap(array, randomIndex, high);
                return array[high];
            case HIGH:
            default:
                return array[high];
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private enum PivotType {
        HIGH,
        LOW,
        RANDOM
    }
}
