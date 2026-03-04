import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainClass {

    public static void main(String[] args) {
        Integer[] arr = { 4, 5, 0, 1, 2, 9 };
        // bubbleSort();
        // selectionSort(arr);
        // insertionSort(arr);
        mergeSort(arr);
    }

    static void bubbleSort(Integer[] arr) {

        // Sorting is happening here
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Bubble Sort Output: ");
        System.out.println(l1);
    }

    static void selectionSort(Integer[] arr) {
        // Sorting is happening here
        for (int i = 0; i < arr.length - 1; i++) {
            int minNumIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minNumIndex];
            arr[minNumIndex] = temp;
        }
        //
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Selection Sort Output: ");
        System.out.println(l1);
    }

    static void insertionSort(Integer[] arr) {
        // GPT Code
        // for (int i = 1; i < arr.length; i++) {
        // int key = arr[i];
        // int j = i - 1;
        // while (j >= 0 && arr[j] > key) {
        // arr[j + 1] = arr[j];
        // j--;
        // }
        // arr[j + 1] = key;
        // }
        //
        // Sorting is happening here
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            System.out.println(new ArrayList<Integer>(Arrays.asList(arr)));
        }
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Insertion Sort Output: ");
        System.out.println(l1);
    }

    static void mergeSort(Integer[] arr) {

        // Sorting is happening here
        Integer[] res = divide(arr);
        //
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(res));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Bubble Sort Output: ");
        System.out.println(l1);
    }

    static Integer[] divide(Integer[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        Integer[] firstHalf = Arrays.copyOfRange(arr, 0, n / 2);
        Integer[] secondHalf = Arrays.copyOfRange(arr, n / 2, n);

        firstHalf = divide(firstHalf);
        secondHalf = divide(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(arr1));
        ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(arr2));
        System.out.println("Left: " + l2);
        System.out.println("Right: " + l3);
        while (l2.size() > 0 && l3.size() > 0) {
            if (l2.get(0) <= l3.get(0)) {
                l1.add(l2.remove(0));
            } else {
                l1.add(l3.remove(0));
            }
        }
        l1.addAll(l2);
        l1.addAll(l3);
        System.out.println("Sorted List: " + l1);
        return l1.toArray(new Integer[0]);
    }
}
