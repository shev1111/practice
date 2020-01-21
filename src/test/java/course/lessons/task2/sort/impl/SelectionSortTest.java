package course.lessons.task2.sort.impl;


import course.lessons.task2.sort.Sortable;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SelectionSortTest {
    private int[] array = new int[]{8,1,4,0,20,30,3};

    @Test
    public void bubbleSortTest() {
        Sortable selectionSort = new SelectionSort();
        selectionSort.sort(array);
        assertTrue(array[array.length-1]==30);
    }
}