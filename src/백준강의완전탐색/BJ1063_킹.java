package 백준강의완전탐색;

import java.io.*;
import java.util.Arrays;
import java.util.List;

enum Move{
    R(0, 1), L(0, -1), B(1, 0), T(-1, 0), RT(-1,1), LT(-1, -1), RB(1, 1), LB(1, -1);
    public int y;
    public int x;

    Move(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class BJ1063_킹 {
    static int[][] chess = new int[8][8];
    static Character[] row1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static Character[] col1 = {'8', '7', '6', '5', '4', '3', '2', '1'};
    static List<Character> row = Arrays.asList(row1);
    static List<Character> col = Arrays.asList(col1);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int kingX = row.indexOf(input[0].charAt(0));
        int kingY = col.indexOf(input[0].charAt(1));
        int stoneX = row.indexOf(input[1].charAt(0));;
        int stoneY = col.indexOf(input[1].charAt(1));
        int test = Integer.parseInt(input[2]);

        chess[kingY][kingX] = 1;
        chess[stoneY][stoneX] = 2;

        while(test-- > 0){
            Move m = Move.valueOf(br.readLine());
            int moveKingX = kingX + m.x;
            int moveKingY = kingY + m.y;
            int moveStoneX;
            int moveStoneY;
            if(moveKingX == stoneX && moveKingY == stoneY) {
                moveStoneX = stoneX + m.x;
                moveStoneY = stoneY + m.y;
            } else {
                moveStoneX = stoneX;
                moveStoneY = stoneY;
            }
            boolean condition = 0 <= moveKingX && moveKingX < 8 &&
                                    0 <= moveKingY && moveKingY < 8 &&
                                    0 <= moveStoneX && moveStoneX < 8 &&
                                    0 <= moveStoneY && moveStoneY < 8;

            if(condition){
                kingX = moveKingX;
                kingY = moveKingY;
                stoneX = moveStoneX;
                stoneY = moveStoneY;
            }
        }

        System.out.println(row1[kingX] + "" + col1[kingY]);
        System.out.println(row1[stoneX] + "" + col1[stoneY]);
    }
}