package Baekjoon;

import java.util.Scanner;

public class BJ_1436_영화감독솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        long title = 666;
        while(N>0){
            if(check(title)){
                N--;
            }
            title++;
        }

        System.out.println(title-1);

    }

    static boolean check(long num){
        int cnt = 0;
        while(num > 0 ){
            if( (num % 10) == 6 ) {
                cnt++;
                if(cnt >=3) return true;
            }
            else cnt=0;
            num /= 10;
        }
        return false;
    }
}
