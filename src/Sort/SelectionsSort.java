package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionsSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int minIdx;
        for (int i = 0; i < dataList.size() - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(minIdx) > dataList.get(j)) {
                    minIdx = j;
                }
            }
            Collections.swap(dataList, i, minIdx);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        SelectionsSort sSort = new SelectionsSort();
        System.out.println(sSort.sort(testData));
    }
}
