package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x1, y1, r1, x2, y2, r2;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            solution();
        }
    }

    // 1. 두 원의 중심이 같고, 반지름도 같을 때
    // x1 = x2, y1 = y2, r1 = r2
    // 2. 접점이 없을 때
    // 2-1. 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때
    // (x2 - x1)제곱 + (y2 - y1)제곱 > (r1 + r2)제곱
    // 2-2. 한 원 안에 다른 원이 있으면서 접점이 없을 때
    // (x2 - x1)제곱 + (y2 - y1)제곱 < (r2 - r1)제곱
    // 3. 접접이 한 개일 때
    // 3-1. 내접할 때
    // (x2 - x1)제곱 + (y2 - y1)제곱 = (r2 - r1)제곱
    // 3-2. 외접할 때
    // (x2 - x1)제곱 + (y2 - y1)제곱 = (r2 + r1)제곱
    static void solution() {
        // 두 점 사이의 거리 = (x2 - x1)제곱 + (y2 - y1)제곱
        int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 1
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            System.out.println(-1);
            // 2-1
        } else if(distance > Math.pow(r1 + r2, 2)){
            System.out.println(0);
            // 2-2
        } else if (distance < Math.pow(r2 - r1, 2)) {
            System.out.println(0);
            // 3-1
        } else if (distance == Math.pow(r2 - r1, 2)) {
            System.out.println(1);
            // 3- 2
        } else if (distance == Math.pow(r2 + r1, 2)) {
            System.out.println(1);
            // 그 외
        } else {
            System.out.println(2);
        }
    }
}
