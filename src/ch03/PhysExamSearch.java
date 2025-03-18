package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static record PhyscData(
            String name,
            int height,
            double vision
    ){
        //키의 오름차순으로 정렬하기 위한 compator
        private static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Integer.compare(o1.height, o2.height);
            }


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] data = {
                new PhyscData("강민하",162,0.3),
                new PhyscData("이수현",168, 0.4),
                new PhyscData("황지안", 169,0.8),
                new PhyscData("유서범",171,1.5),
        };
        System.out.println("키가 몇 cm인 사람을 찾고 있나요? : ");
        int height = sc.nextInt();
        int idx = Arrays.binarySearch(data,new PhyscData("",height,0.0), PhyscData.HEIGHT_ORDER);

        if( idx < 0) System.out.println("그 값의 요소가 없습니다.");
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + data[idx]);
        }
    }
}
