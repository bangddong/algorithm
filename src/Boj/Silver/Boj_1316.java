package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n = 0, answer = 0;
    static String[] str;
    // 처음 등장하는 문자를 저장
    // 이후에 저장했던 문자가 나오면 false
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        solution();
    }

    static void solution() {
        for (String x : str) {
            if (isGroup(x)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isGroup(String word) {
        // 알파벳 체크 배열
        boolean[] chk = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            // 이미 사용한 적 있다면 false
            if (chk[word.charAt(i) - 97]) {
                return false;
            } else {
                // 현재 문자와 다음 문자가 같지 않다면 신규 문자로 체크처리
                if (i + 1 < word.length() && word.charAt(i + 1) != word.charAt(i)) {
                    chk[word.charAt(i) - 97] = true;
                }
            }
        }
        return true;
    }
}
