package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
틀렸습니다.
 */
public class BJ_4195_친구네트워크 {

    static int parents[] = new int[200001];
    static int sizes[] = new int[200001];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            HashMap<String ,Integer> map = new HashMap<>();
            int valueNum = 1;
            int F = Integer.parseInt(br.readLine());

            init();

            for(int i = 0 ; i < F; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)) map.put(a,valueNum++);
                if(!map.containsKey(b)) map.put(b,valueNum++);

                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    static void init(){
        for(int i = 1 ; i <=200000;i++){
            parents[i] = i;
            sizes[i] = 1;
        }
    }
    static int find(int x){
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    static int union(int a, int b){
        int aR = find(a);
        int bR = find(b);

        if (aR!=bR){
            sizes[aR] += sizes[bR];
            sizes[bR] = sizes[aR];
            parents[bR] = aR;
        }

        return sizes[aR];
    }
}
