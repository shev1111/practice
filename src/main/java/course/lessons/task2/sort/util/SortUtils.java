package course.lessons.task2.sort.util;

public class SortUtils {
    public static void swapArrayElements(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex]=temp;
    }
}
