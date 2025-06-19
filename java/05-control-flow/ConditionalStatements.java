/**
 * This class demonstrates the use of conditional statements in Java
 */
public class ConditionalStatements {
    public static void main(String[] args) {
        System.out.println("=== Conditional Statements in Java ===\n");
        
        // Simple if statement
        System.out.println("--- Simple if Statement ---");
        int age = 20;
        
        if (age >= 18) {
            System.out.println("You are an adult.");
        }
        
        // if-else statement
        System.out.println("\n--- if-else Statement ---");
        int temperature = 15;
        
        if (temperature > 30) {
            System.out.println("It's hot outside.");
        } else {
            System.out.println("It's not hot outside.");
        }
        
        // if-else-if ladder
        System.out.println("\n--- if-else-if Ladder ---");
        int score = 85;
        
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        
        // Nested if statements
        System.out.println("\n--- Nested if Statements ---");
        boolean isWeekend = true;
        boolean isRaining = false;
        
        if (isWeekend) {
            if (isRaining) {
                System.out.println("Stay home and watch movies.");
            } else {
                System.out.println("Go out and enjoy the day!");
            }
        } else {
            if (isRaining) {
                System.out.println("Take an umbrella to work.");
            } else {
                System.out.println("Have a nice day at work.");
            }
        }
        
        // switch statement
        System.out.println("\n--- switch Statement ---");
        int day = 3;
        String dayName;
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        
        System.out.println("Day " + day + " is " + dayName);
        
        // switch with fall-through
        System.out.println("\n--- switch with Fall-Through ---");
        int month = 4;
        String season;
        
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Fall";
                break;
            default:
                season = "Invalid month";
        }
        
        System.out.println("Month " + month + " is in " + season);
        
        // switch with strings (Java 7+)
        System.out.println("\n--- switch with Strings ---");
        String fruit = "apple";
        
        switch (fruit.toLowerCase()) {
            case "apple":
                System.out.println("Apples are red or green.");
                break;
            case "banana":
                System.out.println("Bananas are yellow.");
                break;
            case "orange":
                System.out.println("Oranges are orange.");
                break;
            default:
                System.out.println("I don't know that fruit.");
        }
        
        // Logical operators in conditions
        System.out.println("\n--- Logical Operators in Conditions ---");
        int value = 15;
        
        if (value > 0 && value < 10) {
            System.out.println(value + " is a positive single-digit number.");
        } else if (value >= 10 && value < 100) {
            System.out.println(value + " is a positive two-digit number.");
        } else if (value < 0) {
            System.out.println(value + " is a negative number.");
        } else {
            System.out.println(value + " is a positive number with three or more digits.");
        }
        
        boolean hasDriversLicense = true;
        boolean hasInsurance = false;
        
        if (hasDriversLicense && hasInsurance) {
            System.out.println("You can legally drive.");
        } else if (hasDriversLicense || hasInsurance) {
            System.out.println("You need both a license and insurance to drive legally.");
        } else {
            System.out.println("You cannot legally drive.");
        }
        
        // Ternary operator as a conditional
        System.out.println("\n--- Ternary Operator ---");
        int num1 = 10;
        int num2 = 20;
        
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("The maximum of " + num1 + " and " + num2 + " is " + max);
        
        String status = (age >= 18) ? "adult" : "minor";
        System.out.println("Status based on age " + age + ": " + status);
        
        // Enhanced switch statement (Java 14+)
        // Uncomment if using Java 14 or higher
        /*
        System.out.println("\n--- Enhanced switch Statement (Java 14+) ---");
        int dayNum = 4;
        String dayString = switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        
        System.out.println("Day " + dayNum + " is " + dayString);
        */
        
        // Pattern matching for instanceof (Java 16+)
        // Uncomment if using Java 16 or higher
        /*
        System.out.println("\n--- Pattern Matching for instanceof (Java 16+) ---");
        Object obj = "Hello, World!";
        
        if (obj instanceof String str) {
            // Can use 'str' directly without casting
            System.out.println("String length: " + str.length());
        }
        */
    }
}