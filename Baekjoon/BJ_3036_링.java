package Baekjoon;

/*

최대 공약수를 구하고
나눈 후, 분수로 나타내기
최대 공약수

최대 공약수 -> 유클리드 ?

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3036_링 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        for(int i =0;i<N-1;i++){
            int a = S;
            int b = Integer.parseInt(st.nextToken());

            int gcd = GDC(a,b);
            sb.append(a/gcd).append("/").append(b/gcd).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int GDC(int a, int b){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while(b > 0 ){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}
