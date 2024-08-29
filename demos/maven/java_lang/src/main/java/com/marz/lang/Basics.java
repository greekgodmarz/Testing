/*
 * Pick or create your license to be shown here...
 */

package com.marz.lang;

/**
 * Class to illustrate basic Java language features
 * 
 * @author relivian
 */
public class Basics {

  /**
   * The "main" method is the programs entry point. This method is called when
   *  a programs is started.
   * @param args 
   */
    public static void main(String[] args) {
        // Run different demonstrations of Java language features
        runNumericalOperations();
        runStringOperations();
        runControlStatements();
        runLoopStatements();
        runMethodExamples();
        runClassAndObjectExamples();
        runErrorHandlingExamples();
    }

    // Method to demonstrate numerical operations and variable declarations
    public static void runNumericalOperations() {
        int intVar = 10;
        short shortVar = 20;
        float floatVar = 15.5f;
        double doubleVar = 30.25;

        // Basic arithmetic operations
        int sum = intVar + shortVar;
        double product = floatVar * doubleVar;
        double division = doubleVar / intVar;

        System.out.println("Numerical Operations:");
        System.out.println("Sum of int and short: " + sum);
        System.out.println("Product of float and double: " + product);
        System.out.println("Division of double by int: " + division);
        System.out.println();
    }

    // Method to demonstrate String operations
    public static void runStringOperations() {
        String greeting = "Hello";
        String name = "World";
        String fullGreeting = greeting + " " + name + "!";
        int nameLength = name.length();

        System.out.println("String Operations:");
        System.out.println("Full Greeting: " + fullGreeting);
        System.out.println("Length of name: " + nameLength);
        System.out.println();
    }

    // Method to demonstrate control statements (if/else, switch)
    public static void runControlStatements() {
        int number = 10;

        System.out.println("Control Statements:");

        // If/Else statement
        if (number > 0) {
            System.out.println("Number is positive");
        } else if (number < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is zero");
        }

        // Switch/Case statement
        switch (number) {
            case 0:
                System.out.println("Number is zero");
                break;
            case 10:
                System.out.println("Number is ten");
                break;
            default:
                System.out.println("Number is neither zero nor ten");
                break;
        }
        System.out.println();
    }

    // Method to demonstrate loop statements (for, while, do-while)
    public static void runLoopStatements() {
        System.out.println("Loop Statements:");

        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println("For loop iteration: " + i);
        }

        // While loop
        int count = 0;
        while (count < 5) {
            System.out.println("While loop iteration: " + count);
            count++;
        }

        // Do-While loop
        int number = 5;
        do {
            System.out.println("Do-While loop number: " + number);
            number--;
        } while (number > 0);

        System.out.println();
    }

    // Method to demonstrate method usage (defining, calling, and returning values)
    public static void runMethodExamples() {
        int a = 5;
        int b = 3;
        int sum = add(a, b);
        String message = "Hello from a method!";

        System.out.println("Method Examples:");
        System.out.println("Sum of " + a + " and " + b + ": " + sum);
        printMessage(message);
        System.out.println();
    }

    // Supporting methods for runMethodExamples()
    public static int add(int x, int y) {
        return x + y;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Method to demonstrate class and object usage
    public static void runClassAndObjectExamples() {
        Person person = new Person("John", 25);

        System.out.println("Class and Object Examples:");
        System.out.println("Person Name: " + person.getName());
        System.out.println("Person Age: " + person.getAge());
        person.sayHello();
        System.out.println();
    }

    // Supporting class for runClassAndObjectExamples()
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void sayHello() {
            System.out.println("Hello, my name is " + name);
        }
    }

    // Method to demonstrate error handling
    public static void runErrorHandlingExamples() {
        System.out.println("Error Handling Examples:");
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("This is the finally block, always executed.");
        }
        System.out.println();
    }

    // Supporting method for runErrorHandlingExamples()
    public static int divide(int x, int y) {
        return x / y;
    }
}
