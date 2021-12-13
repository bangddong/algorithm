package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_8958 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 1. cnt는 0으로 초기화
    // 2. O를 만나면 cnt + 1
    // 3. X를 만나면 cnt는 다시 0으로 초기화
    // 4. 각 문자열 검증이 끝나면 answer += cnt;
    static void solution(String str) {
        int cnt = 0, answer = 0;
        for (char x : str.toCharArray()) {
            if (x == 'O') {
                cnt++;
            } else {
                cnt = 0;
            }
            answer += cnt;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            solution(br.readLine());
        }
    }
}
