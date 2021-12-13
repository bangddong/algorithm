package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int L, C;
    static int[] selected;
    static char[] charArr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        charArr = new char[C + 1];
        selected = new int[C + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= C; i++) {
            charArr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(charArr, 1, C + 1);
        solution(1);
        System.out.println(sb.toString());
    }

    // 모음 여부 판별
    static boolean isCol(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void solution(int level) {
        // L개의 수열을 완성했을 때
        if (level == L + 1) {
            int col = 0, con = 0;
            for (int i = 1; i <= L; i++) {
                if (isCol(charArr[selected[i]])) col++;
                else con++;
            }
            if (col >= 1 && con >= 2) {
                for (int i = 1; i <= L; i++) sb.append(charArr[selected[i]]);
                sb.append("\n");
            }
        } else {
            for (int i = selected[level - 1] + 1; i <= C; i++) {
                selected[level] = i;
                solution(level + 1);
                selected[level] = 0;
            }
        }
    }
}
