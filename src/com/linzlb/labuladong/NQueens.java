package com.linzlb.labuladong;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/2 15:10
 * @Function:N皇后问题
 * 国际象棋的棋盘中，皇后可以攻击同一行，同一列，还有左上，左下，右上，右下四个方向的任意单位
 * 现在给你一个N*N的棋盘，让你放置n个皇后，使得她们不能相互攻击，返回所有合法的结果
 * 用0表示空，用1表示皇后
 */
public class NQueens {

    // 皇后/棋盘的个数
    private static final int QUEEN_NUM = 10;

    // 首先定义一个N * N 的棋盘
    private static final int[][] Checkerboard = new int[QUEEN_NUM][QUEEN_NUM];

    // 定义一共有多少种放置皇后的算法
    private static int COUNT = 0;

    /**
     * 打印棋盘
     */
    public static final void show() {
        System.out.println("第" + (++COUNT) + "次摆法");
        for (int i = 0; i < QUEEN_NUM; i++) {
            for (int j = 0; j < QUEEN_NUM; j++) {
                System.out.print(Checkerboard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 判断当前位置是否能放置皇后
     *
     * @param Checkerboard
     * @param row
     *            行数
     * @param col
     *            列数
     * @return
     */
    public static final boolean check(int row, int col) {

        //皇后是从上往下一层一层放置，所以只需要检查正上，左上，右上

        // 判断当前位置的上面是否有皇后
        for (int i = row - 1; i >= 0; i--) {
            if (Checkerboard[i][col] == 1)
                return false;
        }

        // 判断左上是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        // 判断右上是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < QUEEN_NUM; i--, j++) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        return true;
    }

    /**
     * 从第n行放置皇后
     *
     * @param row
     */
    public static final void play(int row) {
        // 遍历当前行的所有单元格 以列为单元
        for (int i = 0; i < QUEEN_NUM; i++) {
            // 是否能够放置皇后
            if (check(row, i)) {
                Checkerboard[row][i] = 1;

                if (row == QUEEN_NUM - 1) {
                    // 最后行 放置完毕 打印皇后
                    show();
                } else {
                    // 放置下一行
                    play(row + 1);
                }

                //回退到当前步骤，把皇后设置为0
                Checkerboard[row][i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        play(0);
    }

}
