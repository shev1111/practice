package course.lessons.task2.sort.impl;

import course.lessons.task2.sort.Sortable;
import course.lessons.task2.sort.util.SortUtils;

public class SelectionSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        for (int arrIndex = 0; arrIndex < array.length; arrIndex++) {
            int min = array[arrIndex];
            int minId = arrIndex;

            for (int minIndex = arrIndex+1; minIndex < array.length; minIndex++) {
                if (array[minIndex] < min) {
                    min = array[minIndex];
                    minId = minIndex;
                }
            }
            /*int temp = array[arrIndex];
            array[arrIndex] = min;
            array[minId] = temp;*/
            SortUtils.swapArrayElements(array,arrIndex,minId);
        }
        return array;
    }
}
