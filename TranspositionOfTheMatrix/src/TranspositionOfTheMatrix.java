import java.util.Arrays;
import java.util.Random;
/**
@version v0.9

Zadanie:
wykonać transpozycję macierzy
*/
public class TranspositionOfTheMatrix {
    public static void main(String[] args) {
        int raw = 6;
        int column = 3;
        Matrix matrix = new Matrix(raw, column);
        CreateMatrix givenMatrix = new CreateMatrix(matrix);
        TransposeOfMatrix transposeOfMatrix = new TransposeOfMatrix(matrix);

        System.out.println("Do you prefer a randomly filled matrix instead of a manual one? [Yes | No]? <-- YES");
        givenMatrix.randomlyGenerateMatrix();
        System.out.println("Generated matrix:\n" + givenMatrix.getMatrixAsString());
        transposeOfMatrix.makeTranspositionOfMatrix(givenMatrix.getMatrixAsMatrix());
        System.out.println("\nTransposed matrix:\n" + transposeOfMatrix.getTransposedMatrix());
    }
}

class CreateMatrix {
    private Matrix matrix;
    private Random random;
    private ShowMatrix matrixToShow;

    protected String getMatrixAsString() {
        return matrixToShow.show(matrix);
    }

    protected Matrix getMatrixAsMatrix() {
        return matrix;
    }

    CreateMatrix(Matrix givenMatrix) {
        this.matrix = givenMatrix;
        matrixToShow = new ShowMatrix();
        random = new Random();
    }

    void randomlyGenerateMatrix() {
        for (int i = 0; i < matrix.getRaw(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {
                this.matrix.setMatrix(i, j, random.nextInt(10));
            }
        }
    }

    Matrix customDataMatrix() { // Create a method for manual filling the matrix
        return null;
    }
}

class TransposeOfMatrix {
    private Matrix transposedMatrix;
    private ShowMatrix matrixToShow;

    TransposeOfMatrix(Matrix emptyMatrix) {
        matrixToShow = new ShowMatrix();
        transposedMatrix = new Matrix(emptyMatrix.getColumn(), emptyMatrix.getRaw());
    }

    String getTransposedMatrix() {
        return matrixToShow.show(transposedMatrix);
    }

    void makeTranspositionOfMatrix(Matrix givenMatrix) {
        for (int i = 0; i < transposedMatrix.getColumn(); i++) {
            for (int j = 0; j < transposedMatrix.getRaw(); j++) {
                transposedMatrix.setMatrix(j, i, givenMatrix.getMatrix(i, j));
            }
        }
    }
}

class ShowMatrix {
    String show(Matrix givenMatrix) {
        StringBuilder result = new StringBuilder();
        for (int[] raw: givenMatrix.getMatrix()) {
            result.append(Arrays.toString(raw));
            result.append("\n");
        }
        return result.toString();
    }
}

final class Matrix {
    private int[][] matrix;

    protected int getRaw() {
        return matrix.length;
    }
    protected int getColumn() {
        return matrix[0].length;
    }
    protected int getMatrix(int j, int i) {
        return matrix[j][i];
    }
    protected int[][] getMatrix() {
        return matrix;
    }

    protected void setMatrix(int currentRaw, int currentColumn, int value) {
        this.matrix[currentRaw][currentColumn] = value;
    }

    Matrix(int raw, int column) {
        this.matrix = new int[raw][column];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] raw: getMatrix()) {
            result.append(Arrays.toString(raw));
        }
        return result.toString();
    }
}
