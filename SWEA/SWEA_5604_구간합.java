package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {

    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());
        for(int t = 1; t<=T;t++){
            st = new StringTokenizer(bf.readLine()," ");

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            count = new long[10];

            long ans=0;

            long delta=1;
            while (A<=B){
                //시작 부분
                for (;A%10!=0 && A<=B;A++){ // A<=B: 이 for문을 도는 동안 A 가 B를 넘을 수도 있음
                    split(A,delta);
                }
                //끝부분
                for(;B%10!=9 && A<=B;B--){
                    split(B,delta);
                }
                if(A>B){
                    break;
                }

                // 중간 부분
                A/=10;
                B/=10;
                System.out.println("A : "+A+", B : "+B);
                long rowCnt = B-A+1;
                for(int i = 1; i<10;i++){
                    count[i] += rowCnt*delta;
                }
                delta *= 10;
            }

            for(int i = 1; i<10;i++){
                ans += count[i]*i;
            }
            System.out.println("#"+t+" "+ans);
        }
    }

    static void split(long n, long delta){
        while(n>0){
            count[(int)(n%10)] += delta;
            n/=10;
        }
    }
}
