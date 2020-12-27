package 백준강의그리디;

import java.util.*;

public class BJ2873_롤러코스터_정답 {
    public static void append(StringBuilder s, char c, int cnt) {
        for (int i=0; i<cnt; i++) {
            s.append(c);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        StringBuilder s = new StringBuilder();
        if (n%2 == 1) {
            for (int i=0; i<n; i++) {
                if (i%2 == 0) {
                    append(s, 'R', m-1);
                    if (i != n-1) {
                        append(s, 'D', 1);
                    }
                } else {
                    append(s, 'L', m-1);
                    append(s, 'D', 1);
                }
            }
        } else if (m%2 == 1) {
            for (int j=0; j<m; j++) {
                if (j%2 == 0) {
                    append(s, 'D', n-1);
                    if (j != m-1) {
                        append(s, 'R', 1);
                    }
                } else {
                    append(s, 'U', n-1);
                    append(s, 'R', 1);
                }
            }
        } else {
            int x, y;
            x = 0;
            y = 1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if ((i+j)%2 == 1) {
                        if (a[x][y] > a[i][j]) {
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            int x1 = 0;
            int y1 = 0;
            int x2 = n-1;
            int y2 = m-1;
            StringBuilder s2 = new StringBuilder();
            while (x2 - x1 > 1) {
                if (x1/2 < x/2) {
                    append(s, 'R', m-1);
                    append(s, 'D', 1);
                    append(s, 'L', m-1);
                    append(s, 'D', 1);
                    x1 += 2;
                }
                if (x/2 < x2/2) {
                    append(s2, 'R', m-1);
                    append(s2, 'D', 1);
                    append(s2, 'L', m-1);
                    append(s2, 'D', 1);
                    x2 -= 2;
                }
            }
            while (y2 - y1 > 1) {
                if (y1/2 < y/2) {
                    append(s, 'D', 1);
                    append(s, 'R', 1);
                    append(s, 'U', 1);
                    append(s, 'R', 1);
                    y1 += 2;
                }
                if (y/2 < y2/2) {
                    append(s2, 'D', 1);
                    append(s2, 'R', 1);
                    append(s2, 'U', 1);
                    append(s2, 'R', 1);
                    y2 -= 2;
                }
            }
            if (y == y1) {
                append(s, 'R', 1);
                append(s, 'D', 1);
            } else {
                append(s, 'D', 1);
                append(s, 'R', 1);
            }
            s2.reverse();
            s.append(s2);
        }

        System.out.println(s);
    }
}
