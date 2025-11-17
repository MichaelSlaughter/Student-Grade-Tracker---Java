/*
 *  NAME: Michael Slaughter
    DATE: 11/23/2025
    Version: v1
    Sources Used: https://www.w3schools.com/java/default.asp , https://www.codecademy.com/enrolled/courses/learn-java, https://classroom.google.com/c/NzgwMzc2ODU2ODkw (classroom contains the slides)
    Comments:   

    Psuedocode:
    1. Make an array list for students (name)
    2. Make a menu of options for the user to do
        a. View Student List
            - Print out every student with its information of the array
        b. add new student
            - Ask for student info such as name, age, grade, constructor, etc
        c. search for a student
            - The user can search by grade, name, age, etc
        d. find class average
            -Take every students grade in the array and divide it by the number of students
        e. find student with highest grade
            - Find the student in the array with the highest grade and display their info
        f. find student with lowest grade
            - Find the student in the array with the lowest grade and display their info    
        g. exit
            - ends the terminal
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentGradeTracker {
    static List<String[]> students = new ArrayList<>(); //arraylist for students
    public static void main(String[] args) { // main
        Scanner sc = new Scanner(System.in); //scanner with the name sc 
        boolean running = true; //running for each method to run when its supposed to
        while (running) { //while loop for the menu to always appear after every action performed
        // MENU 
            System.out.println("\n--- STUDENT GRADE TRACKER ---"); //List Header 
            System.out.println("1. View List of Students"); //View Students (1)
            System.out.println("2. Add Student"); // Add Student (2) 
            System.out.println("3. Search Student"); //Search Student (3)
            System.out.println("4. Find Class Average"); // Find Class Average (4)
            System.out.println("5. Sort students by grade"); // Sorts student by grade
            System.out.println("6. Find Student with highest grade"); // Highest Grade (6)
            System.out.println("7. Find Student with lowest grade"); //Lowest Grade (7)
            System.out.println("8. Exit"); // Exit (8)
            System.out.print("Enter choice: "); // Tells the user to enter choice 
            String choice = sc.nextLine(); // User Input for the choice 
            if (choice.equals("1")){
                viewStudents();
            } else if (choice.equals("2")){
                addStudent(sc);
            } else if (choice.equals("3")){
                searchStudent(sc);
            } else if (choice.equals("4")){
                findClassAverage(sc);
            } else if (choice.equals("5")){
                sortStudents(sc);
            }
        }
    }// end main
    
    private static void viewStudents() {
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like and exit to continue the code
        } //if students size is > 0 (There are students)
        for (int i = 0; i < students.size(); i++){  // for the students that exist
            String[] student = students.get(i);
            System.out.println("Name: " + student[0] + " " + student[1]);
            System.out.println("Age: " + student[2]);
            System.out.println("Year: " + student[3]);
            System.out.println("Grade: " + student[5] + " / " + student[4]);
            System.out.println();
        } //end of the for loop for students
    }


    private static void addStudent(Scanner sc) {
        System.out.println("Please enter the student's first name.");
        String firstName = "";
        boolean firstNameValid = false;
        while (!firstNameValid) {
            firstName = sc.nextLine();
            if (firstName.isEmpty()){
                System.out.println("Try again, minimum input is not acceptable.");
                continue;
            } else if (firstName.contains(" ")){
                System.out.println("The name can't contain spaces");
                continue;
            } else {
                firstNameValid = true;
            }
        }
        System.out.println("Please enter the student's last name.");
        String lastName = "";
        boolean lastNameValid = false;
        while (!lastNameValid) {
            lastName = sc.nextLine();
            if (lastName.isEmpty()){
                System.out.println("Try again, minimum input is not acceptable.");
                continue;
            } else if (lastName.contains(" ")){
                System.out.println("The name can't contain spaces");
                continue;
            } else {
                lastNameValid = true;
            }
        }
        System.out.println("Please enter the student's age.");
        int age = 0;
        String agestr = "";
        boolean validAge = false;
        while (!validAge) {
            age = Integer.parseInt(sc.nextLine());
            if (age < 14){
                System.out.println("Student must be 14 or older to be in high school. Try again.");
                continue;
            } else if (age > 21){
                System.out.println("Student must be 21 or younger to be in high school. Try again.");
                continue;
            } else {
                validAge = true;
                agestr = age + ""; //converts age to a string to be put in the array
            }    
        }
        System.out.println("What is the student's year in school? (9, 10, 11, 12)");
        int year = 0;
        boolean validYear = false;
        while (!validYear){
            year = Integer.parseInt(sc.nextLine());
            if (year < 9 || year > 12){
                System.out.println("Invalid grade level for a high school student. Try again.");
                continue;
            } else {
                validYear = true;
            }
        }
        String yearstr = year + "";
        System.out.println("What is the student's grade?");
        double grade = sc.nextDouble();
        sc.nextLine();
        double roundedGrade = Math.round(grade * 100.0) / 100.0; 
        String gradeString = roundedGrade + "";
        String letterGrade;
        if (roundedGrade < 0 || roundedGrade > 100) {
            letterGrade = "N/A";
        } else if (roundedGrade >= 92) {
            letterGrade = "A";
        } else if (roundedGrade >= 83) {
            letterGrade = "B";
        } else if (roundedGrade >= 74) {
            letterGrade = "C";
        } else if (roundedGrade >= 65) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        students.add(new String[]{firstName, lastName, agestr, yearstr, gradeString, letterGrade});
    }

    private static void searchStudent(Scanner sc){ //searchStudent method
        if (students.isEmpty()) { //if there are no students  
            System.out.println("No students."); //tells the user this  
            return; ///return ends search student  
        } //end of this if statement 
        System.out.println("Search for the student below."); //tells the user to search for the student 
        String search = sc.nextLine().toLowerCase(); //Input line for the search 
        boolean found = false; //boolean for when the student is found 
        for (int i = 0; i < students.size(); i++) { //for loop for the boolean found 
            String[] student = students.get(i); //gets the student from the students array 
            String combined = String.join(" ", student).toLowerCase(); //combines the first and last names into one string
            if (search.equals(" ")){ //if the search is a " " space string
                found = false; //keeps found at false to print "The Student has not been found" below
            } else if (combined.contains(search)){ //if the search contains one of the student 
                System.out.println("Name: " + student[0] + " " + student[1] + "\nAge: " + student[2] + "\nYear: " + student[3] + "\nGrade: " + student[5] + " / " + student[4] + "\n"); //that student information will print 
            found = true; //found turns to true to the for loop ends 
            } //end of this if statement
        } //end of this for loop
        if (!found) { //if no student isn't found
            System.out.println("Student has not been found."); //tells the user this 
        } // end of !found if else
    } // end of this method 

    private static void findClassAverage(Scanner sc){
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like exit to end this code
        } //if students size is > 0 (There are students)

        double total = 0; 
        for (String[] student : students) {
            total += Double.parseDouble(student[4]); //gets every students grade added together
        }
        
        double average = total / students.size();
        double roundedAverage = Math.round(average * 100.0) / 100.0;
        String averageLetterGrade;
        if (roundedAverage < 0 || roundedAverage > 100) {
            averageLetterGrade = "N/A";
        } else if (roundedAverage >= 92) {
            averageLetterGrade = "A";
        } else if (roundedAverage >= 83) {
            averageLetterGrade = "B";
        } else if (roundedAverage >= 74) {
            averageLetterGrade = "C";
        } else if (roundedAverage >= 65) {
            averageLetterGrade = "D";
        } else {
            averageLetterGrade = "F";
        }
        System.out.println("The Class Average is a " + averageLetterGrade + " / " + roundedAverage);
    }

    private static void sortStudents(Scanner sc){
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like and exit to continue the code
        } //if students size is > 0 (There are students)
        boolean sorted = false; //boolean for if the students are sorted 
            while (!sorted) { //while loop for sorted 
                System.out.println("\nHow would you like to sort the students?"); //Asks the user how would they like to sort the students
                System.out.println("--- SORT OPTIONS ---"); //Sort options menu 
                System.out.println("A: Alphabetic Order A-Z"); //Sorting it A-Z alphabetical order
                System.out.println("Z: Alphabetic Order Z-A"); //Sorting it Z-A alphatbetical order
                System.out.println("H: Grade Highest to Lowest"); //Sorting by grade Highest to Lowest
                System.out.println("L: Grade Lowest to Highest"); //Sorting by grade Lowest to Highest
                String option = sc.nextLine(); //string for the option the user wants
                if (option.equals("A")){
                    students.sort((a, b) -> a[0].compareToIgnoreCase(b[0])); //sorts the students by alphabetical order A-Z
                } else if (option.equals("Z")){
                    students.sort((a, b) -> b[0].compareToIgnoreCase(a[0])); //sorts the students by alphabetical order Z-A
                }

            for (String[] student : students) {
                System.out.println("Name: " + student[0] + " " + student[1]);
                System.out.println("Age: " + student[2]);
                System.out.println("Year: " + student[3]);
                System.out.println("Grade: " + student[5] + " / " + student[4]);
                System.out.println();
            }
        }
    }
}