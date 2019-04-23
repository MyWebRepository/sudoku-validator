import java.io.*;

public class SudokuValidatorTest {
    public static void main(String[] args) {
        // Test case 1: positive case
        correct_answer();

        // Test case 2: negative case
        incorrect_answer();

        // Test case 3: exception case
        file_not_found();

        // Test case 4: exception case
        file_in_bad_format();
    }

    public static void correct_answer() {
        String fileName = "correct.txt";

        try {
            SudokuValidator validator = new SudokuValidator();
            boolean b = validator.validate(fileName);
            if (b) {
                System.out.println("correct_answer(): Pass");
            } else {
                System.out.println("correct_answer(): Fail");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (IllegalStateException e) {
            System.out.println("Error in the content of file '" + fileName + "'");
        }
    }

    public static void incorrect_answer() {
        String fileName = "incorrect.txt";

        try {
            SudokuValidator validator = new SudokuValidator();
            boolean b = validator.validate(fileName);
            if (!b) {
                System.out.println("incorrect_answer(): Pass");
            } else {
                System.out.println("incorrect_answer(): Fail");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Pass");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (IllegalStateException e) {
            System.out.println("Error in the content of file '" + fileName + "'");
        }
    }

    public static void file_not_found() {
        String fileName = "aaa.txt";

        try {
            SudokuValidator validator = new SudokuValidator();
            boolean b = validator.validate(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("file_not_found(): Pass");
            return;
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (IllegalStateException e) {
            System.out.println("Error in the content of file '" + fileName + "'");
        }

        System.out.println("file_not_found(): Fail");
    }

    public static void file_in_bad_format() {
        String fileName = "badFormat.txt";

        try {
            SudokuValidator validator = new SudokuValidator();
            boolean b = validator.validate(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (IllegalStateException e) {
            System.out.println("file_in_bad_format(): Pass");
            return;
        }

        System.out.println("file_in_bad_format(): Fail");
    }

}