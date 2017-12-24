import java.util.*;

class ScalarProductOf2Vectors { // iloczyn skalarny dwóch wektorów
    public static void main(String[] args) {
        CalculateTheScalarProductOfVectors scalarProductOfVectors = new CalculateTheScalarProductOfVectors();
        ArrayList<Integer> vectorA = new ArrayList<>();
        ArrayList<Integer> vectorB = new ArrayList<>();
        vectorA.addAll(Arrays.asList(1, 2, 3));
        vectorB.addAll(Arrays.asList(4, 5, 6));
        scalarProductOfVectors.calculateTheScalarProductOfVectors(vectorA, vectorB);
    }
}

class CalculateTheScalarProductOfVectors {
    private ArrayList<Integer> vectorA = new ArrayList<>();
    private ArrayList<Integer> vectorB = new ArrayList<>();

    ArrayList<Integer> getVectorA() {
        return vectorA;
    }
    ArrayList<Integer> getVectorB() {
        return vectorB;
    }

    CalculateTheScalarProductOfVectors() {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
    }

    void calculateTheScalarProductOfVectors(ArrayList<Integer> vectorA, ArrayList<Integer> vectorB) {
        if (vectorA.size() == vectorB.size()) {
            int result = 0;
            System.out.println("VectorA = " + vectorA);
            System.out.println("VectorB = " + vectorB);
            System.out.print("Scalar result = ");
            for (int i = 0; i < vectorA.size(); i++) {
                result += vectorA.get(i) * vectorB.get(i);
                System.out.print(vectorA.get(i) + "*" + vectorB.get(i));
                if (i != vectorA.size()-1) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" = ");
                }
            }
            System.out.println(result);
        } else {
            System.err.println("Vectors should have same size.");
        }
    }
}
