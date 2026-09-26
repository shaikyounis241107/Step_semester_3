CsvStudentRecordParser.java

package string.class_problems;

import java.util.Scanner;

public class CsvStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] parts = csvLine.split(",");

        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = parts[0].trim();
        String rollNumber = parts[1].trim();
        String department = parts[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNumber
                + " | Dept: " + department);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}