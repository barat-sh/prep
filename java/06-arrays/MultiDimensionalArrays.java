/**
 * This class demonstrates the use of multi-dimensional arrays in Java
 */
public class MultiDimensionalArrays {
    public static void main(String[] args) {
        System.out.println("=== Multi-Dimensional Arrays in Java ===\n");
        
        // Two-dimensional arrays
        System.out.println("--- Two-Dimensional Arrays ---");
        
        // 1. Declaration and initialization of a 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Printing the 2D array
        System.out.println("Matrix contents:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 2. Declaration and allocation separately
        int[][] grid = new int[3][3];
        
        // Initializing the 2D array
        int value = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = value++;
            }
        }
        
        // Printing the 2D array using enhanced for loop
        System.out.println("\nGrid contents (using enhanced for loop):");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        // Accessing elements in a 2D array
        System.out.println("\nAccessing elements in the matrix:");
        System.out.println("matrix[0][0] = " + matrix[0][0]); // First element (top-left)
        System.out.println("matrix[1][1] = " + matrix[1][1]); // Middle element
        System.out.println("matrix[2][2] = " + matrix[2][2]); // Last element (bottom-right)
        
        // Modifying elements in a 2D array
        System.out.println("\nModifying elements in the matrix:");
        System.out.println("Before: matrix[1][1] = " + matrix[1][1]);
        matrix[1][1] = 50;
        System.out.println("After: matrix[1][1] = " + matrix[1][1]);
        
        // Getting dimensions of a 2D array
        System.out.println("\nDimensions of the matrix:");
        System.out.println("Number of rows: " + matrix.length);
        System.out.println("Number of columns in first row: " + matrix[0].length);
        
        // Three-dimensional arrays
        System.out.println("\n--- Three-Dimensional Arrays ---");
        
        // 1. Declaration and initialization of a 3D array
        int[][][] cube = {
            {
                {1, 2},
                {3, 4}
            },
            {
                {5, 6},
                {7, 8}
            }
        };
        
        // Dimensions of the cube: 2x2x2
        System.out.println("Cube dimensions: " + cube.length + "x" + 
                         cube[0].length + "x" + cube[0][0].length);
        
        // Printing the 3D array
        System.out.println("\nCube contents:");
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        // Accessing elements in a 3D array
        System.out.println("Accessing elements in the cube:");
        System.out.println("cube[0][0][0] = " + cube[0][0][0]); // First element
        System.out.println("cube[1][1][1] = " + cube[1][1][1]); // Last element
        
        // 2. Declaration and allocation separately
        int[][][] threeDArray = new int[2][3][4];
        
        // Initializing the 3D array
        value = 1;
        for (int i = 0; i < threeDArray.length; i++) {
            for (int j = 0; j < threeDArray[i].length; j++) {
                for (int k = 0; k < threeDArray[i][j].length; k++) {
                    threeDArray[i][j][k] = value++;
                }
            }
        }
        
        // Printing the 3D array using enhanced for loop
        System.out.println("\nthreeDArray contents (first layer):");
        for (int j = 0; j < threeDArray[0].length; j++) {
            for (int k = 0; k < threeDArray[0][j].length; k++) {
                System.out.print(threeDArray[0][j][k] + " ");
            }
            System.out.println();
        }
        
        // Jagged arrays (arrays with different lengths)
        System.out.println("\n--- Jagged Arrays ---");
        
        // Creating a jagged array
        int[][] jaggedArray = new int[3][];
        
        // Each sub-array has a different length
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[4];
        jaggedArray[2] = new int[3];
        
        // Initializing the jagged array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = (i + 1) * 10 + j;
            }
        }
        
        // Printing the jagged array
        System.out.println("Jagged array contents:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.print("Row " + i + " (length " + jaggedArray[i].length + "): ");
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        
        // Alternative initialization of a jagged array
        int[][] jaggedArray2 = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\nJagged array 2 contents:");
        for (int[] row : jaggedArray2) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        // Common operations with 2D arrays
        System.out.println("\n--- Common Operations with 2D Arrays ---");
        
        // 1. Finding the sum of all elements
        int sum = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                sum += cell;
            }
        }
        System.out.println("Sum of all elements in the matrix: " + sum);
        
        // 2. Finding the maximum element
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell > max) {
                    max = cell;
                }
            }
        }
        System.out.println("Maximum element in the matrix: " + max);
        
        // 3. Transposing a matrix (rows become columns, columns become rows)
        int[][] original = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        // Original is 2x3, transpose will be 3x2
        int[][] transpose = new int[original[0].length][original.length];
        
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                transpose[j][i] = original[i][j];
            }
        }
        
        System.out.println("\nOriginal matrix:");
        for (int[] row : original) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nTransposed matrix:");
        for (int[] row : transpose) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        // 4. Matrix multiplication
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        // Result matrix dimensions: matrixA.rows x matrixB.columns
        int[][] result = new int[matrixA.length][matrixB[0].length];
        
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        
        System.out.println("\nMatrix A:");
        for (int[] row : matrixA) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nMatrix B:");
        for (int[] row : matrixB) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nMatrix A x Matrix B:");
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}