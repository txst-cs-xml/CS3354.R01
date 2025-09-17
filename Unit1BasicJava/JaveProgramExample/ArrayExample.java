public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        printArray(numbers);
    }
    
    // Method that takes an array as a parameter
    public static void printArray(int[] arr) {
        for (int i = 0; i<5; i++) {
            System.out.print(arr[i] + " ");
            arr[i]++;
        }
        System.out.print("\n\n");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
