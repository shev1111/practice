package course.lessons.task2;

class FibonacciNumber {

    static int findWithNoRecursion(int position){
        int number1 = 0;
        int number2 = 1;
        int number3 = number1+number2;
        if(position<=1)return position;
        for(int positionIndex=2;positionIndex<=position;positionIndex++){
            number3=number1+number2;
            number1=number2;
            number2=number3;
        }
        return number3;
    }

    static int findWithRecursion(int position){
        if (position <= 1){
            return position;
        }
        return findWithRecursion(position - 1) + findWithRecursion(position - 2);
    }
}
