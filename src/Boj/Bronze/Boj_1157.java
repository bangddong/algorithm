package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1157 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 1. 입력받은 문자열 소문자로 변환
    // 2. 문자열만큼의 배열을 생성하여 체크
    // 3. 최대값 도출
    // 4. 최대값 여러개인지 확인?
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        str = str.toUpperCase();
        int[] chk = new int[str.length()];
        int max = Integer.MIN_VALUE, idx = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            int cnt = 1;
            if (chk[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && chk[j] == 0) {
                    cnt++;
                    chk[j] = -1;
                }
            }
            chk[i] = cnt;
            if (cnt > max) {
                max = cnt;
                idx = i;
            }
        }
        int cnt = 0;
        for (int x : chk) {
            if (x >= max) {
                cnt++;
            }
        }
        System.out.println(cnt > 1 ? "?" : str.charAt(idx));
    }
}
