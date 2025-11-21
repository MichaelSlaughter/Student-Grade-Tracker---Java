/*
 *  NAME: Michael Slaughter
    DATE: 11/23/2025
    Version: v1
    Sources Used: https://www.w3schools.com/java/default.asp , https://www.codecademy.com/enrolled/courses/learn-java, https://classroom.google.com/c/NzgwMzc2ODU2ODkw (classroom contains the slides), https://www.w3schools.com/js/js_array_sort.asp?utm_source=chatgpt.com 
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
        g. change students grade
            -Asks the user to select the student they want to change the grade of
        h. exit
            - ends the terminal
 * 
 */

import java.io.IOException;
import java.util.ArrayList; //util for arraylist
import java.util.InputMismatchException; //
import java.util.List; //util for a list
import java.util.Scanner; //util for scanner 
public class MS_StudentGradeTracker { //StudentGrade Tracker class
    static List<String[]> students = new ArrayList<>(); //arraylist for students
    public static void main(String[] args) { // main
        Scanner sc = new Scanner(System.in); //scanner with the name sc 
        boolean running = true; //running for each method to run when its supposed to
        while (running) { //while loop for the menu to always appear after every action performed
            System.out.println("\n--- STUDENT GRADE TRACKER ---"); //List Header 
            System.out.println("1. View List of Students"); //View Students (1)
            System.out.println("2. Add Student"); // Add Student (2) 
            System.out.println("3. Search Student"); //Search Student (3)
            System.out.println("4. Find Class Average"); // Find Class Average (4)
            System.out.println("5. Sort Students by Grade"); // Sorts student by grade
            System.out.println("6. Find Student with Highest Grade"); // Highest Grade (6)
            System.out.println("7. Find Student with Lowest Grade"); //Lowest Grade (7)
            System.out.println("8. Change Student's Grade"); //Change a students grade (8)
            System.out.println("9. Exit"); // Exit (9)
            System.out.print("Enter choice: "); // Tells the user to enter choice 
            String choice = sc.nextLine(); // User Input for the choice 
            if (choice.equals("1")){ //if 1
                viewStudents(); //calls viewStudents method
            } else if (choice.equals("2")){ //if 2
                addStudent(sc); //calls addStudent method
            } else if (choice.equals("3")){ // if 3
                searchStudent(sc); //calls searchStudent method
            } else if (choice.equals("4")){ // if 4
                findClassAverage(sc); //calls findClassAverage method
            } else if (choice.equals("5")){ // if 5
                sortStudents(sc); //calls sort Students method
            } else if (choice.equals("6")){ // if 6
                findHighestGrade(); //calls findHighestGrade
            } else if (choice.equals("7")){ // if 7
                findLowestGrade(); //calls findLowestGrade
            } else if (choice.equals("8")){ // if 8
                changeStudentGrade(sc); //calls changeStudentGrade method
            } else if (choice.equals("9")){ // if 9
                if (students.size() < 10){ //if students size is < 10 (10 students required)
                    System.out.println(); //New Line for styling purposes
                    System.out.println("The Class must have at least 10 students in order to exit"); //tells the user that there must be at least 10 students in order to exit
                } else { //if there are 10 or more
                    exit(); //calls the exit() method
                    running = false; //running is set to false to prevent the menu from showing again
                } //end of if else for 9
            } else { //if anything else
                System.out.println("Invalid Choice. Try again."); //tells the user the choice was invalid
            }//end of if else 
        } //end of while loop
    }// end main
    
