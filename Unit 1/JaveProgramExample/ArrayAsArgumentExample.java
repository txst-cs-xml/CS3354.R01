public class ArrayAsArgumentExample {

    // Method that takes an array of integers as an argument
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create an array
        int[] numbers = { 1, 2, 3, 4, 5 };

        // Call the method and pass the array as an argument
        printArray(numbers);

        // The array can be modified within the method
        incrementArrayValues(numbers);

        // Verify the changes outside the method
        printArray(numbers);
    }

    // Method that modifies elements of an array
    public static void incrementArrayValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }


    }


}
