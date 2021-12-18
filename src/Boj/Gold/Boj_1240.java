package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 이어지는 정점 좌표와 비용을 담는다.
    static class Edge {
        int y, c;

        public Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // x좌표 y좌표 cost
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            // 무방향 그래프 생성
            graph[x].add(new Edge(y, c));
            graph[y].add(new Edge(x, c));
        }
        while (M --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            solution(x, y);
        }
    }

    static void solution(int x, int y) {
        DFS(x, -1, y, 0);
    }

    static void DFS(int x, int prev, int goal, int dist) {
        if (x == goal) { // 목적지에 도착했다!
            System.out.println(dist);
            return;
        }
        for (Edge edge : graph[x]) {
            if (edge.y == prev) continue; // 이전 노드는 방문하지 않는다!
            DFS(edge.y, x, goal, dist + edge.c); // 이동 비용 누적
        }
    }
}
