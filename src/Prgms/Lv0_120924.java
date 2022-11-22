package Prgms;

public class Lv0_120924 {
    public static void main(String[] args) {
        int[] common = { 1, 2, 3, 4 };
        System.out.println(solution(common));
    }

    static int solution(int[] common) {
        int answer = 0;

        int num1 = common[1] - common[0];
        int num2 = common[2] - common[1];

        if (num1 == num2) answer = common[common.length - 1] + num1;
        else answer = common[common.length - 2] * 2 + common[common.length - 1];

        return answer;
    }
}
