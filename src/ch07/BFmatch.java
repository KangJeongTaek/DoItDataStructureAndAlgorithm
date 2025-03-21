package ch07;

public class BFmatch {

    static int bfMatch(String txt, String pat){
        int pt = 0; //txt 커서
        int pp = 0; //pat 커서

        while (pt < txt.length() && pp < pat.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if(pp == pat.length()){
            return pt - pp;
        }
        return -1;
    }
}
