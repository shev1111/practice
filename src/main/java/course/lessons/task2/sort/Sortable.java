package course.lessons.task2.sort;

public interface Sortable <T extends Comparable<T>> {
    int[] sort(int[] array);
}