package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, R, Q;
    static int[] qArr, cnt;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 문제에서의 그래프는 가중치 없는 무방향 그래프이다.
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        qArr = new int[Q];
        for (int i = 0; i < Q; i++) qArr[i] = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        DFS(R, -1); // 시작점은 임의의 루트 R로 한다.
        for (int x : qArr) sb.append(cnt[x]).append("\n");
        System.out.println(sb.toString());
    }

    static void DFS(int x, int prevNode) {
        cnt[x] = 1; // 루트 또한 간선의 개수에 포함된다.

        for (int y : tree[x]) {
            if (y == prevNode) continue; // 방문한 노드는 재 방문하지 않는다.
            DFS(y, x);
            cnt[x] += cnt[y]; // 상위 노드에 간선의 개수를 누적한다.
        }
    }
}
