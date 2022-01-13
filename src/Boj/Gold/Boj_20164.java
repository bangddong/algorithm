package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20164 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        DFS(N, getCnt(N));
        System.out.println(min + " " + max);
    }

    static void DFS(int x, int sum) {
        // 수가 한자리로 더 이상 분할할 수 없다.
        if (x <= 9) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        // 수가 두 자리로 쪼갠 후 합한다.
        if (x <= 99) {
            int nx =  (x / 10) + (x % 10);
            DFS(nx, sum + getCnt(nx));
            return;
        }

        String strNum = Integer.toString(x);
        for (int i = 0; i <= strNum.length() - 3; i++) {
            for (int j = i + 1; j <= strNum.length() - 2; j++) {
                String str1 = strNum.substring(0, i + 1);
                String str2 = strNum.substring(i + 1, j + 1);
                String str3 = strNum.substring(j + 1);

                int nx = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
                DFS(nx, sum + getCnt(nx));
            }
        }
    }

    static int getCnt(int x) {
        int cnt = 0;
        while(x > 0) {
            int num = x % 10;
            if (num % 2 == 1) cnt++;
            x /= 10;
        }
        return cnt;
    }
}
