package Prgms;

public class Lv0_120956 {

    public static void main(String[] args) {
        String[] babbling = { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" };
        System.out.println(solution(babbling));

    }

    static int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            String result = s
                    .replace("aya", "1")
                    .replace("ye", "1")
                    .replace("woo", "1")
                    .replace("ma", "1");
            result = result.replaceAll("1", "");

            if (result.length() == 0) answer++;
        }

        return answer;
    }
}