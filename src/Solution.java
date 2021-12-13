import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        String[] recipes = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
        String[] orders = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8" };
        solution(n, recipes, orders);
    }

    static void solution(int n, String[] recipes, String[] orders) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : recipes) {
            map.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
        }
        int[] A = new int[n];
        // 주문시간 + 조리시간
        for (int i = 0; i < n; i++) {
            int OT = Integer.parseInt(orders[i].split(" ")[1]);
            int CT = map.get(orders[i].split(" ")[0]);
            for (int j = 0; j < n; j++) {
                if (A[j] == 0){
                    A[j] = CT + OT;
                    break;
                } else if (A[j] <= OT){
                    A[j] += CT;
                    break;
                }
            }
        }
        boolean flag = false;
        for (int i = n; i < orders.length; i++) {
            int orderTime = Integer.parseInt(orders[i].split(" ")[1]);
            int cookTime =map.get(orders[i].split(" ")[0]);
            if (i == orders.length - 1) flag = true;
            for (int j = 0; j < n; j++) {
                if (A[j] <= orderTime) {
                    if (A[j] == 0) A[j] += orderTime + cookTime;
                    else A[j] += cookTime;
                    if (flag) answer = A[j];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}