package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치
        dist = new int[100001]; // 입력 최대값
        solution();
    }

    static void solution() {
        Arrays.fill(dist, -1); // 방문여부 및 카운트 체크용
        BFS();
        System.out.println(dist[K]);
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N); // 수빈이의 위치부터 시작한다.
        dist[N] = 0; // 방문처리

        while(!Q.isEmpty()) {
            if(dist[K] != -1) break; // 동생을 잡았다!
            int x = Q.poll();
            if (x - 1 >= 0 && dist[x - 1] == -1) { // -1 했을 경우
                Q.add(x - 1);
                dist[x - 1] = dist[x] + 1;
            }
            if (x + 1 <= 100000 && dist[x + 1] == -1) { // +1 했을 경우
                Q.add(x + 1);
                dist[x + 1] = dist[x] + 1;
            }
            if (x * 2 <= 100000 && dist[x * 2] == -1) { // *2 했을 경우
                Q.add(x * 2);
                dist[x * 2] = dist[x] + 1;
            }
        }
    }
}
