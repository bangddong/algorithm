package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20364 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, Q;
    static int[] ducks;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 땅의 개수
        Q = Integer.parseInt(st.nextToken()); // 오리의 마리 수
        ducks = new int[Q];
        for (int i = 0; i < Q; i++) ducks[i] = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        visit = new boolean[N + 1];
        for (int x : ducks) {
            int answer = 0, tmp = x;
            // 오리가 원하는 땅에서부터 루트를 향해 찾아가자!
            while (x != 1) {
                // 경로에 이미 땅의 소유주가 있다!
                if (visit[x]) answer = x;
                // 한 칸 올라가자!
                x >>= 1;
            }
            visit[tmp] = true;
            // 소유주가 있는 땅을 만났으면 해당 땅의 번호일거고
            // 만나지 않았다면 초기값인 0으로 있다!
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }
}
