package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] indeg;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indeg = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            indeg[y]++; // y로 들어가는 간선 개수 추가
        }
        solution();
    }

    static void solution() {
        Deque<Integer> queue = new LinkedList<>();

        // 들어가는 간선이 없다면 누구든 앞에 갈 수 있다.
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            // graph X와 연결된 정점들을 확인한다.
            for (int y : graph[x]) {
                indeg[y]--; // 방문했으니 들어가는 간선이 하나 줄어든다.
                if (indeg[y] == 0) queue.add(y);
            }
        }
        System.out.println(sb.toString());
    }
}
