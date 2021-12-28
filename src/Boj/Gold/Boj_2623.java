package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_2623 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indeg = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

            // 간선 정보가 따로따로 입력된게 아닌 한 줄로 쭉 나와있으니
            // x를 바꿔가며 그래프를 생성한다.
            for (int j = 1; j < cnt; j++) {
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                indeg[y]++; // y로 가는 간선 개수 추가
                x = y;
            }
        }

        solution();
    }

    static void solution() {
        BFS();
        // 사이즈가 N개가 아니다 == 모든 가수의 순서를 정하지 못했다!
        if(answer.size() != N) System.out.println(0);
        else {
            for (int x : answer) sb.append(x).append('\n');
            System.out.println(sb.toString());
        }
    }

    static void BFS() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            answer.add(x);
            for (int y : graph[x]) {
                indeg[y]--; // 방문했으니 들어가는 간선이 하나 줄어든다.
                if (indeg[y] == 0) queue.add(y);
            }
        }
    }
}
