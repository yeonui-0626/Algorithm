package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {

    static int N,M,D;
    static int max=0, cnt;
    static int[][] map, init;
    static int[] select;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];
        init = new int[N][M];
        select = new int[3];
        cnt = 0;

        for(int i = 0; i < N;i++){
            st = new StringTokenizer(bf.readLine()," ");
            for(int j = 0 ; j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                init[i][j] = map[i][j];
            }
        }//input

        play(0,0);// 궁수 선택하기

        System.out.println(max);

    }

    static void play(int count, int idx){ // 궁수 선택하기
        if(idx >  M ) return;
        if(count==3){
            mapInit(); // map 원래 대로 초기화
            cnt=0;      // 죽일 수 있는 적 count 초기화
            while(remain()!=0){ // 적이 모두 없어질 때까지 반복
                shoot();        // 공격
                move();         // 적 아래로 이동
            }
            max = Math.max(max, cnt);
            return;
        }

        select[count] = idx;
        play(count+1,idx+1);
        select[count] = 0;
        play(count,idx+1);

    }

    static void shoot(){
        int nr=0, nc=0;
        boolean[][] kill = new boolean[N][M];
        for(int n = 0 ; n<3;n++){ // 각 궁수 공격
            nr = N;
            nc = select[n];

            boolean flag = false;// 적을 죽였다면 true;


            //1. 죽일 수 있는 가까운 적 부터 확인 거리가 1인 적 부터 D인 적까지 확인
            for(int d = 1; d<=D;d++) {
                //2. 왼쪽의 적을 먼저 죽어야하므로 col 0 부터 확인
                for (int c = 0; c < M; c++) {
                    //3. 거리가 d인 적을 확인하고 있다면 N-1번째 줄부터 궁수에서 d만큼 떨어진 row만 확인
                    for (int r = N - 1; r >= N - 1 - d; r--) {
                        if(r<0) continue; // 거리가 총 row 수 보다 클 경우 r이 음수가 될 수 있음
                        if ((Math.abs(nr - r) + Math.abs(nc - c)) != d) continue; //d거리 있는지 확인
                        if (map[r][c] == 0) continue; // 적이 있는지 확인
                        kill[r][c] = true; // 죽일 적 표시
                        flag = true;    // 한명 만 죽일 수 있으므로 한명 골랐으면  break;
                        break;
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
        }

        // 죽는 적 count
        for(int i =0 ; i<N;i++){
            for(int j = 0; j<M;j++){
                if(kill[i][j]){
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }

    }

    static void move(){ // 적들 아래로 1칸씩 이동
        for(int i = N-2; i>=0;i--){
            for(int j = 0 ; j<M;j++){
                map[i+1][j] = map[i][j];
            }
        }
        for(int j = 0 ; j<M;j++){
            map[0][j] = 0;
        }
    }
    static int remain(){    // 적이 몇명 남아있는지 확인
        int remain = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) remain++;
            }

        }
        return remain;
    }

    static void mapInit(){
        for(int i = 0; i<N;i++){
            for(int j= 0 ;j<M;j++){
                map[i][j] = init[i][j];
            }
        }
    }
}
