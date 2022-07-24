package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20040_사이클게임 {

    static int N;
    static int parents[];

    static void init(){ // 자기 자신이 루트인 서로소 집합 생성
        parents = new int[N];
        for(int i = 0 ; i<N;i++){
            parents[i] = i;
        }
    }

    static int findSet(int x){ // x 가 속한 집합의 루트 return
        if( x == parents[x]) return x;
        else return parents[x] = findSet(parents[x]);
    }

    static boolean union(int x, int y){
        int xRoot = findSet(x);
        int yRoot = findSet(y);

        if( xRoot == yRoot ) return false;

        parents[yRoot] = xRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());
        init();

        for(int i = 0; i < turn; i++){
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!union(x,y)){ // 사이클 만들어짐
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }
}
