package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_4948_베르트랑공준 {

    static final int MAX = 123456*2;
    static boolean[] prime = new boolean[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(prime,true);
        prime[1] = false;
        for(int i = 2; i<=Math.sqrt(MAX);i++){
            if(isPrim(i)){
                int j=1;
                while(++j*i<=MAX) if(prime[i*j]) prime[i*j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        int n;
        while((n=Integer.parseInt(bf.readLine())) != 0){
            int cnt = 0;
            for(int i = n+1; i <= 2*n; i++) if(prime[i]) cnt++;
            sb.append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }
    static boolean isPrim(int n){
        int cnt = 0 ;
        for(int i = 1; i<n;i++){
            if(n%i==0) cnt++;
        }
        return cnt==1?true:false;
    }
}
