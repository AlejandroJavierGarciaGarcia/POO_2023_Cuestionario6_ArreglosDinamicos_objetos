package com.asignature.bean;
/**
 * @version 1.0
 * @author Alejandro García
 * @since 13/11/2023
 */
import java.util.ArrayList;

public class Student {
    private String name;
    private String carnet;

    private ArrayList<String> curses;
    private ArrayList<String> grades;
    private double avage;

    public Student(String name, String carnet, ArrayList<String> curses, ArrayList<String> grades, double avage) {
        this.name = name;
        this.carnet = carnet;
        this.curses = curses;
        this.grades = grades;
        this.avage = avage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCurses() {
        return curses;
    }

    public void setCurses(ArrayList<String> curses) {
        this.curses = curses;
    }

    public ArrayList<String> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
    }

    public double getAvage() {
        return avage;
    }

    public void setAvage(double avage) {
        this.avage = avage;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}
