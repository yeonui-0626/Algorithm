package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12095_스도쿠 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int r =0 ; r< 9;r++){
            st = new StringTokenizer(bf.readLine()," ");
            for(int c = 0; c<9;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }// input


        sudoku(0,0);


        StringBuilder sb = new StringBuilder();
        for(int r = 0; r< 9;r++){
            for(int c = 0; c<9;c++){
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean sudoku(int r, int c){

        int remain = emptyCount(r); // 0이 있는지 확인
        //지금 row에 0없으면
        if(remain==0) {
            if (r == 8) {// 마지막 줄이면 탐색 완전히 종료
                return true;
            }
            if(sudoku(r + 1, 0)){
                // 한줄 완성되면 다음 줄로
                return true;
            }else{
                return false;
            }
        }
        // 마지막 col 까지 봤는데 아직 0이 남음.
        if(c==9){
            return false;
        }

        if(map[r][c] == 0 ){ // 빈칸
            for(int n = 1; n<=9;n++){
                // 넣을 수 있는지 확인
                if(rowCheck(r,n) && colCheck(c,n) && boxCheck(r,c,n)){
                    map[r][c] = n;
                    if(sudoku(r,c+1)){
                        return true;
                    }
                    map[r][c] = 0; // 다시 채우기 위해 0으로 set
                }
            }
        }
        else{
            if(sudoku(r,c+1)){
                return true;
            }
        }
        return false;
    }

    static int emptyCount(int r){
        int cnt = 0;
        for(int c = 0; c<9;c++){
            if(map[r][c]==0) cnt++;
        }
        return cnt;
    }
    static boolean rowCheck(int r, int n){
        for(int c=0; c<9; c++){
            if(map[r][c] == n) return false;
        }
        return true;
    }
    static boolean colCheck(int c, int n){
        for(int r=0; r<9; r++){
            if(map[r][c] == n) return false;
        }
        return true;
    }
    static boolean boxCheck(int r, int c , int n){
        if(r<3){
            if(c<3){
                for(int i = 0 ; i< 3;i++){
                    for(int j =0;j<3;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else if(c<6){
                for(int i = 0 ; i< 3;i++){
                    for(int j =3;j<6;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else{
                for(int i = 0 ; i< 3;i++){
                    for(int j =6;j<9;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }
        }else if(r<6){
            if(c<3){
                for(int i = 3 ; i< 6;i++){
                    for(int j =0;j<3;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else if(c<6){
                for(int i = 3 ; i< 6;i++){
                    for(int j =3;j<6;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else{
                for(int i = 3 ; i< 6;i++){
                    for(int j =6;j<9;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }
        }else{
            if(c<3){
                for(int i = 6 ; i< 9;i++){
                    for(int j =0;j<3;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else if(c<6){
                for(int i = 6 ; i< 9;i++){
                    for(int j =3;j<6;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }else{
                for(int i = 6 ; i< 9;i++){
                    for(int j =6;j<9;j++){
                        if(map[i][j] == n) return false;
                    }
                }
            }
        }
        return true;
    }
}