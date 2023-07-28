import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {}
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Write your code here.
        boolean firstRow = false, firstColumn = false;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstColumn = true;
                    }
                    matrix.get(0).set(j, 0);
                    matrix.get(i).set(0, 0);
                }
            }
        }
        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        if (firstRow) {
            for (int i = 0; i < matrix.get(0).size(); i++) {
                matrix.get(0).set(i, 0);
            }
        }
        if (firstColumn) {
            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
}