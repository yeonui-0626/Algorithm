package Baekjoon;

import java.util.Scanner;

public class BJ_11729_하노이탑이동순서 {
    static StringBuilder sb = new StringBuilder();
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        hanoi(N,1,2,3);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }
    static void hanoi(int n, int from, int temp, int to){

        if(n==0) return;

        hanoi(n-1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;
        hanoi(n-1, temp, from, to);
    }
}
