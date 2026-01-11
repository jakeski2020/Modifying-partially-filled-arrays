import java.util.Scanner;
public class PartiallyFilledB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] scores = new double[10];
        int count = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;
        System.out.println("Enter test scores (or 'q' to quit):");
        while (count < scores.length) {
            System.out.print("Score " + (count + 1) + ": ");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                double score = Double.parseDouble(input);
                scores[count] = score;
                sum += score;
                if (score > max) {
                    max = score;
                }
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q'.");
            }
        }
        count = insert(scores, count, 0, 100.0);
        if (count > 0) {
            sum = 0;
            max = Double.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                sum += scores[i];
                if (scores[i] > max) {
                    max = scores[i];
                }
            }
            double average = sum / count;
            System.out.println("Number of scores entered: " + count);
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Maximum score: %.2f%n", max);
        } else {
            System.out.println("\nNo test scores were entered.");
        }
    }
    public static int insert(double[] array, int currentSize, int targetIndex, double newElement) {
        if (targetIndex < 0 || targetIndex > currentSize || currentSize >= array.length) {
            return currentSize;
        }
        for (int i = currentSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }
        array[targetIndex] = newElement;
        return currentSize + 1;
    }
}
