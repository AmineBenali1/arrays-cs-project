package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for(Student student:students){
            if(student.getAge() > oldest.getAge()) oldest = student;
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(Student student:students){
            if(student.isAdult()) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double avg = 0;
        for (Student student : students) {
            avg += student.getGrade();
        }
        return avg / students.length;
    }


    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student student:students){
            if(student.getName().equals(name)) return student;
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        // bubble sort
        boolean changed = true;
        while(changed){
            changed = false;
            for(int i=0; i < students.length - 1; i++){
                if( students[i].getGrade() < students[i+1].getGrade()){
                    Student temp; // temporary variable to swap
                    temp = students[i];
                    students[i] = students[i+1];
                    students[i+1] = temp;
                    changed = true;
                }
            }
        }

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student student:students){
            if(student.getGrade() >= 15) System.out.println(student);
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student: students){
            if( id == student.getId()){
                student.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i = 0 ; i < students.length ; i++){
            for(int j = 0 ; j < students.length ; j++){
                if ( i == j ) continue;
                if( students[i].getName().equals(students[j].getName())) return true;
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updatedArr = new Student[students.length + 1];
        for(int i=0 ; i < students.length ; i++ ){
            updatedArr[i] = students[i];
        }
        updatedArr[students.length] = newStudent;
        return updatedArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {new Student(1,"Amine",19,15),
                        new Student(2,"Souhaib", 20, 17),
                        new Student(3,"Yahya", 21, 14),
                        new Student(4,"Yasser", 21, 14),
                        new Student(5,"Walid",20,16)};
        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("The oldest student is "+ oldest.getName());

        // 3) Count adults
        int adultsCount = countAdults(arr);
        System.out.println("Count of adult students : "+ adultsCount);

        // 4) Average grade
        double avg = averageGrade(arr);
        System.out.println("The average grade of all students is : "+ avg);

        // 5) Find by name
        Student search = findStudentByName(arr,"Yasser");
        if(search != null) System.out.println("Found, " + search);
        else System.out.println("Not found");

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr,4,12);
        System.out.println("\nUpdated id=4? " + updated);
        // System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        if(hasDuplicateNames(arr)) System.out.println("Duplicates found");
        else System.out.println("Duplicates not found");

        // 10) Append new student
        System.out.println("Students with new student :");
        Student[] updatedArr = appendStudent(arr, new Student(6,"Ayoub",22,18));
        for(Student student : updatedArr) System.out.println(student);

        // 11) school
        System.out.println("=== School ===");
        Student[][] school = new Student[2][3];
        // filling the school with previous students
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0; j < 3 ; j++){
                if( i == 0) school[i][j] = updatedArr[j]; // 3 first students
                else school[i][j] = updatedArr[j + 3]; // 3 last students
            }
        }
        // printing names class by class
        for(int i = 0 ; i < 2 ; i++){
            System.out.println("Class " + (i+1) + ": ");
            for(int j = 0; j < 3 ; j++){
                System.out.println(school[i][j].getName());
            }
        }
        // top student in each class
        for(int i = 0 ; i < 2 ; i++){
            Student top = school[i][0];
            for(int j = 0; j < 3 ; j++){
                if( school[i][j].getGrade() > top.getGrade()) top = school[i][j];
            }
            System.out.println("Top Student in Class " + (i+1) + ": "+ top.getName());
        }


    }

}

