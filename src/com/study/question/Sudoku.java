package com.study.question;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 * 数独
 *
 * @author zhouhuan
 * @date 2022/09/17
 */
public class Sudoku {
    static int matrix[][] = new int[9][9];
    public static void readfile() {
        try {
            File file = new File("D:\\Code\\力扣刷题\\9月1号\\src\\com\\study\\question\\data2_5.txt");
            InputStream input = new FileInputStream(file);
            int temp;
            int i, j;
            i = 0;
            j = 0;
            while ((temp = input.read()) != -1) {
                if (temp >= 48 && temp <= 57) {
                    matrix[i][j] = temp - 48;
                    j++;
                    if (j == 9) {
                        i++;
                        j = 0;
                    }
                    if (i == 9) {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Sudoku.readfile();
        Sudoku.flashback(0, 0);
        Sudoku.showmatrix();
    }

    public static boolean flashback(int i, int j) {
        if (i == 9) {
            return true;
        }
        if (matrix[i][j] == 0) {
            for (int k = 1; k < 10; k++) {
                if (check(i, j, k)) {
                    matrix[i][j] = k;
                    boolean flashback = flashback(i + (j + 1) / 9, (j + 1) % 9);
                    if (flashback) {
                        return true;
                    }
                    matrix[i][j] = 0;
                }
            }
        } else {
            return flashback(i + (j + 1) / 9, (j + 1) % 9);
        }
        return false;
    }

    public static boolean check(int i, int j, int num) {
        for (int k = 0; k < 9; k++) {
            if (matrix[i][k] == num || matrix[k][j] == num) {
                return false;
            }
        }
        int row, col, row_high, col_high;
        row = (i / 3) * 3;
        col = (j / 3) * 3;
        row_high = row + 3;
        col_high = col + 3;
        for (int t1 = row; t1 < row_high; t1++) {
            for (int t2 = col; t2 < col_high; t2++) {
                if (matrix[t1][t2] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void showmatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
