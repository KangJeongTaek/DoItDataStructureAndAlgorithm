package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//실습 3-8을 수정하여 시력을 내림차순으로 정렬한 신체검사 데이터에서 특성 시력을 가진 사력을 사람을 검색하는 프로그램을 작성하세요.
public class PracticeQ7 {

    static record PhyscData(
            String name,
            int height,
            double vision
    ){
        //시력의 내림차순으로 정리하기 위한 compator
        private static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Double.compare(o2.vision, o1.vision);
            }


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] data = {
                new PhyscData("강민하",162,1.5),
                new PhyscData("이수현",168, 0.8),
                new PhyscData("황지안", 169,0.5),
                new PhyscData("유서범",171,0.2),
        };
        System.out.println("시력이 몇인 사람을 찾고 있나요? : ");
        double vision = sc.nextDouble();
        int idx = Arrays.binarySearch(data,new PhyscData("",0,vision), PhyscData.VISION_ORDER);

        if( idx < 0) System.out.println("그 값의 요소가 없습니다.");
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + data[idx]);
        }
    }
}
