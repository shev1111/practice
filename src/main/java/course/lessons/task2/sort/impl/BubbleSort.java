package course.lessons.task2.sort.impl;

import course.lessons.task2.sort.Sortable;
import course.lessons.task2.sort.util.SortUtils;

public class BubbleSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index+1]) {
                    SortUtils.swapArrayElements(array,index,index+1);
                    sorted = false;
                }
            }
        }
        return array;
    }
}
