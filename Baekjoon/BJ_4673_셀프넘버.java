package Baekjoon;

import java.util.Arrays;

public class BJ_4673_셀프넘버 {

    static final int MAX = 10000;
    static boolean[] isSelf;

    public static void main(String[] args) {
        isSelf = new boolean[MAX+1];
        Arrays.fill(isSelf, true);
        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<=MAX;i++){
            if(isSelf[i]){
                selfNum(i);
            }
        }
        for(int i = 1; i<=MAX;i++){
            if(isSelf[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void selfNum(int n){

        int sum = n;
        while(n>0){
            sum+= n%10;
            n/=10;
        }
        if(sum>MAX) return;
        isSelf[sum] = false;
        selfNum(sum);
    }

}
