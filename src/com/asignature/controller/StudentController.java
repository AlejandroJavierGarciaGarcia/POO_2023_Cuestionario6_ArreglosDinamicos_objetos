package com.asignature.controller;

import com.asignature.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author Alejandro García
 * @since 13/11/2023
 */
public class StudentController {
    public static ArrayList<Student> currentStudents = new ArrayList<Student>();

    /**
     * Checks if a student with the given ID is present in the currentStudents array.
     *
     * @param studentCarnet The ID of the student to check.
     * @return true if the student is present, false otherwise.
     * Documentation> https://www.w3schools.com/java/java_hashmap.asp
     * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
     * Documnetación para el uso de métodos de map generado con IA
     */
    public boolean isCarnetRegister(String studentCarnet) {
        for (Student student : currentStudents) {
            if (studentCarnet.equals(student.getCarnet())) {
                System.out.println(" * EL carnet ya se encuntra registardo. Vuelva a intentarlo");
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates and prints statistics related to students, such as the highest average, lowest average,
     * subject with the most passing students, subject with the most failing students, and the student with the best average.
     */
    public void statistics() {
        if (currentStudents.isEmpty()) {
            System.out.println("No hay estudiantes registrados para calcular estadísticas.");

        }else {
            for (Student student : currentStudents) {
                System.out.println("------------------------------");

                System.out.println("Estudiante: " + student.getName() + " (Carnet: " + student.getCarnet() + ")");
                System.out.println("Cursos: " + student.getCurses());
                System.out.println("Calificaciones: " + student.getGrades());
            }

            double totalAverageByStudent = 0;
            double totalAverageByGrade = 0;
            System.out.println("");
            int totalCurses = 0;
            for (Student student : currentStudents) {
                totalAverageByStudent += student.getAvage();
                totalCurses = totalCurses + student.getCurses().size();
            }

            double averageByStudent = totalAverageByStudent / totalCurses;

            System.out.println("Promedio por estudiante: " + averageByStudent);
        }
    }

    private double calculateGradeAverage(ArrayList<String> grades) {
        double total = 0;
        for (String grade : grades) {
            total += Double.parseDouble(grade);
        }
        return total / grades.size();
    }
}