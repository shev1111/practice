package course.lessons.task2.sort.impl;

import course.lessons.task2.sort.Sortable;

import java.util.Arrays;

public class MergeSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        int remainder = length % 2;
        int mid = length / 2;
        int[] left = Arrays.copyOf(array,mid+remainder);
        int[] right = Arrays.copyOfRange(array,length - mid, length);

        sort(left);
        sort(right);
        merge(array, left, right);

        return array;
    }



    private void merge(int[] outputArray, int[] leftArray, int[] rightArray) {
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
