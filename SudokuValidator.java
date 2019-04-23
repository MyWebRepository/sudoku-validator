import java.io.*;

public class SudokuValidator {
	private static final int SIZE = 9; // Size of square 9 X 9
	private static final int GRID_SIZE = 3; // Size of square 3 X 3
	private static final int SUM = 45; // Sum of integers from 1 to 9

	public SudokuValidator() {}

	// Validate if the file contains the correct answer to Sudoku or not
	public boolean validate(String fileName) throws FileNotFoundException, IOException, IllegalStateException {
		String[] lines = read(fileName);

		if (!validateFormat(lines)) {
			throw new IllegalStateException("The content of file is not formed correctly");
		}

		int[][] digits = convert(lines);
		boolean b1 = validateRowSums(digits);
		boolean b2 = validateColumnSums(digits);
		boolean b3 = validateGrid(digits);

		return b1 && b2 && b3;
	}

	// Read a file and store content in an array of strings
	private String[] read(String fileName) throws FileNotFoundException, IOException {
		int lineNumber = 0;
		String line = null;
		String[] lines = new String[SIZE];

		// Reads text file
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
				continue;
			}

			lines[lineNumber++] = line;
		}

		// Close file
		bufferedReader.close();

		return lines;
	}

	// Validate if the content of file is in correct format
	private boolean validateFormat(String[] lines) {
		if (lines.length < SIZE) {
			return false;
		}

		for (int i = 0; i < lines.length; i++) {
			if (lines[i].length() < SIZE) {
				return false;
			}
		}

		return true;
	}

	// Convert an array of strings to a 2d array of integers
	private int[][] convert(String[] lines) {
		int[][] digits = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				digits[i][j] = Character.getNumericValue(lines[i].charAt(j));
			}
		}

		return digits;
	}

	// Validate if the sum of every row of Sudoku square is equal to 45
	private boolean validateRowSums(int[][] digits) {
		for (int i = 0; i < SIZE; i++) {
			int rowSum = 0;
			for (int j = 0; j < SIZE; j++) {
				rowSum += digits[i][j];
			}
			if (rowSum != SUM) {
				return false;
			}
		}

		return true;
	}

	// Validate if the sum of every column of Sudoku square is equal to 45
	private boolean validateColumnSums(int[][] digits) {
		for (int i = 0; i < SIZE; i++) {
			int columnSum = 0;
			for (int j = 0; j < SIZE; j++) {
				columnSum += digits[j][i];
			}
			if (columnSum != SUM) {
				return false;
			}
		}

		return true;
	}

	// Validate if the sum of every square 3 X 3 of Sudoku square is equal to 45
	private boolean validateGrid(int[][] digits) {
		for (int i = 0; i < GRID_SIZE; i++) {
			int m = i * GRID_SIZE;
			for (int j = 0; j < GRID_SIZE; j++) {
				int sum = 0;
				int n = j * GRID_SIZE;
				for (int p = m; p < m + GRID_SIZE; p++) {
					for (int q = n; q < n + GRID_SIZE; q++) {
						sum += digits[p][q];
					}
				}
				if (sum != SUM) {
					return false;
				}
			}
		}

		return true;
	}
}
