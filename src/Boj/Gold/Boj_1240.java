package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 이어지는 정점 좌표와 비용을 담는다.
    static class Edge implements Comparable<Edge>{
        int y, c;

        public Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    static int N, M;
    static int[] dist;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
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
        //DFS(x, -1, y, 0);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(x, y);
    }

    static void DFS(int x, int prev, int goal, int cost) {
        if (x == goal) { // 목적지에 도착했다!
            System.out.println(cost);
            return;
        }
        for (Edge edge : graph[x]) {
            if (edge.y == prev) continue; // 이전 노드는 방문하지 않는다!
            DFS(edge.y, x, goal, cost + edge.c); // 이동 비용 누적
        }
    }

    static void dijkstra(int x, int y) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));
        dist[x] = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.y;
            int nowCost = tmp.c;
            if (nowCost > dist[now]) continue;
            for (Edge edge : graph[now]) {
                if (dist[edge.y] > nowCost + edge.c) {
                    dist[edge.y] = nowCost + edge.c;
                    pq.offer(new Edge(edge.y, nowCost + edge.c));
                }
            }
        }
        System.out.println(dist[y]);
    }
}
