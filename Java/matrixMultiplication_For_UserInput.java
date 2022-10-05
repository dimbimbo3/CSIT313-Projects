/**
 * @author Dan Imbimbo
 * @date 2/10/22
 * @description Multiplies 2 given matrices via for loops and then displays the result.
 */
import java.util.Scanner;

class matrixMultiplication_For_UserInput {
    public static void main(String[] args){
        int m1Cols = 0;
        int m1Rows = 0;
        int m2Cols = 0;
        int m2Rows = 0;
        
        System.out.println("[FOR LOOP VERSION]");
        //Gets col and row counts from user for matrix 1
        System.out.print("Enter the number of rows for matrix 1:");
        m1Rows = setRowCol();
        System.out.print("Enter the number of columns for matrix 1:");
        m1Cols = setRowCol();
        
        //The number of rows of matrix 2 must equal 
        //the number of cols of matrix 1 for matrix multiplication
        System.out.println("\nNumber of rows for matrix 2:"+m1Cols);
        m2Rows = m1Cols;
        //Gets col count from user for matrix 2
        System.out.print("Enter the number of cols for matrix 2:");
        m2Cols = setRowCol();
        
        //Initializes 2D matrices
        double[][] matrix1 = new double[m1Rows][m1Cols];
        double[][] matrix2 = new double[m2Rows][m2Cols];
        double[][] resultingMatrix = new double[m1Rows][m2Cols];
        
        //Calls methods to set matrix values and then display them for matrix 1
        System.out.println("\nMatrix 1:");
        setMatrix(matrix1, m1Rows, m1Cols);
        System.out.println("\nMatrix 1:");
        getMatrix(matrix1, m1Rows, m1Cols);
        
        //Calls methods to set matrix values and then display them for matrix 2
        System.out.println("\nMatrix 2:");
        setMatrix(matrix2, m2Rows, m2Cols);
        System.out.println("\nMatrix 2:");
        getMatrix(matrix2, m2Rows, m2Cols);
        
        //Calls methods to multiply matrix 1 and 2 and then dispay the resulting matrix
        multiplyMatrices(matrix1, m1Rows, matrix2, m2Rows, m2Cols, resultingMatrix);
        System.out.println("\nMatrix 1 * Matrix 2:");
        getMatrix(resultingMatrix, m1Rows, m2Cols);
    }
    
    public static int setRowCol(){
        Scanner keyboard = new Scanner(System.in); //scanner object for user input
        int val = keyboard.nextInt();
        keyboard.nextLine(); //clears new line character
        
        return val;
    }
    
    public static void setMatrix(double[][] matrix, int rows, int cols){
        Scanner keyboard = new Scanner(System.in); //Scanner object for user input
        
        //Retrieves user input for each value of the matrix
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print("Enter the value of ["+i+","+j+"]:");
                matrix[i][j]=keyboard.nextDouble();
                keyboard.nextLine(); //clears new line character
            }    
        }
    }
    
    public static void getMatrix(double[][] matrix, int rows, int cols){
        //Prints out the values of the matrix
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
    public static void multiplyMatrices(double[][] matrix1, int m1Rows, double[][] matrix2, int m2Rows, int m2Cols, double[][] resultingMatrix){
        //multiples each row of matrix 1 by each column of matrix 2
        //and puts the resulting sums of each into another matrix
        for(int x = 0; x < m1Rows; x++){
            for(int y = 0; y < m2Cols; y++){
                for(int z = 0; z < m2Rows; z++){
                    resultingMatrix[x][y] += matrix1[x][z] * matrix2[z][y];
                }
            }
        }
    }
}
