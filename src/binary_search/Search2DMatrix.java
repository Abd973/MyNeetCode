package binary_search;

public class Search2DMatrix {
    //this is my own solution which costs O(m.log(n)) time, and O(1) space
    public static boolean searchMatrix(int[][] matrix, int target) {
//        int l = 0, r = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            int l = 0, r = matrix[i].length - 1;
            while (l <= r){
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return false;
    }

    //using double binary search to determine the row of the target, then applying binary search on this row
    //O(log(m) + log(n)) which equals O(log(m*n))
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;


//searching for the row
        int topRowIdx = 0;
        int botRowIdx = ROWS - 1;
        while (topRowIdx <= botRowIdx) {
            int midRowIdx = (topRowIdx + botRowIdx) / 2;
            if (matrix[midRowIdx][COLS - 1] < target)
                topRowIdx = midRowIdx + 1;
            else if (matrix[midRowIdx][0] > target)
                botRowIdx = midRowIdx - 1;
            else
                break; //the target is in the first row
        }

        if (topRowIdx > botRowIdx)
            return false;


// searching in the right row
        int l = 0;
        int r = COLS - 1;
        int midRowIdx = (topRowIdx + botRowIdx) / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[midRowIdx][mid] == target) return true;
            if (matrix[midRowIdx][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    //for later I want to study binary search with one pass

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int[][] matrix2 = {{1}, {3}};
        System.out.println(searchMatrix2(matrix, 16));
    }
}
