package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
이렇게 까지 오래걸릴 문제는 아니였는데 ... 

문제점
1. 로직을 잘못 계획했다.
- 단어를 먼저 선택하고 그 단어에 나타나는 알바펫을 배워서 다른 단어들도 배울 수 있는지 확인 할 수 있는 방법으로 처음 로직을 세웠으나,
max 50 개로 들어오는 단어들을 k 알파벳 수만큼 채워넣는 부분에서 시간 초과가 났다.
- 다행히 두번째 시도에서 알파벳을 기준으로 완전탐색을 하는 로직을 세웠다. 알파벳은 총 26개 이고 이미 나와있는 알파벳을 5개 이므로
위의 방법과 N 이 29나 차이나게된다.
2. 그래도 시간초과 ,,, 도대체 왜 ,,, ?
- 완전탐색 구현을 잘해야한다. 알파벳은 중복되어 선택하지 않기 때문에 중복없는 조합으로 완전 탐색을 해야한다. -> 이 부분을 간과 했다는 점이 굉장히 아쉽니다.

다짐
-  시간 초과가 났다면?
    - 엣지 케이스 만들어서 확인하기
    - 문제 조건 다시 읽기, 입력 값의 범위
    - 완전탐색이라면 최대한 시간을 줄이는 방법(가지치기) 생각하기

 */

public class BJ_1062_가르침 {

    static int N,K, visit[], ans=0;
    static String[] words;
    static boolean[] state = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for(int i = 0; i<N;i++) {
            String input =bf.readLine();
            input = input.replace("anta","");
            input = input.replace("tica","");
            words[i] = input;

        }
        if(K==26){
            System.out.println(N);
        }
        else if(K<5){
            System.out.println(0);
        }else{



            state['a'-'a']= true;
            state['n'-'a']= true;
            state['t'-'a']= true;
            state['i'-'a']= true;
            state['c'-'a']= true;

            find(0,0);
            System.out.println(ans);
        }
    }
    static void find(int cnt,int idx) {
        if (cnt == K - 5) {
            int tot = 0;
            for (int i = 0; i < N; i++) { // 단어마다 배운 알파벳으로 구성되어 있는지 확인
                boolean able = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if ( !state[words[i].charAt(j)-'a']) { // 단어에는 있는데 배우지 않은 단어일 경우
                        able = false;
                        break;
                    }
                }
                if(able) tot++;
            }
            ans = Math.max(ans, tot);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (state[i]) continue;
            state[i] = true;
            find(cnt + 1,i+1);
            state[i] = false;
        }
    }
}

