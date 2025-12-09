import java.util.Scanner;

public class StudentReportCardSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ==========================================
        // 1. CONFIGURATION
        // ==========================================
        // You can change this to 15 to match the image exactly,
        // but the requirement said "at least 12".
        final int NUM_STUDENTS = 12;
        final int NUM_SUBJECTS = 6;

        // Arrays to store student data
        String[] studentNames = new String[NUM_STUDENTS];
        double[][] marks = new double[NUM_STUDENTS][NUM_SUBJECTS]; // Rows=Students, Cols=Subjects
        double[] studentTotals = new double[NUM_STUDENTS];
        String[] studentRanks = new String[NUM_STUDENTS];

        // Subject names based on your image
        String[] subjects = {"English", "Math", "History", "Geography", "Science", "Programming"};

        // ==========================================
        // 2. INPUT SCHOOL DETAILS
        // ==========================================
        System.out.println("Enter School Details...");
        System.out.print("School Name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Teacher Name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Clear the "enter" key from the buffer

        // ==========================================
        // 3. INPUT STUDENT RECORDS
        // ==========================================
        System.out.println("\nEntering records for " + NUM_STUDENTS + " students...");

        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("Name: ");
            studentNames[i] = scanner.nextLine();

            double sum = 0;
            // Loop through the 6 subjects to get marks
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                System.out.print("Marks for " + subjects[j] + ": ");
                marks[i][j] = scanner.nextDouble();
                sum += marks[i][j];
            }
            scanner.nextLine(); // Clear buffer after reading numbers

            // Store the total
            studentTotals[i] = sum;

            // Determine Rank immediately
            if (sum >= 540) studentRanks[i] = "A";
            else if (sum >= 480) studentRanks[i] = "B";
            else if (sum >= 420) studentRanks[i] = "C";
            else if (sum >= 360) studentRanks[i] = "D";
            else studentRanks[i] = "F";
        }

        // ==========================================
        // 4. CALCULATE CLASS STATISTICS
        // ==========================================
        double[] subjectColumnTotals = new double[NUM_SUBJECTS];
        double[] subjectColumnAvgs = new double[NUM_SUBJECTS];
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        double classGrandTotal = 0;
        double classGrandAvg = 0;

        // Calculate Column Totals & Averages
        for (int j = 0; j < NUM_SUBJECTS; j++) {
            double colSum = 0;
            for (int i = 0; i < NUM_STUDENTS; i++) {
                colSum += marks[i][j];
            }
            subjectColumnTotals[j] = colSum;
            subjectColumnAvgs[j] = colSum / NUM_STUDENTS;
            classGrandTotal += colSum; // Add to grand total
        }

        classGrandAvg = classGrandTotal / NUM_STUDENTS;







        // Count Ranks
        for (String r : studentRanks) {
            if (r.equals("A")) countA++;
            else if (r.equals("B")) countB++;
            else if (r.equals("C")) countC++;
            else if (r.equals("D")) countD++;
            else countF++;
        }

        // ==========================================
        // 5. GENERATE REPORT (MATCHING IMAGE)
        // ==========================================
        String dashedLine = "----------------------------------------------------------------------------------------------------------------";
        String doubleLine = "================================================================================================================";

        System.out.println("\n\n" + dashedLine);
        // Center the header info roughly
        System.out.printf("%50s %s\n", "School Name:", schoolName);
        System.out.printf("%50s %s\n", "Teacher:", teacherName);
        System.out.printf("%50s %s\n", "Grade:", grade);
        System.out.printf("%50s %d\n", "Year:", year);
        System.out.println(dashedLine);

        // Header Row
        // %-20s means left align 20 chars. %9s means right align 9 chars.
        System.out.printf("%-20s %9s %9s %9s %9s %9s %11s %8s %4s\n",
                "Student Name", "English", "Math", "History", "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println(doubleLine);

        // Student Data Rows
        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.printf("%-20s %9.2f %9.2f %9.2f %9.2f %9.2f %11.2f %8.2f %4s\n",
                    studentNames[i],
                    marks[i][0], marks[i][1], marks[i][2], marks[i][3], marks[i][4], marks[i][5],
                    studentTotals[i],
                    studentRanks[i]
            );
        }

        System.out.println(dashedLine);

        // Footer: Totals
        System.out.printf("%-20s", ""); // Empty space under name
        for (double val : subjectColumnTotals) {
            System.out.printf("%9.2f ", val);
        }
        System.out.printf("%8.2f\n", classGrandTotal); // Grand Total

        System.out.println(dashedLine);

        // Footer: Averages
        System.out.printf("%-20s", ""); // Empty space under name
        for (double val : subjectColumnAvgs) {
            System.out.printf("%9.2f ", val);
        }
        System.out.printf("%8.2f\n", classGrandAvg); // Average of Totals

        System.out.println(doubleLine);

        // Rank Summary
        System.out.printf("Ranks    A's: %-3d    B's: %-3d    C's: %-3d    D's: %-3d    F's: %-3d\n",
                countA, countB, countC, countD, countF);

        scanner.close();
    }
}