package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2581_소수 {
    static int MAX = 10001;
    static boolean[] prim;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M  = Integer.parseInt(bf.readLine());
        int N  = Integer.parseInt(bf.readLine());
        prim = new boolean[N+1];
        Arrays.fill(prim, true);
        prim[1] = false;
        for(int i = 2; i< Math.sqrt(N);i++){
            if(!isPrim(i))continue;
            for(int j = 2; i*j<=N; j++){
                if(!prim[i*j]) continue;
                prim[i*j] = false;
            }
        }
        int sum=0;
        int min=-1;
        for(int i = M; i<=N;i++){
            if(prim[i]){
                sum += i;
                if(min == -1) min = i;
            }
        }
        if(min == -1) System.out.println(min);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }

    static boolean isPrim(int n){
        int cnt = 0 ;
        for(int i = 1; i<n;i++){
            if(n%i==0) cnt++;
        }
        return cnt==1?true:false;
    }
}
