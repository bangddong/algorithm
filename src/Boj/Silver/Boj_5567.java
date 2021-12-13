package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] dist;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 상근이 친구 수 (상근이 포함)
        M = Integer.parseInt(br.readLine()); // 상근이 친구관계
        dist = new int[N + 1]; // 거리 카운트
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph[x].add(y); // 무방향 그래프는 양쪽으로 연결되어 있다.
            graph[y].add(x);
        }

        solution();
    }

    static void solution() {
        Arrays.fill(dist, -1);
        System.out.println(BFS());
    }

    static int BFS() {
        int cnt = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1); // 상근이의 위치는 항상 1이다.
        dist[1] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            if (1 <= dist[x] && dist[x] <= 2) cnt++; // 상근이와의 관계가 친구 or 친구의 친구라면 카운트 한다.
            if (dist[x] == 2) continue; // 친구 관계의 거리가 2면 최대이니 그 이상은 볼 필요 없다.

            for (int y : graph[x]) {
                if (dist[y] != -1) continue; // 이미 방문한 점이라면 방문하지 않는다!
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return cnt;
    }
}
