package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
진실을 아는 사람 => 진실만
러떤 사람이 어떤 파티에서 진실을 듣고 또 다른 파티에ㅓ 과정된 이야기를 들었을 때도 지민이는 거짓말댕이로

과장된 이야이를 할 수 있느 파티 의 개수


 */
public class BJ_1043_거짓말 {

    static int N, M ; // N : 사람의 수, M : 파티의 수
    static boolean[] truth; // 각 번호의 사람이 진실을 아는지
    static boolean[] lie; // 파티에서 거짓말을 했는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        truth = new boolean[N];
        lie = new boolean[M];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n;i++){
            truth[Integer.parseInt(st.nextToken())] = true;
        } // 진실을 아는 사람




    }


}
