package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

음 이렇게 푸는게 맞는 지 모르겠지만 신박한 풀이법이 생각이 나지 않았다.
숫자끼리 연결하는 부분을 단순 구현으로 풀었다.
이 부분을 구현하는 과정에서 잔실수가 많았다.
- 인덱스 실수
- 2 3 4  의 값을 구할때 단순히 각 자리의 숫자만 더하기 등

그리고 아스키 코드로 정렬하라고 했는데 예제 출력에서 " ", + , -순서로 출력하는 것 같아서
탐색 순서를 위와 같은 순서로 했다.
=>순서 상관없이 탐색하고 나중에 아스키 코드 순서로 정렬을 했다면 ?

dfs 인자값에 더 많은 정보를 주어서 dfs만으로 깔끌하게 작성할 수 있지만
파싱하는 것도 문제 출제 이유 중 하나인 듯.

 */
public class BJ_7490_0만들기 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int t =0 ; t<T;t++){
            N = Integer.parseInt(bf.readLine());

            makeZero(2, 1+"", 1);
            sb.append('\n');

        }
        System.out.println(sb.toString());

    }

    static void makeZero(int current, String str, int result){

        if(current > N){
            if(result == 0){
                sb.append(str).append('\n');
            }
            return;
        }
        int oppIdx = findOppIdx(str);
        if(oppIdx>=0){
            int base = result;
            int tmp = findNum(str,oppIdx);
            if(str.charAt(oppIdx)=='-'){
                base += tmp;
                tmp *=-10;
                tmp -= current;
            }else{
                base -= tmp;
                tmp *=10;
                tmp += current;
            }
            makeZero(current+1, str + " "+current,  base+tmp);
        }else{
            makeZero(current+1, str + " "+current,  result*10+current);
        }

        //덧셈
        makeZero(current+1, str + "+"+current, result + current);
        //뺄셈
        makeZero(current+1, str + "-"+current,  result - current);

    }
    static int findOppIdx(String str){
        for(int i = str.length()-1;i>0;i--){
            if(str.charAt(i)=='-'){
                return i;
            }else if(str.charAt(i)=='+'){
                return i;
            }
        }
        return -1;
    }
    static int findNum(String str, int oppIdx){
        String sub = str.substring(oppIdx+1);
        int num = 0;
        for(int i = 0; i<sub.length();i++){
            if(i%2 == 0){
                num *= 10;
                num += (sub.charAt(i)-'0');
            }
        }
        return num;
    }
}
