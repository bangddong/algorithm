package Sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium))); // 첫번째 인자부터 두번째 인자까지 배열 생성
        rightArr = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size()))); // 첫번째 인자부터 두번째 인자까지 배열 생성

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE 1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }
        // Case 2 : right 데이터 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }
        // Case 3 : left 데이터 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }
        // 병합된 List 반환
        return mergedList;
    }

    public static void main(String[] args) {
        MergeSort sObject = new MergeSort();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr1.add((int)(Math.random() * 100));
        }
        System.out.println(sObject.mergeSplitFunc(arr1));
    }
}
