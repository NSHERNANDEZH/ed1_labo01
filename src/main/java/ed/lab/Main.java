package ed.lab;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf(i);
        }
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf(length - i);
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf((int) (Math.random() * length));
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, getHighPivotQuickSort());
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, getLowPivotQuickSort());
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, getRandomPivotQuickSort());
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, getHighPivotQuickSort());
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, getLowPivotQuickSort());
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, getRandomPivotQuickSort());
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, getHighPivotQuickSort());
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, getLowPivotQuickSort());
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, getRandomPivotQuickSort());
        System.out.println("================================");
    }
}
