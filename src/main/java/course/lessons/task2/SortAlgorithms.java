package course.lessons.task2;

import java.util.Arrays;

class SortAlgorithms {
   static int[] bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index+1]) {
                    temp = array[index];
                    array[index] = array[index+1];
                    array[index+1] = temp;
                    sorted = false;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int arrIndex = 0; arrIndex < array.length; arrIndex++) {
            int min = array[arrIndex];
            int minId = arrIndex;
            //find min
            for (int minIndex = arrIndex+1; minIndex < array.length; minIndex++) {
                if (array[minIndex] < min) {
                    min = array[minIndex];
                    minId = minIndex;
                }
            }
            // swapping
            int temp = array[arrIndex];
            array[arrIndex] = min;
            array[minId] = temp;
        }
        return array;
    }

    static int [] mergeSort(int[] inputArray) {
       int length = inputArray.length;
       if (length < 2) {
            return inputArray;
        }

        int remainder = length % 2;
        int mid = length / 2;
        int[] left = Arrays.copyOf(inputArray,mid+remainder);
        int[] right = Arrays.copyOfRange(inputArray,length - mid, length);
        mergeSort(left);
        mergeSort(right);
        merge(inputArray, left, right);

        return inputArray;
    }

    private static void merge(int[] outputArray, int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int outputIndex = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                outputArray[outputIndex++] = leftArray[leftIndex++];
            }
            else {
                outputArray[outputIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length) {
            outputArray[outputIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            outputArray[outputIndex++] = rightArray[rightIndex++];
        }
    }
}
