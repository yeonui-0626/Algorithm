package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {

    static final int MOD = 1234567891;
    static long[] factoList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());
        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(bf.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            if(R==0 || N==R){
                System.out.println("#"+t+" "+1);
                continue;
            }

            factoList = new long[N+1];

            // n! ((n-r)!r!)^(p-2) (mod p)
            factorial(N);
            long a = factoList[N];
            long b = factoList[N-R]%MOD * factoList[R]%MOD;

            long ans =a%MOD*divCon(b,MOD-2)%MOD;
            System.out.println("#"+t+" "+ans);
        }
    }
    static void factorial(int n){
        factoList[1] = 1;
        for(int i = 2; i<=n;i++){
            factoList[i] = (factoList[i-1] * i)%MOD;
        }
    }
    static long divCon(long a, long b){
        if(b==1) return a%MOD;
        long temp = divCon(a,b/2);
        if(b % 2==0){
            return (temp * temp) % MOD;
        }else{
            return (temp * temp) % MOD * a%MOD; // == (temp * temp) % C * a%C
        }
    }
}
