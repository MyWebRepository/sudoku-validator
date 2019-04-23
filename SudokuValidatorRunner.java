import java.io.*;

public class SudokuValidatorRunner {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("File name is not provided");
            return;
        }

        // Get file name from arguments
        String fileName = args[0];

        try {
            SudokuValidator validator = new SudokuValidator();
            boolean b = validator.validate(fileName);
            if (b) {
                System.out.println("The file contains the correct answer to Sudoku");
            } else {
                System.out.println("The file contains the incorrect answer to Sudoku");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (IllegalStateException e) {
            System.out.println("Error in the content of file '" + fileName + "'");
        }
    }
}
