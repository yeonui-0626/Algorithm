package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());
        for(int t = 0; t<T;t++){
            st = new StringTokenizer(bf.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


            if(A < B ){
                int temp = A;
                A = B;
                B = temp;
            }
            int a=A, b = B, c;
            while(b!=0){
                c=a%b;
                a=b;
                b=c;
            }

            // 이 때의 a 값이 최대공약수
            // 최소 공배수 : a * (A/a)*(B/a)
            System.out.println(a * (A/a)*(B/a));

        }


    }
}
