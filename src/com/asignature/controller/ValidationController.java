/**
 * @version 1.0
 * @author Alejandro García & Jonathan Zacarías
 * @since 25/09/2023
 */
/**
 * Commented with AI
 * The ValidationController class in Java provides methods for validating different types of resources
 * such as books, DVDs, scientific articles, newspapers, and theses.
 */
package com.amparocodinacampollo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ValidationController {
    /**
     * Validates the data of a book resource.
     *
     * @param bookData An array of strings containing book data.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> validateBook(String[] bookData) {
        ArrayList<String> validationMessages = new ArrayList<>();

        String isbn = bookData[1].trim();
        if (!isValidISBN(isbn)) {
            validationMessages.add("Formato de ISBN no válido.");
        }

        String descriptiveFormat = bookData[3].trim();
        if (!isValidDescriptiveFormat(descriptiveFormat)) {
            validationMessages.add("Formato descriptivo no válido.");
        }

        String pages = bookData[4].trim();
        if (!isValidPageCount(pages)) {
            validationMessages.add("Número de páginas no válido.");
        }

        return validationMessages;
    }

    /**
     * Private helper method to validate the format of an ISBN.
     *
     * @param isbn The ISBN to be validated.
     * @return true if the ISBN is in a valid format, false otherwise.
     */
    private boolean isValidISBN(String isbn) {
        return isbn.matches("\\d{13}");  //  ISBN-13 con 13 dígitos
    }

    /**
     * Private helper method to validate the descriptive format.
     *
     * @param descriptiveFormat The descriptive format to be validated.
     * @return true if the descriptive format is valid, false otherwise.
     */
    private boolean isValidDescriptiveFormat(String descriptiveFormat) {
        // Implementa la lógica de validación para el formato descriptivo
        return descriptiveFormat.length() > 0;
    }

    /**
     * Private helper method to validate the page count.
     *
     * @param pages The page count to be validated.
     * @return true if the page count is valid, false otherwise.
     */
    private boolean isValidPageCount(String pages) {

        try {
            int pageCount = Integer.parseInt(pages);
            return pageCount > 0;
        } catch (NumberFormatException e) {
            return false;  // No es un número válido
        }
    }
    /**
     * Validates the data of a DVD resource.
     *
     * @param dvdData An array of strings containing DVD data.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> validateDVD(String[] dvdData) {
        // Validaciones específicas para el tipo de recurso "DVD"
        ArrayList<String> validationMessages = new ArrayList<>();

        // Validación del título de la película
        String filmTitle = dvdData[3].trim();
        if (filmTitle.isEmpty()) {
            validationMessages.add("El título de la película no puede estar vacío.");
        }

        // Validación de los directores de la película
        String filmDirectors = dvdData[1].trim();
        if (filmDirectors.isEmpty()) {
            validationMessages.add("Se requiere al menos un director de la película.");
        }


        return validationMessages;
    }

    /**
     * Validates the data of a scientific article resource.
     *
     * @param articleData An array of strings containing article data.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> validateScientificArticle(String[] articleData) {
        ArrayList<String> validationMessages = new ArrayList<>();

        String articleTitle = articleData[3].trim();
        if (articleTitle.isEmpty()) {
            validationMessages.add("El título del artículo científico no puede estar vacío.");
        }

        String authors = articleData[1].trim();
        if (authors.isEmpty()) {
            validationMessages.add("Se requiere al menos un autor para el artículo científico.");
        }


        return validationMessages;
    }

    /**
     * Validates the data of a newspaper resource.
     *
     * @param newspaperData An array of strings containing newspaper data.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> validateNewspaper(String[] newspaperData) {
        ArrayList<String> validationMessages = new ArrayList<>();

        String articleTitle = newspaperData[4].trim();
        if (articleTitle.isEmpty()) {
            validationMessages.add("El título del artículo en el periódico no puede estar vacío.");
        }

        String newspaperName = newspaperData[5].trim();
        if (newspaperName.isEmpty()) {
            validationMessages.add("El nombre del periódico no puede estar vacío.");
        }


        return validationMessages;
    }

    /**
     * Validates the data of a thesis resource.
     *
     * @param thesisData An array of strings containing thesis data.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> validateThesis(String[] thesisData) {
        ArrayList<String> validationMessages = new ArrayList<>();

        // Validación del título de la tesis
        String title = thesisData[2].trim();
        if (title.isEmpty()) {
            validationMessages.add("El título de la tesis no puede estar vacío.");
        }

        // Validación del año de publicación
        int publicationYear;
        try {
            publicationYear = Integer.parseInt(thesisData[3].trim());
            if (publicationYear < 1000) {
                validationMessages.add("El año de publicación de la tesis debe ser un número válido.");
            }
        } catch (NumberFormatException e) {
            validationMessages.add("El año de publicación de la tesis debe ser un número válido.");
        }


        return validationMessages;
    }


    /**
     * Performs general validations on resource data based on its type.
     *
     * @param resourceData An array of strings containing the data of a resource. The first element of
     * the array is assumed to be the type of the resource, and the remaining elements contain specific
     * data related to that type of resource.
     * @return An ArrayList of validation messages.
     */
    public ArrayList<String> resourcesValidation(String[] resourceData) {
        ArrayList<String> validationMessages = new ArrayList<>();

        // Determinar el tipo de recurso y aplicar validaciones específicas
        String type = resourceData[0].trim();

        switch (type.toLowerCase()) {
            case "B":
                validationMessages.addAll(validateBook(resourceData));
                break;
            case "D":
                validationMessages.addAll(validateDVD(resourceData));
                break;
            case "S":
                validationMessages.addAll(validateScientificArticle(resourceData));
                break;
            case "N":
                validationMessages.addAll(validateNewspaper(resourceData));
                break;
            case "T":
                validationMessages.addAll(validateThesis(resourceData));
                break;
            default:
                validationMessages.add("Tipo de recurso no válido.");
                break;
        }


        return validationMessages;
    }


    /**
     * Checks if a date string has a valid format (dd-MM-yyyy).
     *
     * @param dateStr The date string to be checked.
     * @return true if the date string is in a valid format, false otherwise.
     */
    public boolean checkFormatDate(String dateStr) {
        /**
         * Método reutilizado de programa elaborado anteriormente
         *
         * */
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

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