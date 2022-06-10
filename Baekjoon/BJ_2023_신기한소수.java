package Baekjoon;

import java.util.Scanner;
/*

소수를 판별할때 처음에는 에라토스테네스의 채를 이용하여 풀었는데
메모리 초과가 났다.
8자리 같은 경우 숫자가가 약 9천만개 이므로 메모리 초과가 난다.
그래서 숫자가 생성될 때마다 소수인지 판별하는 코드로 작성했지만 역시나 메모리 초과가 났다.

소수를 판별하는 횟수를 줄이는 것이 포인트였다. (-> 가지치기)
짝수가 뒤에 붙는다면 소수가 될 수 없기 때문에 짝수로 숫자를 만들어주는 경우를 빼면
소수를 판별하는 횟수가 줄어들어 메모리를 훨씬 줄일 수 있었다.
(단, 제일 처음 숫자로 2가 올 수 있다.)


 */
public class BJ_2023_신기한소수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        makePrim(N, 0, 0);

    }
    static void makePrim(int N, int cnt , int num){
        if(cnt == N){
            System.out.println(num);
            return;
        }
        for(int i = 1; i<=9;i++){
            if(i !=2 && i%2 ==0) continue;
            int tmp = num * 10 + i;
            if(checkPrim(tmp)) {
                makePrim(N,cnt+1, tmp);
            }
        }
    }
    static boolean checkPrim(int num){
        if(num == 1 ) return false;
        for(int i = 2;i<num;i++){
            if(num % i == 0 ) return false;
        }
        return true;
    }
}
