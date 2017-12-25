import java.util.*;

class ScalarProductOf2Vectors { // iloczyn skalarny dwóch wektorów
    public static void main(String[] args) {
        ArrayList<Integer> vectorA = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> vectorB = new ArrayList<>(Arrays.asList(4, 5, 6));
        calculateTheScalarProductOfVectors(vectorA, vectorB);
    }

    private static void calculateTheScalarProductOfVectors(ArrayList<Integer> vectorA, ArrayList<Integer> vectorB) {
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
