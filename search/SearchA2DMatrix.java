package com.dooonabe.search;

/**
 * 74. Search a 2D Matrix
 * Created on 2019/3/3.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        int n = 0;
        for (int i = 0; i < m; i++) {
            n = matrix[i].length;
            if (n != 0) {
                if (matrix[i][0] > target) {
                    return false;
                } else if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == target) {
                            return true;
                        }
                    }
                } else {

                }
            }
        }
        return false;
    }
}
