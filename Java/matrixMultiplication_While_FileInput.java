/**
 * @author Dan Imbimbo
 * @date 2/11/22
 * @description Multiplies 2 matrices, given by text files, via for loops and then displays the result.
 */
import java.io.*;
import java.util.Scanner;

class matrixMultiplication_While_FileInput {
    public static void main(String[] args){
        System.out.println("[WHILE LOOP VERSION]");
        
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
            while(input.hasNextLine()){
                input.nextLine();
                rows++; //counts how many rows are in the matrix
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
            while(cols < line.length){
                cols++; //counts how many columns are in a row
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION: "+e);
            System.exit(0); //end program
        }
        
        return cols;
    }
    
    public static void setMatrix(File file, double[][] matrix, int rows, int cols){
        //counters for loops
        int i = 0;
        int j = 0;
        
        try{
            Scanner input = new Scanner(file); //Scanner object to read the given file

            //Retrieves input for each value of the matrix in the txt file
            while(i < rows){
                j=0; //resets column counter
                String[] line = input.nextLine().split(","); //reads one row of the matrix at a time
                while(j < cols){
                    matrix[i][j]=Double.parseDouble(line[j]); //stores each column value of the given row into the matrix
                    System.out.println("Value of ["+i+","+j+"]:"+matrix[i][j]);
                    j++; //increments column counter
                }
                i++; //increments row counter
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION: "+e);
            System.exit(0); //end program
        }
    }
    
    public static void getMatrix(double[][] matrix, int rows, int cols){
        //counters for loops
        int i = 0;
        int j = 0;
        
        //Prints out the values of the matrix
        while(i < rows){
            j=0; //resets column counter
             while(j < cols){
                System.out.print(matrix[i][j]+"\t");
                j++; //increments column counter
            }
            System.out.println("");
            i++; //increments row counter
        }
    }
    
    public static void multiplyMatrices(double[][] matrix1, int m1Rows, double[][] matrix2, int m2Rows, int m2Cols, double[][] resultingMatrix){
        //counters for loops
        int x = 0;
        int y = 0;
        int z = 0;
        
        //Multiples each row of matrix 1 by each column of matrix 2
        //And puts the resulting sums of each into another matrix
        while(x < m1Rows){
            y=0; //resets matrix 2 column counter
            while(y < m2Cols){
                z=0; //resets matrix 2 row counter
                while(z < m2Rows){
                    resultingMatrix[x][y] += matrix1[x][z] * matrix2[z][y];
                    z++; //increments matrix 2 row counter
                }
                y++; //increments matrix 2 column counter
            }
            x++; //increments matrix 1 row counter
        }
    }
}
