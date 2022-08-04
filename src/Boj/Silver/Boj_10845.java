package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Queue {
        public static int[] push(int[] arr, int num) {
            int[] tmp = new int[arr.length + 1];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            tmp[tmp.length - 1] = num;
            return tmp;
        }
        public static int[] pop(int[] arr) {
            int[] tmp = new int[arr.length - 1];
            System.arraycopy(arr, 1, tmp, 0, arr.length - 1);
            appendResult(arr[0]);
            return tmp;
        }
        public static void size(int[] arr) {
            appendResult(arr.length);
        }
        public static void empty(int[] arr) {
            if (arr.length == 0) {
                appendResult(1);
            } else {
                appendResult(0);
            }
        }
        public static void front(int[] arr) {
            appendResult(arr[0]);
        }
        public static void back(int[] arr) {
            appendResult(arr[arr.length - 1]);
        }
    }

    public static void appendResult(int n) {
        sb.append(n).append("\n");
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[0];

        while (n --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push":
                    arr = Queue.push(arr, Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (arr.length == 0) appendResult(-1);
                    else arr = Queue.pop(arr);
                    break;
                case "size":
                    Queue.size(arr);
                    break;
                case "empty":
                    Queue.empty(arr);
                    break;
                case "front":
                    if (arr.length == 0) appendResult(-1);
                    else Queue.front(arr);
                    break;
                case "back":
                    if (arr.length == 0) appendResult(-1);
                    else Queue.back(arr);
            }
        }

        System.out.println(sb.toString());
    }
}
