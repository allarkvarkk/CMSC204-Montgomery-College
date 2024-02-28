import java.util.Arrays;

public class ArraySumDriver {
    private final static int ARRAY_SIZE = 6;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int index = 0;

        Integer[] myArray = new Integer[ARRAY_SIZE];
        Integer[] student_test = {10, 20, 35, 48, 50, 62, 75, 83, 95, 100,
                110, 125, 130, 145, 150, 162, 175, 183, 195, 200,
                210, 225, 230, 245, 250, 262, 275, 283, 295, 300};
        ArraySum arraySum = new ArraySum();

        myArray[index++] = 3;
        myArray[index++] = 5;
        myArray[index++] = 2;
        myArray[index++] = 6;

        int sum = arraySum.sumOfArray(myArray, 3);
        System.out.println(sum);

        myArray[index++] = 7;
        myArray[index++] = 1;

        sum = arraySum.sumOfArray(myArray, 5);
        System.out.println(sum);
        System.out.println("student test should be 300  -> " + arraySum.sumOfArray(student_test,6)); //should be 300
        System.out.println("student test should be 2153 -> " + arraySum.sumOfArray(student_test, 19)); //should be 2153
        System.out.println("student test should be 4728 -> " + arraySum.sumOfArray(student_test, 29)); //should be 4728
    }

}