package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, V;
    //static int[][] adj; // 인접 행렬 사용
    static ArrayList<Integer>[] adj; // 인접 리스트 사용
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        //adj = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
//            adj[x][y] = 1;
//            adj[y][x] = 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        solution();
    }

    static void solution() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' '); // 방문한 기록 append
//        for (int y = 1; y <= N; y++) {
//            if (adj[x][y] == 0) continue; // 갈 수 있는지?
//            if (visit[y]) continue; // 이미 방문 했는지?
//            dfs(y); // 방문하자!
//        }
        for (int y : adj[x]) {
            if (visit[y]) continue; // 이미 방문 했는지?
            dfs(y); // 방문하자!
        }
    }
    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visit[x] = true;

        while(!queue.isEmpty()) { // 큐에 방문 노선이 남아있는지?
            x = queue.poll(); // x통해 방문예정이니 poll
            sb.append(x).append(' ');
//            for (int y = 1; y <= N; y++) {
//                if (adj[x][y] == 0) continue; // 갈 수 있는지?
//                if (visit[y]) continue; // 이미 방문 했는지?
//                queue.add(y); // 방문 해봐야 하니 add
//
//                visit[y] = true;
//            }
            for (int y : adj[x]) {
                if (visit[y]) continue; // 이미 방문 했는지?
                queue.add(y); // 방문 해봐야 하니 add

                visit[y] = true;
            }
        }
    }
}
