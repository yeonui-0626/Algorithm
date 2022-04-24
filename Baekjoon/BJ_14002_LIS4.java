package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_14002_LIS4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        boolean[] mark = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.fill(lis, 1);
        int max = 0, maxIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            max = Math.max(max, lis[i]);
        }

        sb.append(max).append('\n');


        for (int i = N-1; i >= 0; i--) {
            if (lis[i] == max) {
                mark[i]=true;
                max--;
            }
        }

        for(int i = 0 ; i<N;i++){
            if(mark[i]){
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
