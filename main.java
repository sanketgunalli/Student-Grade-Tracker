import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Grade");
            System.out.println("2. View Grades");
            System.out.println("3. Compute Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the grade (0-100): ");
                    double grade = scanner.nextDouble();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    }
                    break;
                case 2:
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded.");
                    } else {
                        System.out.println("Grades: " + grades);
                    }
                    break;
                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded. Add grades first.");
                    } else {
                        computeStatistics(grades);
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void computeStatistics(ArrayList<Double> grades) {
        double sum = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;

        for (double grade : grades) {
            sum += grade;
            if (grade > max) max = grade;
            if (grade < min) min = grade;
        }

        double average = sum / grades.size();

        System.out.println("\n--- Statistics ---");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);
    }
}
