import java.util.*;

public class Main {
    /**
     * 사람이 N만큼 주어짐
     * 각 사람이 주어질 때 인출에 걸리는 시간도 P가 주어짐
     * 주어진 N을 P의 작은순으로 정렬 후 합
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람 수
        ArrayList<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }

        Collections.sort(p);

        int chainSum = 0;
        int totSum = 0;
        for (int num : p) {
            chainSum += num;
            totSum += chainSum;
        }

        System.out.println(totSum);


    }
}
