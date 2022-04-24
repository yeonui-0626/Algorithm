package Baekjoon;

import java.util.Scanner;

/*

메모이제이션

1로 만들기
1. x가 3으로 나누어 떨어지면 3으로 나눈다.
2. X가 2로 나누어 떨어지면 2로 나눈다.
3. 1을 뺀다.

숫자 1  2  3  4  5  6  7
횟수 0  1  1  2  3  2  3

숫자를 /3 하거나 /2 하거나 -1 한 숫자의 횟수 중 가장 작은 횟수를 선택하여 +1 한다.

 */
public class BJ_1463_1로만들기 {

    static final int MAX = 1000000;
    static int[] arr = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr[1] = 0;
        for(int i = 2; i<=N;i++){
            arr[i] = arr[i-1] + 1;
            if(i%2 == 0) arr[i] = Math.min(arr[i],arr[i/2]+1);
            if(i%3 == 0) arr[i] = Math.min(arr[i],arr[i/3]+1);
        }
        System.out.println(arr[N]);
    }
}
