import java.util.Arrays;
import java.util.Random;
/**
@version v0.8
*/
// TODO wydzielić osobne klasy dla tworzenia i transponowania macierzy aby mieć
// możliwość zaprogramowania manualnego lub automatycznego dodawania macierzy
public class TranspositionOfTheMatrix {
    /*
    wykonać transpozycję macierzy
    */
    public static void main(String[] args) {
        int raw = 6;
        int column = 3;
        CreateAndTransposeOfMatrix givenMatrix = new CreateAndTransposeOfMatrix(raw,  column);
        givenMatrix.createMatrix();
            System.out.println();
        givenMatrix.transposeOfMatrix();
    }
}

final class CreateAndTransposeOfMatrix {
    private int raw;
    private int column;
    private Random random;
    private int[][] givenMatrix;
    private int[][] transposedMatrix;

    CreateAndTransposeOfMatrix(int raw, int column) {
        this.raw = raw;
        this.column = column;
        this.random = new Random();
        this.givenMatrix = new int[raw][column];
        this.transposedMatrix = new int[column][raw];
    }

    void createMatrix() {
        System.out.println("Given matrix:");
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                givenMatrix[i][j] = random.nextInt(10);
            }
            System.out.println(Arrays.toString(givenMatrix[i]));
        }
    }

    void transposeOfMatrix() {

       System.out.println("Transposed matrix:");
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < raw; j++) {
                transposedMatrix[i][j] = givenMatrix[j][i];
            }
            System.out.println(Arrays.toString(transposedMatrix[i]));
        }
    }
}
