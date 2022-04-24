package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5656_벽돌깨기 {

    static int H,W,N;
    static int total,min;

    static class Brick{
        int x,y,r;

        public Brick(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken()); // 떨어뜨릴 벽돌 수
            W = Integer.parseInt(st.nextToken()); // W X H 배열
            H = Integer.parseInt(st.nextToken());

            int[][] arr = new int[H][W];
            min = Integer.MAX_VALUE;

            for(int i =0 ; i< H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }// input


            selectBrick(0,arr);
            System.out.println("#"+t+" "+min);
        }
    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; // 우 상 좌 하

    //벽돌의 선택 => 중복 순열
    static boolean selectBrick(int cnt,int[][] arr){

        int remain = countRemain(arr);

        if(remain == 0){
            min = 0;
            return true; // 벽돌이 모두 깨진 경우
        }

        if(cnt == N) {
            min = Math.min(remain,min);
            return false ; // N번 모두 던질 경우
        }


        int[][] newArr = new int[H][W];
        for(int c = 0; c < W; c++) {
            Brick fBrick = findBrick(c, arr);

            if (fBrick == null) continue;

            copy(arr, newArr);

            breakBrick(fBrick, newArr);

            sortBrick(newArr);


            if (selectBrick(cnt + 1, newArr)) {
                return true;
            }
        }
        return false;
    }
    
    static Brick findBrick(int c, int[][]arr){
        for(int r = 0 ; r <H; r++){
            if(arr[r][c] > 0){
                return new Brick(r,c,arr[r][c]);
            }
        }
        return null;
    }
    static void breakBrick(Brick brick, int[][] arr){

        Queue<Brick> queue = new LinkedList<>();
        queue.offer(brick);
        arr[brick.x][brick.y] = 0;

        while(!queue.isEmpty()){
            Brick cBrick = queue.poll();

            for(int d = 0 ;d <4;d++){
                int mr = cBrick.x;
                int mc = cBrick.y ;
                for(int r = 1; r < cBrick.r; r++) {
                    mr += dx[d];
                    mc += dy[d];
                    if (!isAvailable(mr, mc) || arr[mr][mc] == 0) continue;
                    if (arr[mr][mc] > 1) {
                        queue.offer(new Brick(mr, mc, arr[mr][mc]));
                    }
                    arr[mr][mc] = 0;
                }
            }
        }
    }

    static void sortBrick(int[][] arr) {

        for (int c = 0; c < W; c++) { // 한 col씩 본다.
            List<Integer> list = new ArrayList<>();
            for (int r = H - 1; r >= 0; r--) { // 벽돌이 있는지 밑에서부터 확인한다.
                if (arr[r][c] > 0) {
                    list.add(arr[r][c]);
                    arr[r][c] = 0; // 그 자리는 0으로 만들어 준다.
                }
            }
            int r = H - 1;
            for (int i = 0; i < list.size(); i++) {
                arr[r--][c] = list.get(i);
            }
        }
    }

    static int countRemain(int[][] arr){
        int cnt =0 ;
        for(int i = 0 ; i< H;i++){
            for(int j = 0 ;j<W; j++){
                if(arr[i][j]>0) cnt++;
            }
        }
        return cnt;
    }

    static void copy(int[][] map, int[][] newMap){
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }
    static boolean isAvailable(int r, int c){
        if(r < 0 || r>=H || c< 0|| c>=W) return false;
        return true;
    }
    static void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
