package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {

    static int N, min;
    static int[][] adj;
    static int[] population;
    static boolean[]  selected;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        adj = new int[N+1][N+1];
        population =  new int[N+1];
        selected = new boolean[N+1];

        min=9999;
        flag = false;

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<= N;i++){
            population[i]= Integer.parseInt(st.nextToken());
        } // 인구수 저장

        for(int i = 1 ;i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            for(int j = 1; j<=n;j++){
                adj[i][Integer.parseInt(st.nextToken())] = 1;
            }
        } // 인접 행렬 만들기

        divid(0,1);
        if(!flag) min = -1; // 가능한 방법을 찾지 못함
        System.out.println(min);

    }
    static void divid(int cnt, int idx ) { // idx : 현재 선거구 번호, A 선거구 갯수

        if (idx == N+1) {
            if(cnt == N || cnt == 0) return; // 한 선거구에 모두 들어감-> 불가능한 방법


            boolean[] visit = new boolean[N+1];
            bfs(true, visit); // 선거구 A 의 연결성 확인
            bfs(false,visit); // 선거구 A 의 연결성 확인

            for(int i = 1 ; i<=N; i++){
                if(!visit[i]) return;   // 방문되지 않은 구역이 있다면 선거구를 만들 수 없다.
            }

            // 인구수 합 구하기
            int sumA=0,sumB=0;
            for(int i = 1; i<=N;i++){
                if(selected[i]) sumA+=population[i];
                else  sumB += population[i];
            }

            min = Math.min(min, Math.abs(sumA-sumB));
            flag = true; // 가능한 방법이 있음을 표시
            return;
        }

        selected[idx] = true; // A 선거구에 넣기
        divid( cnt +1, idx+1);

        selected[idx] = false; // B 선거구에 넣기
        divid(cnt , idx+1);


    }

    static void bfs(boolean state,boolean visit[]){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<=N;i++){
            if(selected[i] == state ) {
                queue.offer(i);
                visit[i] = true;
                break;
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int n = 1; n <= N; n++) {
                // 아직 방문 안 했는지 && 연결되있는 지 && 같은 선거구 인지
                if (!visit[n] && adj[current][n] == 1 && selected[n] == state) {
                    visit[n] = true;
                    queue.offer(n);
                }
            }
        }
    }
}
