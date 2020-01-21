package course.lessons.task2;

class FibonacciNumber {

    static int findWithNoRecursion(int position){
        int previousNumber = 0;
        int nextNumber = 1;

        for (int index = 1; index < position; index++)
        {
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }

        return nextNumber;
    }

    static int findWithRecursion(int position){
        if(position == 0){
            return 0;
        }
        if(position == 1 || position == 2){
            return 1;
        }
        return findWithRecursion(position - 1) + findWithRecursion(position - 2);
    }
}
