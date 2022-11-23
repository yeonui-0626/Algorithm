package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1. 임의의 시작점으부터 시작
* 2. bfs로 탐색 인접 리스트 계속 탐색
* 3. 여행지 방문 표시 -> traveled
*
* 
* */
public class BJ_1976_여행가자 {

    
    
    static int N, M; // 도시수, 여행도시 수
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static
    ArrayList<Integer> travel  = new ArrayList<>();
    static boolean[] traveled;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        traveled = new boolean[N+1];

        for(int i = 0 ; i <= N; i++){
            adj.add( new ArrayList<>());
        }

        StringTokenizer st = null;
        for(int i=1 ; i <= N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= N; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    adj.get(i).add(j);
                }
            }
        } // 인접 리스트 만들기

        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(travel.contains(n)) continue;
            travel.add(n);
        } //여행 도시 저장, 중복 x

//        System.out.println(travel.toString());

        // 인접리스트 탐색
        bfs();
        boolean flag = true;
        for(int i =0 ; i<travel.size();i++){
            if(!traveled[travel.get(i)]) {
                flag = false;
                break;
            }
        }
//        System.out.println(Arrays.toString(traveled));
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(travel.get(0));
        boolean[] visit = new boolean[N+1];

        while(!q.isEmpty()){
//            System.out.println(q.toString());
            int current = q.poll();
            visit[current] = true;
            traveled[current] = true;

            for(int i = 0 ; i < adj.get(current).size(); i++){
                if(visit[adj.get(current).get(i)]) continue;
                visit[adj.get(current).get(i)] = true;
                q.add(adj.get(current).get(i));
            }

        }


    }

}
