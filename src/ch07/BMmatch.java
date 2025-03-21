package ch07;

public class BMmatch {

    static int bmMatch(String txt, String pat){
        int pt; // txt 커서
        int pp ; // pat 커서
        int txtLen = txt.length(); // txt 문자 갯수
        int patLen = pat.length(); // pat 문자 갯수
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표

        // 건너뛰기 표 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++){
            skip[pt] = patLen;
        }

        for(pt = 0; pt < patLen - 1; pt++){
            skip[pat.charAt(pt)] = patLen -pt - 1; // pt == patLen - 1
        }

        // 검색
        while(pt < txtLen){
            pp = patLen -1 ; //pat의 마지막 문자에 주목

            while(txt.charAt(pt) == pat.charAt(pp)){
                if(pp == 0)
                    return pt;
                pp--;
                pt--;
            }
            pt += Math.max(skip[txt.charAt(pt)], patLen - pp);
        }
        return -1;
    }
}
