package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
인접행렬
부루트포스

8 4 2 1
1111 = 15
0011 3
0101 5
1001 9
1010 10
1100 12
 */

public class BJ_14889_스타트와링크 {

    static int N;
    static int[][] arr;
    static ArrayList<Integer> flags;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans=Integer.MAX_VALUE;
        flags = new ArrayList<>();

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ;j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input

        divTeam(0,0,0);
        calSum();

        System.out.println(ans);
    }

    static void divTeam(int flag, int cnt, int index){
        if(cnt == N/2){
            flags.add(flag);
        }

        for(int i = index; i<N; i++){
            if((flag & 1<<i)!=0) continue;
            divTeam(flag | 1 << i , cnt+1, i+1);
        }
    }

    static void calSum(){

        for(int f = 0 ;f<flags.size()/2;f++){

            int aSum = 0;
            int bSum = 0;

            int flag = flags.get(f);

            for(int i = 0 ; i<N;i++){
                if((flag & 1<<i) !=0 ){
                    for(int j = 0; j<N;j++){
                        if(i!=j && (flag & 1<<j) !=0){
                            aSum += arr[i][j];
                        }
                    }
                }else{
                    for(int j = 0; j<N;j++){
                        if(i!=j && (flag & 1<<j) ==0){
                            bSum += arr[i][j];
                        }
                    }
                }
            }
            ans = Math.min(ans, Math.abs(aSum-bSum));
        }


    }
}
