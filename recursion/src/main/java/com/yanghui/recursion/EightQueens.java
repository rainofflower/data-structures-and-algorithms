package com.yanghui.recursion;

/**
 * 八皇后问题
 *
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 * 解决方案有 回溯算法 和递归
 * @author YangHui
 */
public class EightQueens {

    private static int n = 8;

    private static int[][] chess;

    private int[][] chess2;

    private int count;

    static{
        chess = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = 0;
            }
        }
    }


    private void eightQueen(int row, int n, int[] a){
        chess2 = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess2[i][j] = chess[i][j];
            }
        }
        if(row == 8){
            System.out.println("第 "+count+1+" 种解法");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(chess2[i][j]+" ");
                }
                System.out.println();
            }
            count++;
        }else{
//            for()
        }
    }
}
