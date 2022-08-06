package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Deck {

        // 값을 배열의 앞에 넣는다
        public static int[] pushFront(int[] arr, int newNum) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = newNum;
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }

        // 값을 배열의 뒤에 넣는다
        public static int[] pushBack(int[] arr, int newNum) {
            int[] newArr = new int[arr.length + 1];
            newArr[newArr.length - 1] = newNum;
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            return newArr;
        }

        // 가장 앞의 값을 빼고 반환하며 그 값을 출력한다.
        // 만약 비어있다면 -1을 출력한다.
        public static int[] popFront(int[] arr) {
            if (arr.length == 0) {
                appendResultValue(-1);
                return arr;
            } else {
                int[] newArr = new int[arr.length - 1];
                appendResultValue(arr[0]);
                System.arraycopy(arr, 1, newArr, 0, newArr.length);
                return newArr;
            }
        }

        // 가장 뒤의 값을 빼고 반환하며 그 값을 출력한다.
        // 만약 비어있다면 -1을 출력한다.
        public static int[] popBack(int[] arr) {
            if (arr.length == 0) {
                appendResultValue(-1);
                return arr;
            } else {
                int[] newArr = new int[arr.length - 1];
                appendResultValue(arr[arr.length - 1]);
                System.arraycopy(arr, 0, newArr, 0, newArr.length);
                return newArr;
            }
        }

        // 덱에 들어있는 개수를 출력한다.
        public static void size(int[] arr) {
            appendResultValue(arr.length);
        }

        // 덱이 비어있으면 1, 아니면 0을 출력한다.
        public static void empty(int[] arr) {
            if (arr.length == 0) appendResultValue(1);
            else appendResultValue(0);
        }

        // 가장 앞의 값을 출력한다.
        // 만약 비어있다면 -1을 출력한다.
        public static void front(int[] arr) {
            if (arr.length == 0) appendResultValue(-1);
            else appendResultValue(arr[0]);
        }

        // 가장 뒤 값을 출력한다.
        // 만약 비어있다면 -1을 출력한다.
        public static void back(int[] arr) {
            if (arr.length == 0) appendResultValue(-1);
            else appendResultValue(arr[arr.length - 1]);
        }

    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[0];

        while(n --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    arr = Deck.pushFront(arr, Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    arr = Deck.pushBack(arr, Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    arr = Deck.popFront(arr);
                    break;
                case "pop_back":
                    arr = Deck.popBack(arr);
                    break;
                case "size":
                    Deck.size(arr);
                    break;
                case "empty":
                    Deck.empty(arr);
                    break;
                case "front":
                    Deck.front(arr);
                    break;
                default: Deck.back(arr);
            }
        }

        System.out.println(sb.toString());
    }

    public static void appendResultValue(int num) {
        sb.append(num).append("\n");
    }
}
