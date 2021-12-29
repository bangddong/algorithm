package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, M, P;
    static int[] indeg, order, maxCnt;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            M = Integer.parseInt(st.nextToken()); // 노드의 수
            P = Integer.parseInt(st.nextToken()); // 간선의 수
            indeg = new int[M + 1]; // 각 노드의 진입 차수의 수
            maxCnt = new int[M + 1]; // 해당 노드로 들어오는 강의 수
            order = new int[M + 1]; // 진입 순서

            graph = new ArrayList[M + 1];
            for(int i = 1; i <= M; i++) graph[i] = new ArrayList<>();
            for (int i = 1; i <= P; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                indeg[y]++;
            }
            solution();
        }
        System.out.println(sb.toString());
    }

    static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            // 진입 차수가 0인 건을 미리 add한다.
            if (indeg[i] == 0) {
                queue.add(i);
                // 강의 근원은 1로 한다.
                order[i]++;
                maxCnt[i]++;
            }
        }

        int answer = 0;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            if (maxCnt[x] >= 2) order[x]++; // 들어오는 강이 2개 이상이면 순서를 증가시킨다.
            answer = Math.max(answer, order[x]); // 정답 갱신.
            for (int y : graph[x]) {
                indeg[y]--; // 간선 정보를 삭제한다.
                if (indeg[y] == 0) queue.add(y); // 해당 노드로 향하는 간선은 없다.
                if (order[y] == order[x]) maxCnt[y]++; // 동일 순서에서 또 방문했다.
                // 스트랄러 순서는 들어오는 순서 중 최대값으로 한다.
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }
        }
        sb.append(K).append(' ').append(answer);
    }
}
