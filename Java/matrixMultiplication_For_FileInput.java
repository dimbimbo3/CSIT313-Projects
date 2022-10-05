/**
 * @author Dan Imbimbo
 * @date 2/11/22
 * @description Multiplies 2 matrices, given by text files, via for loops and then displays the result.
 */
import java.io.*;
import java.util.Scanner;

class matrixMultiplication_For_FileInput {
    public static void main(String[] args){
        System.out.println("[FOR LOOP VERSION]");
        
        //Matrix 1 Variables
        File fileM1 = new File("matrix1.txt");
        int m1Cols = 0;
        int m1Rows = 0;
        
        //Gets col and row counts from file for matrix 1 and assigns them to variables
        m1Rows = getRows(fileM1);
        m1Cols = getCols(fileM1);
        //Prints out the number of rows and columns for matrix 1
        System.out.println("Number of rows for matrix 1:"+m1Rows);
        System.out.println("Number of columns for matrix 1:"+m1Cols);
        
        //Matrix 2 Variables
        File fileM2 = new File("matrix2.txt");
        int m2Cols = 0;
        int m2Rows = 0;
        
        //Gets col and row counts from file for matrix 2 and assigns them to variables
        m2Rows = getRows(fileM2);
        m2Cols = getCols(fileM2);
        //Prints out the number of rows and columns for matrix 1
        System.out.println("Number of rows for matrix 2:"+m2Rows);
        System.out.println("Number of columns for matrix 2:"+m2Cols);
        
        
        if(m1Cols == m2Rows){
            //Initializes 2D matrices
            double[][] matrix1 = new double[m1Rows][m1Cols];
            double[][] matrix2 = new double[m2Rows][m2Cols];
            double[][] resultingMatrix = new double[m1Rows][m2Cols];

            //Calls methods to set matrix values and then display them for matrix 1
            System.out.println("\nMatrix 1:");
            setMatrix(fileM1, matrix1, m1Rows, m1Cols);
            System.out.println("\nMatrix 1:");
            getMatrix(matrix1, m1Rows, m1Cols);

            
            //Calls methods to set matrix values and then display them for matrix 2
            System.out.println("\nMatrix 2:");
            setMatrix(fileM2, matrix2, m2Rows, m2Cols);
            System.out.println("\nMatrix 2:");
            getMatrix(matrix2, m2Rows, m2Cols);

            //Calls methods to multiply matrix 1 and 2 and then dispay the resulting matrix
            multiplyMatrices(matrix1, m1Rows, matrix2, m2Rows, m2Cols, resultingMatrix);
            System.out.println("\nMatrix 1 * Matrix 2:");
            getMatrix(resultingMatrix, m1Rows, m2Cols);
        }
        else{
            System.out.println("MULTIPLICATION ERROR: Matrix 1 must have the same number of columns as Matrix 2 has rows.");
        }
    }
    
    public static int getRows(File file){
        int rows = 0;
        
        //Counts the number of lines in the text file, which represents the rows of the matrix
        try{
            Scanner input = new Scanner(file); //scanner object to read the given file
            for(; input.hasNextLine(); rows++){
                input.nextLine();
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION: "+e);
            System.exit(0); //end program
        }
        
        return rows;
    }
    
    public static int getCols(File file){
        int cols = 0;
        
        //Counts the amount of numbers in a line of the text file, which represents the cols of the matrix
        try{
            Scanner input = new Scanner(file); //scanner object to read the given file
            String[] line = input.nextLine().split(","); //reads in one line of the input and seperates the values by commas into an array
            for(; cols < line.length; cols++){
                //counts how many columns are in a row
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION: "+e);
            System.exit(0); //end program
        }
        
        return cols;
    }
    
    public static void setMatrix(File file, double[][] matrix, int rows, int cols){
        try{
            Scanner input = new Scanner(file); //Scanner object to read the given file

            //Retrieves input for each value of the matrix in the txt file
            for(int i = 0; i < rows; i++){
                String[] line = input.nextLine().split(","); //reads one row of the matrix at a time
                for(int j = 0; j < cols; j++){
                    matrix[i][j]=Double.parseDouble(line[j]); //stores each column value of the given row into the matrix
                    System.out.println("Value of ["+i+","+j+"]:"+matrix[i][j]);
                }
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION: "+e);
            System.exit(0); //end program
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
