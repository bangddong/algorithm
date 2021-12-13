package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1152 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        sb.append(br.readLine());
        countWord();
    }

    // 공백을 기준으로 나누어 총 갯수를 출력한다.
    static void countWord() {
        st = new StringTokenizer(sb.toString(), " ");
        System.out.println(st.countTokens());
    }
}
