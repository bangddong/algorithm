package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, vertexCnt, edgeCnt, caseCnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        caseCnt = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break; // 입력의 마지막은 0, 0
            visit = new boolean[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
            }
            solution();
        }
        System.out.println(sb.toString());
    }

    static void solution() {
        caseCnt++;
        int treeCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue; // 방문여부 확인!
            vertexCnt = 0;
            edgeCnt = 0;
            DFS(i);
            // 트리의 조건 = 간선(edge)는 정점(vertex)의 갯수 - 1개 있어야 한다.
            // 무방향 그래프로 *2 하여 비교한다.
            if (edgeCnt == (vertexCnt - 1) * 2) treeCnt++;
        }
        sb.append("Case ").append(caseCnt).append(": ");
        if (treeCnt == 0) sb.append("No trees.");
        else if (treeCnt == 1) sb.append("There is one tree.");
        else sb.append("A forest of ").append(treeCnt).append(" trees.");
        sb.append('\n');
    }

    static void DFS(int x) {
        vertexCnt++; // 정점 갯수 카운트!
        edgeCnt += graph[x].size(); // graph[x].size == 해당 정점에 연결 된 간선의 수
        visit[x] = true; // 방문처리!
        for (int y : graph[x]) {
            if (visit[y]) continue; // 방문여부 확인!
            DFS(y);
        }
    }
}
