package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t<=T; t++){
            st = new StringTokenizer(bf.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (int)(Math.pow(x1-x2,2)+ Math.pow(y1-y2,2));
            if( x1 == x2 && y1==y2 && r1==r2) { // 두 원이 일치하는 경우
                sb.append(-1);
            }else if(distance < Math.pow(r1-r2,2)){ // 한 원이 다른 원에 포함되지만 내적하지 않음
                sb.append(0);
            }else if(distance > Math.pow(r1+r2,2)){ // 두 원이 겹치지 않을 때
                sb.append(0);
            }else if(distance == Math.pow(r1-r2,2)){ // 내접할 경우
                sb.append(1);
            }else if(distance == Math.pow(r1+r2,2)) { // 외접할 경우
                sb.append(1);
            }else{
                sb.append(2);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
