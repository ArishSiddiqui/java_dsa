import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainClass {

    public static void main(String[] args) {
        Integer[] arr = { 4, 5, 0, 1, 2, 9 };
        // bubbleSort();
        // selectionSort();
        insertionSort(arr);
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
            for (int j = i + 1; j < arr.length; j++) {
                int minNumIndex = i;
                if (arr[j] < arr[minNumIndex]) {
                    minNumIndex = j;
                }
                int temp = arr[i];
                arr[i] = arr[minNumIndex];
                arr[minNumIndex] = temp;
            }
        }
        //
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Selection Sort Output: ");
        System.out.println(l1);
    }

    static void insertionSort(Integer[] arr) {
        System.out.println("Input: ");
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
        }
        //
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr));
        // l1.sort((a, b) -> a.compareTo(b));
        System.out.println("List Size = " + l1.size());
        System.out.println("Insertion Sort Output: ");
        System.out.println(l1);
    }
}
