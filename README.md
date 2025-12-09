# Student Performance Report System

A Java console application designed to collect student examination data, compute grades based on performance, and generate a professionally formatted class report.

# Overview

This project simulates a school grading system. It accepts input for school details and student marks across 6 subjects, processes the data to determine ranks (A-F), and outputs a high-fidelity text-based report that replicates a standard academic performance sheet.

The application demonstrates mastery of:
* Arrays, Loops, and Control Flow.

# Features

* Captures School Name, Teacher Name, Grade, and Year.
* Calculates total marks and assigns a Rank (A, B, C, D, F) automatically based on a predefined scale.
* Class Statistics:
    * Calculates total marks per subject (vertical sum).
    * Calculates average marks per subject.
    * Computes the Grand Total and Class Average.
    * Provides a count summary of all Ranks (e.g., A's: 4, B's: 4).
*  Generates a clean, aligned table matching official report formats.

# Prerequisites

* *Java Development Kit (JDK): Version 8 or higher.

# How to Run

1.  **Save the Code
    Ensure your Java file is named `Main.java`.

2.  **Compile the Program
    Open your terminal or command prompt and run:
    ```bash
    javac Main.java
    ```

3.  **Run the Application
    Execute the compiled class:
    ```bash
    java Main
    ```

# Configuration

To adjust the class size or subjects, modify the constants at the top of the `main` method in `Main.java`:

```java
final int NUM_STUDENTS = 12; // Change this to test with fewer/more students
final int NUM_SUBJECTS = 6;# Java_student_scoresheet




<img width="1280" height="960" alt="image" src="https://github.com/user-attachments/assets/e18d2666-0da3-49b8-b667-51c4900650ee" />
