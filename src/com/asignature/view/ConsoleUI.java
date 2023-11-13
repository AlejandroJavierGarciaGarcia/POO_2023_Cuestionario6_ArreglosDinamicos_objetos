package com.asignature.view;
/**
 * @version 1.0
 * @author Alejandro García
 * @since 13/11/2023
 */

import com.asignature.bean.Student;
import com.asignature.controller.StudentController;
import com.asignature.controller.ValidationController;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner in = new Scanner(System.in);
    private ValidationController validations = new ValidationController();
    /**
     * Runs the console application.
     */
    public void run(){
        welcome();
        mainMenu(in);
    }
    /**
     * Displays a welcome message.
     */
    private void welcome(){
        System.out.println("--------------------------------------------");
        System.out.println("|    BIENVENIDO A GESTOR DE ASIGNATURAS     |                                                  |");
        System.out.println("--------------------------------------------");
    }
    /**
     * Displays the main menu and handles user input.
     *
     * @param in Scanner for user input
     */
    private void mainMenu(Scanner in){
        boolean isValid = false;
        do {
            try {
                System.out.println("\nMENÚ PRINCIPAL:");
                System.out.println("Elija su opción de su interés:");
                System.out.println(" 1. Agregar usuario");
                System.out.println(" 2. Estadisticas");
                System.out.println(" 7. Salir");

                String op = in.nextLine();
                switch (op) {
                    case "1":
                        System.out.println("\n*AGREGAR USUARIO*");
                        registerUser(in);
                    case "2":
                        System.out.println("\n*ESTADÍSTICA* ");
                        break;

                    case "3":
                        isValid = true;
                        break;

                    default:
                        throw new Exception("Opción no válida. Vuelva a intentarlo");
                }
            } catch (Exception e) {
                System.out.println(" Información del proceso: " + e.getMessage());
                e.printStackTrace();
            }
        }while (!isValid);    }

    /**
     * Registers a new student by gathering user input for name, courses, and grades.
     *
     * @param in Scanner for user input
     */
    private void registerUser(Scanner in){
        try {
            boolean isValid = false;
            String name;
            // INGRESO DEL NOMBRE
            do {
                System.out.println("\n  ⮞ Ingrese su nombre completo:");
                name = in.nextLine();
                isValid = validations.notEmpty(name);

            } while (!isValid);

            // INGRESO TOTAL DE CURSO
            isValid = false;

            String totalCurses;
            do {
                System.out.println("\n  ⮞ Ingrese el total de cursos por agregar:");
                totalCurses = in.nextLine();
                isValid = validations.checkInteger(totalCurses);

            } while (!isValid);
            ArrayList<String> cursesToAdd = new ArrayList<String>();
            ArrayList<String> gradesToAdd = new ArrayList<String>();

            for (int i=0;i<Integer.parseInt(totalCurses);i++){
                // INGRESO DEL CURSO
                isValid = false;

                String curse;
                do {
                    System.out.println("\n  ⮞ Ingrese nombre del curso:");
                    curse = in.nextLine();
                    isValid = validations.notEmpty(curse);

                } while (!isValid);

                // INGRESO DEL GRADOS
                isValid = false;

                String grades;
                do {
                    System.out.println("\n  ⮞ Ingrese la calificacion:");
                    grades = in.nextLine();
                    isValid = validations.checkInteger(grades);
                    if(Integer.parseInt(grades)<0&&Integer.parseInt(grades)>100){
                        System.out.println(" * La calificación debe ser un número entre 0 y 100");
                        isValid=false;
                    }else {
                        isValid = true;
                    }
                } while (!isValid);
                cursesToAdd.add(curse);
                cursesToAdd.add(grades);
            }

            try{
                Student newStudent = new Student(name,cursesToAdd,gradesToAdd,0);
                StudentController.currentStudents.add(newStudent);
            }catch (Exception e){
                System.out.println(" * Proceso interrumpido, vuelva a intentarlo");
            }


        } catch (Exception e) {
            System.out.println("ERROR al ingresar información"+e.getMessage());
        }

    }



}
