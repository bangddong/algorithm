package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15900 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, cnt = 0;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        solution();
    }

    static void solution() {
        DFS(1, -1, 0);
        // 성원이가 먼저 시작하니 이기려면 타고 올라가는 총 수가 홀수여야 한다.
        System.out.println((cnt % 2 == 0) ? "No" : "Yes");
    }

    static void DFS(int x, int parent, int depth) {
        // 연결된 간선이 하나 뿐이고 그 하나가 부모라면 그 노드는 말단 노드이다.
        if (graph[x].size() == 1 && graph[x].get(0) == parent) {
            // 타고 내려온 depth를 총 depth에 더한다.
            cnt += depth;
            return;
        }
        for (int y : graph[x]) {
            if (y == parent) continue;
            DFS(y, x, depth + 1);
        }
    }
}
