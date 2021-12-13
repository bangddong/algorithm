package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solution(N, 1, 2, 3);
        System.out.println((int)Math.pow(2, N) - 1);
        System.out.println(sb);
    }

    // 1. 최하단의 블록을 목적지로 옮기기 위해선 그 위에 있는 n-1개의 원판이 다른 기둥으로 이동해야 한다.
    // 2. n-1개의 원판 이동이 완료되면 최하단의 블록은 목적지에 갈 수 있다.
    // 3. 이해가 쉽도록 from = 1번기둥, other = 2번기둥, to = 3번기둥
    static void solution(int n, int from, int other, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        // n-1개를 1번기둥 => 2번기동으로 이동
        solution(n - 1, from, to, other);
        // n-1개의 이동이 끝났다면 최하단 블록을 목적지에 이동
        sb.append(from).append(" ").append(to).append("\n");
        // 2번 기둥으로 옮겨진 나머지 블록도 목적지인 3번 기둥으로 이동
        solution(n - 1, other, from, to);
    }
}
