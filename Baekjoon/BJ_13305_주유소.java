package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine());
        long[] distance = new long[N-1];
        long cost = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N-1;i++){
            distance[i] = Long.parseLong(st.nextToken());
        }// 거리 입력

        st = new StringTokenizer(bf.readLine());
        long tmp = Long.parseLong(st.nextToken());
        cost += tmp * distance[0];
        for(int i = 1;i<N-1;i++){
            tmp = Math.min(Long.parseLong(st.nextToken()),tmp);
            cost += distance[i]*tmp;
        }// 기름 가격, 저장과 동시에 이전 기름 값과 비교해 더 최소 비용 저장

        System.out.println(cost);
    }
}
