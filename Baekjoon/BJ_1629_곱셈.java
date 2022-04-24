package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈 {
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long ans= divPow(A,B);

        System.out.println(ans);

    }
    static long divPow(long a, long b){
        if(b==1) return a%C;
        long temp = divPow(a,b/2);      // 두번 써야하므로 변수에 저장하면 시간 더 줄일 수 있음
        if(b % 2==0){
            return (temp * temp) % C;       //
        }else{
            return ((temp * temp) % C * a%C)%C; // == (temp * temp) % C * a%C
        }
    }
}