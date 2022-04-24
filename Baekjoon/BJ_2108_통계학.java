package Baekjoon;
/*
float은 부정확하다 double을 쓰자
모든 값을 고려한 것인지 확인하자
다양한 테스트케이스를 확인하자

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2108_통계학 {


    static final int MAX= 4000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        int[] count = new int[MAX+1];
        int [] countMinus = new int[MAX+1];

        int maxCnt=0;
        int sum = 0;
        for(int i =  0 ; i <N;i++){
            arr.add(Integer.parseInt(br.readLine()));
            if(arr.get(i)<0){
                countMinus[Math.abs(arr.get(i))] += 1;
                maxCnt = Math.max(maxCnt, countMinus[Math.abs(arr.get(i))]);
            }else{
                count[arr.get(i)] += 1;
                maxCnt = Math.max(maxCnt, count[arr.get(i)]);
            }
            sum += arr.get(i);

        }

        Collections.sort(arr);

        int mode=0, modeCnt=0;
        for(int i = MAX; i>=1;i--){
            if(countMinus[i] == maxCnt){
                mode = i*(-1);
                modeCnt++;
                if(modeCnt == 2) break;
            }
        }
        if(modeCnt == 1){
            for(int i = 0; i<=MAX;i++) {
                if (count[i] == maxCnt) {
                    mode = i;
                    modeCnt++;
                    if (modeCnt == 2) break;
                }
            }
        }else if(modeCnt == 0){
            for(int i = 0; i<=MAX;i++) {
                if (count[i] == maxCnt) {
                    mode = i;
                    modeCnt++;
                    if (modeCnt == 2) break;
                }
            }
        }

        System.out.println((int)Math.round((double)sum/N));
        System.out.println(arr.get(N/2));
        System.out.println(mode);
        System.out.println(arr.get(N-1) - arr.get(0));
    }
}
