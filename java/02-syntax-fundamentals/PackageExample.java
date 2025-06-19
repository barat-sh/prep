// Package declaration would normally be here
// package com.example.demo;

/**
 * This class demonstrates how packages work in Java.
 * In a real project, this file would be in a folder structure matching the package name.
 */
public class PackageExample {
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Using a class from the java.util package
        java.util.Date today = new java.util.Date();
        System.out.println("Current date and time: " + today);
        
        // Using a class with an import statement
        // If this were a real file with imports, we could just use:
        // Date today = new Date();
        
        // Create an instance of our custom class
        Calculator calc = new Calculator();
        
        // Use the calculator
        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("5 - 3 = " + calc.subtract(5, 3));
        System.out.println("5 * 3 = " + calc.multiply(5, 3));
        System.out.println("5 / 3 = " + calc.divide(5, 3));
    }
}

/**
 * A simple calculator class to demonstrate class definition
 * In a real project, this would typically be in its own file
 */
class Calculator {
    
    /**
     * Adds two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts the second number from the first
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides the first number by the second
     * Returns the result as a double for precision
     */
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero");
            return 0;
        }
        return (double) a / b;
    }
}