package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2447_별찍기10 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        arr = new char[N][N];


        recur(0,0,N,false);


        for(int i =0 ; i<N; i++){
            bw.write(arr[i]);
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

    static void recur(int i, int j, int N, boolean isBlank){

        if(isBlank){ // 공백 채우기
            for(int x = i; x<i+N;x++){
                for(int y = j; y<j+N;y++){
                    arr[x][y] = ' ';
                }
            }
            return;
        }

        if(N==1){
            arr[i][j] = '*';
            return;
        }

        int size = N/3;
        int count = 0;
        for(int x = i ;x<i+N;x+=size){
            for(int y = j; y<j+N;y+=size) {
                count++;
                if (count == 5) recur(x, y, size, true);
                else  recur(x, y, size, false);
            }
        }

    }

}