    private static void viewStudents() { //view students method
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like an exit to continue the code
        } //if students size is > 0 (There are students)
        System.out.println(); //New Line for styling purposes
        for (int i = 0; i < students.size(); i++){  // for the each student that exists
            String[] student = students.get(i); //gets the students in the array 
            System.out.println("Name: " + student[0] + " " + student[1]); //prints student's name
            System.out.println("Age: " + student[2]); //prints the student's age
            System.out.println("Year: " + student[3]); //prints the student's year
            System.out.println("Grade: " + student[5] + " / " + student[4]); //student letter grade / student numeric grade
            System.out.println(); //another line for styling purposes
        } //end of the for loop for students
    } //end of viewStudents method

    private static void addStudent(Scanner sc) { //addStudent method
        System.out.println(); //New Line for styling purposes
        System.out.println("Please enter the student's first name."); //tells the user to enter the student's first name
        String firstName = ""; //sets firstName to a blank string as a starter value
        boolean firstNameValid = false; //boolean for a valid first name
        while (!firstNameValid) { //while loop for a valid first name
            firstName = sc.nextLine(); //first name input line
            if (firstName.isEmpty()){ //if the user puts nothing for firstName
                System.out.println("Try again, minimum input is not acceptable."); //tells the user minimum input is not acceptable 
                continue; //continue gives the user another chance to respond
            } else if (firstName.contains(" ")){ //if the user types any space in the first name
                System.out.println("The name can't contain spaces"); //tells the user there can't be spaces in a first name
                continue; //continue gives the user another chance to respond
            } else { //if the first name is valid 
                firstNameValid = true; //sets the boolean to true ending the loop
            } //end of if else for first name
        } //end of while loop for first name
        System.out.println("Please enter the student's last name."); //tells the user to enter the student's last name
        String lastName = ""; //sets lastName to a blank string as a starter value
        boolean lastNameValid = false; //boolean for a valid last name 
        while (!lastNameValid) { //while loop for a valid last name
            lastName = sc.nextLine(); //last name input line 
            if (lastName.isEmpty()){ //if the user puts nothing for last name
                System.out.println("Try again, minimum input is not acceptable."); //tells the user minimum input is not acceptable 
                continue; //continue gives the user another chance to respond
            } else if (lastName.contains(" ")){ //if the user types any space in the last name
                System.out.println("The name can't contain spaces"); //tells the user there can't be spaces in a last name
                continue; //continue gives the user another chance to respond
            } else { //if the last name is valid 
                lastNameValid = true; //sets the boolean to true ending the loop
            } //end of if else for last name
        } //end of while loop for last name
        System.out.println("Please enter the student's age."); //tells the user to enter the student's age
        int age = 0; //sets age to 0 as a starter value
        String agestr = ""; //sets agestr to "" as a starter value for age string
        boolean validAge = false; //validAge boolean 
        while (!validAge) { //whille loop for a valid age
            age = Integer.parseInt(sc.nextLine()); //age input line
            if (age < 14 || age > 21){ //if age is 
                System.out.println("Student must be 14 - 21 to be in high school. Try again."); //tells user they must be older than 13 but young than 22 to be in high school
                continue; //continue gives the user another chance to respond
            } else { //else meaning the age is valid
                validAge = true; //sets validAge to true ending the loop
                agestr = age + ""; //converts age to a string to be put in the array
            }  //end of valid age if/else 
        } //end of valid age while loop
        System.out.println("What is the student's year in school? (9, 10, 11, 12)"); //asks the user what the student's year is
        int year = 0; //sets year to 0 as a starter value
        boolean validYear = false; //validYear boolean
        while (!validYear){ //while loop for a valid Year
            year = Integer.parseInt(sc.nextLine()); //year input line
            if (year < 9 || year > 12){ //student can have a year less than 9 (freshman) but more than 12 (senior)
                System.out.println("Invalid grade level for a high school student. Try again."); //tells the user that the grade they put was invalid for a high school student
                continue; //continue gives the user another chance to respond
            } else { //else meaning the year is valid
                validYear = true; //sets validYear to true, ending the loop 
            } //end of if else for validYear
        } //end of while loop
        String yearstr = year + ""; //sets year to a string
        double grade = 0; //starter value for grade
        boolean validGrade = false; //boolean for a valid grade input
        while (!validGrade) { //loop for valid grade
            System.out.println("What is the student's grade?"); //asks the user what the student's grade is 
            try { //try catch
                grade = sc.nextDouble(); //grade input line
                sc.nextLine(); // if reading a line of text after
                if (grade > 100 || grade < 0){ //if the grade isn't a valid grade (Not between 0 and 100)
                    validGrade = false; //keeps validInput false to give the user another chance to respond
                } else { //else for if the input is a valid grade
                    validGrade = true; // input is valid, end loop
                } // ends this if else
            } catch (InputMismatchException e) { //if the input isn't a valid number
                System.out.println("Invalid input. Please enter a number."); //tells the user to enter a valid number 
                sc.nextLine(); // clear the invalid input
            } //end of try catch
        } //end of while loop for validGrade
        double roundedGrade = Math.round(grade * 100.0) / 100.0; //rounds the grade to the hundreths place 
        String gradeString = roundedGrade + ""; //turns the grade into a string
        String letterGrade; //string for the letter grade
        if (roundedGrade >= 92) { //if the grade is a 92 or better
            letterGrade = "A"; //the letter grade is an A
        } else if (roundedGrade >= 83) { //if the grade is an 83 or better
            letterGrade = "B"; //the letter grade is a B
        } else if (roundedGrade >= 74) { //if the grade is a 74 or better
            letterGrade = "C"; //the letter grade is a C
        } else if (roundedGrade >= 65) { //if the grade is a 65 or better
            letterGrade = "D"; //the ltter grade is a D
        } else { //if the letter grade is worst than a 65
            letterGrade = "F"; //the ltter grade is an F
        } //end of if else for letter grade
        students.add(new String[]{firstName, lastName, agestr, yearstr, gradeString, letterGrade}); //adds the student to the array with this information
    } //end of add student method

    private static void searchStudent(Scanner sc){ //searchStudent method
        if (students.isEmpty()) { //if there are no students  
            System.out.println("No students."); //tells the user this  
            return; ///return ends search student  
        } //end of this if statement 
        System.out.println("Search for the student below."); //tells the user to search for the student 
        String search = sc.nextLine().toLowerCase(); //Input line for the search 
        boolean found = false; //boolean for when the student is found 
        for (int i = 0; i < students.size(); i++) { //for loop for the boolean found 
            System.out.println(); //New Line for styling purposes
            String[] student = students.get(i); //gets the student from the students array 
            String combined = (student[0] + " " + student[1]).toLowerCase(); //combines first and last name into one string
            if (search.equals(" ")){ //if the search is a " " space string
                found = false; //keeps found at false to print "The Student has not been found" below
            } else if (combined.contains(search)){ //if the search contains one of the student 
                System.out.println("Name: " + student[0] + " " + student[1] + "\nAge: " + student[2] + "\nYear: " + student[3] + "\nGrade: " + student[5] + " / " + student[4] + "\n"); //that student's information will print 
                found = true; //found turns to true to the for loop ends 
            } //end of this if else statement
        } //end of this for loop
        if (!found) { //if no students are found
            System.out.println("Student has not been found."); //tells the user this 
        } // end of not found if else
    } // end of search student method 

    private static void findClassAverage(Scanner sc){ //find class average method
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like exit to end this code
        } //if students size is > 0 (There are students)
        double total = 0; //total student grades combined into one value. 0 is the starter value. 
        for (String[] student : students) { //for loop for students
            total += Double.parseDouble(student[4]); //gets every students grade added together
        } //end of for loop for adding the student's grade together
        double average = total / students.size(); //finds the average class grade. Divides the students total grades together by the number of students
        double roundedAverage = Math.round(average * 100.0) / 100.0; //rounds this value to the hundreths place
        String averageLetterGrade; //starter string for averageLetterGrade
        if (roundedAverage >= 92) { //if the grade is a 92 or better
            averageLetterGrade = "A"; //the letter grade is A
        } else if (roundedAverage >= 83) { //if the grade is a 83 or better
            averageLetterGrade = "B"; //the letter grade is B
        } else if (roundedAverage >= 74) { //if the grade is a 74 or better
            averageLetterGrade = "C"; //the letter grade is C
        } else if (roundedAverage >= 65) { //if the grade is a 65 or better
            averageLetterGrade = "D"; //the letter grade is D
        } else { //if the grade is worse than a 65
            averageLetterGrade = "F"; //the letter grade is an F
        } //end of letterGrade scale if else
        System.out.println(); //New Line for styling purposes
        System.out.println("The Class Average is a " + averageLetterGrade + " / " + roundedAverage); //Prints the average grade
    } //end of findClassAverage method 

    private static void sortStudents(Scanner sc){ //sort students method
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like and exit to continue the code
        } //if students size is > 0 (There are students)
        boolean sorted = false; //boolean for if the students are sorted 
        while (!sorted) { //while loop for sorted 
            System.out.println("\nHow would you like to sort the students?"); //Asks the user how would they like to sort the students
            System.out.println("--- SORT OPTIONS ---"); //Sort options menu 
            System.out.println("A: Alphabetic Order A-Z"); //Sorting it A-Z alphabetical order by last name
            System.out.println("Z: Alphabetic Order Z-A"); //Sorting it Z-A alphatbetical order by last name
            System.out.println("H: Grade Highest to Lowest"); //Sorting by grade Highest to Lowest
            System.out.println("L: Grade Lowest to Highest"); //Sorting by grade Lowest to Highest
            String option = sc.nextLine().toUpperCase(); //string for the option the user wants
            if (option.equals("A")) { // if A meaning starts A-Z
                students.sort((a, b) -> a[1].compareToIgnoreCase(b[1])); //sorts the students in alphabetical order A-Z
                sorted = true; //sorted is true to end the loop
            } else if (option.equals("Z")) { // if Z meaning starts Z-A 
                students.sort((a, b) -> b[1].compareToIgnoreCase(a[1])); //sorts the students in alphabetical order Z-A 
                sorted = true; //sorted is true to end the loop
            } else if (option.equals("H")) { //if H for Highest Grade to Lowest Graade
                students.sort((s1, s2) -> Double.compare(Double.parseDouble(s2[4]), Double.parseDouble(s1[4]))); //sorts for Highest to Lowest for [4]
                sorted = true; //sorted is true to end the loop
            } else if (option.equals("L")) { //if L for Lowest Grade to Highest
                students.sort((s1, s2) -> Double.compare(Double.parseDouble(s1[4]), Double.parseDouble(s2[4]))); //sorts for Lowest to Highest for [4]
                sorted = true; //sorted is true to end the loop
            } else { //if the option is invalid
                System.out.println("Invalid option. Please try again."); //tells the user to try again 
            } //end of if else
        } //end of while loop
        System.out.println(); //New Line for styling purposes
        System.out.println("--- Sorted Students ---"); //Prints the students but sorted in the order selected
        for (String[] student : students) { //loop to print the students
            System.out.println("Name: " + student[0] + " " + student[1]); //prints their name
            System.out.println("Age: " + student[2]); //prints the age
            System.out.println("Year: " + student[3]); //prints the year (9, 10, 11, 12)
            System.out.println("Grade: " + student[5] + " / " + student[4]); //prints their grade 
            System.out.println(); //new line for styling purposes
        } //end of print student loop
    } //end of sort students method 

    private static void findHighestGrade(){ //findHighestGrade method
        students.sort((s1, s2) -> Double.compare(Double.parseDouble(s2[4]), Double.parseDouble(s1[4]))); //sorts for Highest to Lowest for [4]
        String[] student = students.get(0); //Gets the first student of the sorted array (student with best grade)
        System.out.println(); //New Line for styling purposes
        System.out.println("Name: " + student[0] + " " + student[1]); //prints the student's name
        System.out.println("Age: " + student[2]); //prints the student's age
        System.out.println("Year: " + student[3]); //prints the student's year 
        System.out.println("Grade: " + student[5] + " / " + student[4]); //prints the student's grade
        System.out.println(); //prints new line for styline purposes
    } //end of findHighestGrade 

    private static void findLowestGrade(){ //findLowestGrade method
        students.sort((s1, s2) -> Double.compare(Double.parseDouble(s1[4]), Double.parseDouble(s2[4]))); //sorts for Lowest to Highest for [4]
        String[] student = students.get(0); //Gets the first student of the sorted array (student with worst grade)
        System.out.println(); //New Line for styling purposes
        System.out.println("Name: " + student[0] + " " + student[1]); //prints the student's name
        System.out.println("Age: " + student[2]); //prints the student's age
        System.out.println("Year: " + student[3]); //prints the student's year 
        System.out.println("Grade: " + student[5] + " / " + student[4]); //prints the student's grade
        System.out.println(); //prints new line for styline purposes
    } // end of findLowest Grade

    private static void changeStudentGrade(Scanner sc){ //changeStudentGrade method
        System.out.println(); //New Line for styling purposes
        if (students.isEmpty()) {//if there are no students
            System.out.println("There are no students."); //tells the user there are no students
            return; //returns acts like an exit to continue the code
        } //if students size is > 0 (There are students)
        System.out.println(); //New Line for styling purposes
        System.out.println("Student Menu:"); //Student menu header 
        for (int i = 0; i < students.size(); i++){  // for the each student that exists
            String[] student = students.get(i); //gets the students in the array 
            int studentNumber = i + 1; //makes the list number + 1 because the index needs a + 1
            System.out.println(studentNumber + ". " + student[0] + " " + student[1]); //Prints the students from the array in a list
        } //end of the for loop for students
        System.out.println(); //another line for styling purposes
        System.out.println("Select the student number on the list you would like to change."); //Asks the user to pick the number student on the list they want to select
        System.out.println("Press 0 for none."); //tells the user to press 0 to cancel their action
        int chooseStudent = sc.nextInt(); //choose student input integer
        sc.nextLine(); //another line for the input
        if (chooseStudent == 0) { //if the choice is 0
            System.out.println("No student selected."); //tells the user that no student was selected
            return; //return ends changeStudentGrade
        } //end of if statement
        int index = chooseStudent - 1; //converts it back to the index number. So student 1 selected has an index of 0 again
        if (index < 0 || index >= students.size()) { //if the index is > than the students size (meaning an invalid student number has been selected)
            System.out.println("Invalid student number."); //tells the user this
            return; //return ends changeStudentGrade
        } //end of this if else statement
        String[] selectedStudent = students.get(index); //creates new list of the student selected
        System.out.println("You selected: " + selectedStudent[0] + " " + selectedStudent[1]); //Prints the student selected
        double grade = 0; //starter value for grade
        boolean validGrade = false; //boolean for a valid grade input
        while (!validGrade) { //loop for valid grade
            System.out.println("What would you like to change their grade to?"); //asks the user what the student's grade is 
            try { //try catch
                grade = sc.nextDouble(); //grade input line
                sc.nextLine(); // if reading a line of text after
                if (grade > 100 || grade < 0){ //if the grade isn't a valid grade (Not between 0 and 100)
                    validGrade = false; //keeps validInput false to give the user another chance to respond
                } else { //else for if the input is a valid grade
                    validGrade = true; // input is valid, end loop
                } // ends this if else
            } catch (InputMismatchException e) { //if the input isn't a valid number
                System.out.println("Invalid input. Please enter a number."); //tells the user to enter a valid number 
                sc.nextLine(); // clear the invalid input
            } //end of try catch
        } //end of while loop for validGrade
        double roundedGrade = Math.round(grade * 100.0) / 100.0; //rounds the grade to the hundreths place 
        String gradeString = roundedGrade + ""; //turns the grade into a string
        String letterGrade; //string for the letter grade
        if (roundedGrade >= 92) { //if the grade is a 92 or better
            letterGrade = "A"; //the letter grade is an A
        } else if (roundedGrade >= 83) { //if the grade is an 83 or better
            letterGrade = "B"; //the letter grade is a B
        } else if (roundedGrade >= 74) { //if the grade is a 74 or better
            letterGrade = "C"; //the letter grade is a C
        } else if (roundedGrade >= 65) { //if the grade is a 65 or better
            letterGrade = "D"; //the ltter grade is a D
        } else { //if the letter grade is worst than a 65
            letterGrade = "F"; //the ltter grade is an F
        } //end of if else for letter grade
        selectedStudent[4] = gradeString; //changes grade for this student
        selectedStudent[5] = letterGrade; //changes letter grade for this student
    } //end of changeStudentGrade method

    private static void exit(){ //exit method
        System.out.println(); //New Line for styling purposes 
        System.out.println("Thanks for using this Student Grade Tracker!"); //thanks the user for using
    } //end of exit method
} //end of StudentGradeTracker
