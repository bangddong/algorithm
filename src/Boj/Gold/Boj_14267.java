package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_14267 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) continue;
            tree[x].add(i); // 밑으로만 뻗어나가니 반대의 경우는 add하지 않는다.
        }

        cnt = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            // x = 칭찬받은 번호 , y = 칭찬 수치
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            cnt[x] += y;
        }

        solution();
    }

    static void solution() {
        DFS(1);
        for (int i = 1; i <= N; i++) sb.append(cnt[i]).append(' ');
        System.out.println(sb.toString());
    }

    static void DFS(int x) {
        for (int y : tree[x]) {
            cnt[y] += cnt[x]; // 부하 칭찬 누적치에 본인 칭찬 누적치를 더한다!
            DFS(y);
        }
    }
}
