package oy.tol.tra;

public class Algorithms {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        boolean exchange;

        do {
            exchange = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    exchange = true;
                }
            }
            n--;
        } while (exchange);

    }

    public static <T> void reverse(T[] array) {
        // implementation here...
        int i = 0;
        int x = array.length - 1;
        while (i <= x / 2) {
            T temp = array[i];
            array[i] = array[x - i];
            array[x - i] = temp;
            i++;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {

        for (int i = 0; i < fromArray.length; i++) {
            int mid = (fromIndex + toIndex) / 2;
            if (aValue.compareTo(fromArray[mid]) > 0) {
                fromIndex = mid + 1;
            } else if (aValue.compareTo(fromArray[mid]) < 0) {
                toIndex = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;

    }

    public static <E extends Comparable<E>> void fastSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        // implement Quicksort here...
        if (begin < end) {
            int result = partition(array, begin, end);
            quickSort(array, begin, result - 1);
            quickSort(array, result + 1, end);
        }

    }

    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        int head = begin;
        int tail = end;
        sort(array);

        while (head <= tail) {
            E mid = array[begin + (end - begin) / 2];
            while (array[head].compareTo(mid) < 0) {
                head++;
            }

            while (array[tail].compareTo(mid) > 0) {
                tail--;
            }

            if (head <= tail) {
                E temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                head++;
                tail--;
            }
        }

        return head;
    }
}