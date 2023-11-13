package com.asignature.controller;

import com.asignature.bean.Student;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Alejandro García
 * @since 13/11/2023
 */
public class StudentController {
    public static ArrayList<Student> currentStudents = new ArrayList<Student>();
    /**
     * Calculates and prints statistics related to students, such as the highest average, lowest average,
     * subject with the most passing students, subject with the most failing students, and the student with the best average.
     */
    public void statistics() {
        if (currentStudents.isEmpty()) {
            System.out.println("No students registered to calculate statistics.");
            return;
        }

        double maxAverage = Double.MIN_VALUE;
        double minAverage = Double.MAX_VALUE;
        String subjectWithMaxPass = "";
        String subjectWithMaxFail = "";
        double maxSubjectPassCount = 0;
        double maxSubjectFailCount = 0;
        Student studentWithBestAverage = null;

        for (Student student : currentStudents) {
            ArrayList<String> grades = student.getGrades();

            double average = calculateAverage(grades);

            if (average > maxAverage) {
                maxAverage = average;
                studentWithBestAverage = student;
            }
            if (average < minAverage) {
                minAverage = average;
            }


        }

        System.out.println("Statistics:");
        System.out.println("Highest average: " + maxAverage + " (Student: " + studentWithBestAverage.getName() + ")");
        System.out.println("Lowest average: " + minAverage);
        System.out.println("Subject with the most passes: " + subjectWithMaxPass);
        System.out.println("Subject with the most fails: " + subjectWithMaxFail);
    }

    /**
     * Calculates the average of a list of grades.
     *
     * @param grades The list of grades to calculate the average.
     * @return The calculated average.
     */
    private double calculateAverage(ArrayList<String> grades) {
        double sum = 0;
        for (String grade : grades) {
            sum += Double.parseDouble(grade);
        }
        return sum / grades.size();
    }


}