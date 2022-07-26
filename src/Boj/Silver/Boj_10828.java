package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10828 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[0];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String action = st.nextToken();
            arr = solution(action, arr);
        }

        System.out.println(sb.toString());
    }

    public static int[] solution(String action, int[] arr) {
        if (action.equals("push")) {
            arr = Stack.push(arr, Integer.parseInt(st.nextToken()));
        } else {
            switch (action) {
                case "pop":
                    arr = Stack.pop(arr);
                    break;
                case "size":
                    Stack.size(arr);
                    break;
                case "empty":
                    Stack.empty(arr);
                    break;
                case "top":
                    Stack.top(arr);
            }
        }

        return arr;
    }

    public static class Stack {

        // 제일 앞에 숫자를 입력
        public static int[] push(int[] arr, int n) {
            int[] returnArr = new int[arr.length + 1];
            returnArr[0] = n;

            System.arraycopy(arr, 0, returnArr, 1, arr.length);
            arr = returnArr;
            return arr;
        }

        // 제일 앞에 숫자를 출력
        public static int[] pop(int[] arr) {
            if (arr.length == 0) {
                sb.append(-1).append("\n");
            } else {
                int[] returnArr = new int[arr.length - 1];
                sb.append(arr[0]).append("\n");

                System.arraycopy(arr, 1, returnArr, 0, arr.length - 1);
                arr = returnArr;
            }
            return arr;
        }

        // 배열의 크기를 반환
        public static void size(int[] arr) {
            sb.append(arr.length).append("\n");
        }

        // 비어있는지 체크
        public static void empty(int[] arr) {
            if (arr.length == 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        // 가장 윗 값을 반환 (pop 과 다르게 빼지는 않음)
        public static void top(int[] arr) {
            if (arr.length == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(arr[0]).append("\n");
            }
        }
    }

}
