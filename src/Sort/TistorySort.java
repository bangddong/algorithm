package Sort;

import java.io.IOException;
import java.util.Arrays;

public class TistorySort {
    public static void main(String[] args) throws IOException {
        //selectionSort(random());
        //bubbleSort(random());
        //insertionSort(random());
//        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        quickSort(A, 0, 7);
        quickSort(random(), 0, 7);
    }

    static int[] random() {
        int[] A = new int[8];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 100);
        }

        return A;
    }

    static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {

                if (A[minIdx] > A[j]) {
                    minIdx = j;
                }
            }
            int tmp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = tmp;
        }
        System.out.println(Arrays.toString(A));
    }

    static void bubbleSort(int[] A) {
        boolean chk = false; // 위치 변경여부 확인 boolean
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 1; j < A.length - i; j++) {
                if (A[j] < A[j - 1]) {
                    chk = true;
                    int tmp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = tmp;
                }
            }
            if (!chk) break; // 정렬이 일어나지 않았으니 완료되었다고 볼 수 있음.
        }
        System.out.println(Arrays.toString(A));
    }

    static void insertionSort(int[] A) {
        System.out.println(Arrays.toString(A));
        for (int i = 1; i < A.length; i++) {
            int tmp = A[i]; // 비정렬구간 선택 데이터
            int j = i - 1; // 선택 데이터 바로 좌측부터 왼쪽으로 비교를 시작한다.
            while(j >= 0 && A[j] > tmp) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = tmp;
        }
        System.out.println(Arrays.toString(A));
    }

    static void quickSort(int[] A, int L, int R) {
        System.out.println(Arrays.toString(A));
        if (L >= R) return;

        int pivot = quickSortPartition(A, L, R);
        quickSort(A, L, pivot - 1); // pivot 기준 왼쪽 배열 정렬
        quickSort(A, pivot + 1, R); // pivot 기준 오른쪽 배열 정렬
        System.out.println(Arrays.toString(A));
    }

    // 수행마다 피봇을 기준으로 쪼개진 배열을 정렬한다!
    static int quickSortPartition(int[] A, int L, int R) {
        int pivot = A[L]; // 제일 좌측값을 피봇으로 한다.
        int i = L, j = R;
        while (i < j) {
            while (pivot < A[j]) j--; // 피봇보다 작은 값을 찾을때까지 R을 이동한다.
            while (i < j && pivot >= A[i]) i++; // 피봇보다 큰 값을 찾을 때까지 L을 이동한다.
            if (i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        // 피봇을 기준으로 또 쪼개기 위해 피봇의 위치를 바꿔준다!
        A[L] = A[i];
        A[i] = pivot;

        return i;
    }

}
