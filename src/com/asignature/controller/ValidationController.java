/**
 * @version 1.0
 * @author Alejandro García
 * @since 13/11/2023
 */
/**
 * Commented with AI
 * The ValidationController class in Java provides methods for validating different types of resources
 * such as books, DVDs, scientific articles, newspapers, and theses.
 */
package com.asignature.controller;
public class ValidationController {
    /**
     * Checks if a string is not empty and does not contain numeric digits.
     *
     * @param id The string to be checked.
     * @return true if the string is not empty and does not contain numeric digits, false otherwise.
     */
    public boolean validString(String id) {
        if (id.trim().isEmpty()) {
            System.out.println("la información no puede ser vacía."); ;
            return false;

        } else if (id.matches("^[0-9]+$")) {
            System.out.println("Formato no válido. No debe contener números.");
            return false;

        } else {
            return true;
        }
    }

    /**
     * Checks if a string is not empty.
     *
     * @param id The string to be checked.
     * @return true if the string is not empty, false otherwise.
     */
    public boolean notEmpty (String id){
        if (id.trim().isEmpty()) {
            System.out.println("Esta información no puede ser vacía.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if a string contains only integer digits.
     *
     * @param id The string to be checked.
     * @return true if the string contains only integer digits, false otherwise.
     */
    public boolean checkInteger (String id){
        if (id.trim().isEmpty()) {
            System.out.println("El dato no puede ser vacío.");
            return false;
        } else if (!id.matches("^[0-9]+$")) {
            System.out.println("Formato no válido. Debe contener únicamente números.");
            return false;
        } else {
            return true;
        }
    }
}