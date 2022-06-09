package 나혼자한다;

import java.io.*;
import java.util.*;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ6487_두직선의교차여부 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void getRelation(Point p1, Point p2, Point p3, Point p4) throws IOException {
        float a1 = (float) 0;
        float a2 = (float) 0;
        float b1 = (float) 0;
        float b2 = (float) 0;  //  기울기와 y 절편
        float same1 = (float) 0;
        float same2 = (float) 0;   // 만나는 점

        if (p2.x == p1.x) { // y 축과 평행한 경우
            same1 = p1.x;   // x = p1.x 방정식
        } else {
            a1 = (float) (p2.y - p1.y) / (p2.x - p1.x);
            b1 = (float) p1.y - a1 * p1.x;
        }

        if (p4.x == p3.x) { // y 축과 평행한 경우
            same2 = p3.x;   // x = p3.x 방정식
        } else {
            a2 = (float) (p4.y - p3.y) / (p4.x - p3.x);
            b2 = (float) p3.y - a2 * p3.x;
        }

        if (same1 != 0 || same2 != 0) { // 하나라도 y축에 평행한 경우
            if (same1 == same2) {   // 같은 직선인 경우
                bw.write("LINE\n");
            } else if (same1 != 0 && same2 != 0) {  // 평행한 경우
                bw.write("NONE\n");
            } else {    // 하나만 y축에 평행한 경우
                if (p1.x == p2.x) {
                    bw.write("POINT " + String.format("%.2f", same1) + " " + String.format("%.2f", a2 * same1 + b2) + "\n");
                }
                if (p3.x == p4.x) {
                    bw.write("POINT " + String.format("%.2f", same2) + " " + String.format("%.2f", a1 * same2 + b1) + "\n");
                }
            }
        } else if (a1 == a2) { // 기울기가 같은 경우
            if (b1 == b2) { // 같은 직선인 경우
                bw.write("LINE\n");
            } else {    // 평행한 경우
                bw.write("NONE\n");
            }
        } else {    // 한점에서 만나는 경우
            float x = -(b1 - b2) / (a1 - a2);
            float y = a1 * x + b1;
            bw.write("POINT " + String.format("%.2f", x) + " " + String.format("%.2f", y) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 점 4개 입력 받기
            for (int j = 1; j <= 4; j++) {
                points[j] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            getRelation(points[1], points[2], points[3], points[4]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}