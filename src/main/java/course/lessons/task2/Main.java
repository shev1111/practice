package course.lessons.task2;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(FibonacciNumber.findWithNoRecursion(10));
        System.out.println(FibonacciNumber.findWithRecursion(10));
        System.out.println(Factorial.calculate("3"));


       int [] arr1 = new int[]{1,5,2,7,0};
       int [] arr2 = new int[]{1,5,2,7,0};
       int [] arr3 = new int[]{1,5,2,7,0};
       System.out.println(Arrays.toString(arr1));
       System.out.println("Bubble sort: "+Arrays.toString(SortAlgorithms.bubbleSort(arr1)));
       System.out.println("Selection sort: "+Arrays.toString(SortAlgorithms.selectionSort(arr2)));
       System.out.println("Merge sort: "+Arrays.toString(SortAlgorithms.mergeSort(arr3)));


    }
}
