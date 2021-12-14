package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력에서 주어지는 대문자 알파벳에서 - A를 빼면 0 ~ 숫자
            int parent = st.nextToken().charAt(0) - 'A';
            int childX = st.nextToken().charAt(0) - 'A';
            int childY = st.nextToken().charAt(0) - 'A';
            // 비어있다는 표시인 .이 주어지면 값은 -19가 나온다.
            tree[parent][0] = (childX == -19) ? -1 : childX;
            tree[parent][1] = (childY == -19) ? -1 : childY;
        }
        solution();
    }

    static void solution() {
        // 전위 순회
        preOrder(0);
        sb.append('\n');
        // 중위 순회
        inOrder(0);
        sb.append('\n');
        // 후위 순회
        postOrder(0);
        System.out.println(sb.toString());
    }

    static void preOrder(int x) {
        if (x == -1) return;
        // 현재 노드값 출력
        sb.append((char)(x + 'A'));
        // 왼쪽 자식 호출
        preOrder(tree[x][0]);
        // 오른쪽 자식 호출
        preOrder(tree[x][1]);
    }

    static void inOrder(int x) {
        if (x == -1) return;
        // 왼쪽 자식 호출
        inOrder(tree[x][0]);
        // 현재 노드값 출력
        sb.append((char)(x + 'A'));
        // 오른쪽 자식 호출
        inOrder(tree[x][1]);
    }

    static void postOrder(int x) {
        if (x == -1) return;
        // 왼쪽 자식 호출
        postOrder(tree[x][0]);
        // 오른쪽 자식 호출
        postOrder(tree[x][1]);
        // 현재 노드값 출력
        sb.append((char)(x + 'A'));
    }
}
