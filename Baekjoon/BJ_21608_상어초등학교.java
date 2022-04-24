package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {

    static class Pos {
        int like, empty, r, c;

        public Pos(int like, int empty, int r, int c) {
            this.like = like;
            this.empty = empty;
            this.r = r;
            this.c = c;
        }
    }

    static class Student{
        int n;
        int[] likes;

        public Student(int n, int[] likes) {
            this.n = n;
            this.likes = likes;
        }
    }

    static int N, ans;
    static Student[][] arr;
    static ArrayList<Student> students;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static Pos opt;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());
        arr = new Student[N][N];
        students = new ArrayList<>();
        ans = 0;

        for(int i=0;i<N*N;i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int l3 = Integer.parseInt(st.nextToken());
            int l4 = Integer.parseInt(st.nextToken());
            students.add(new Student(s, new int[]{l1, l2, l3, l4}));
        } // input

        // 제일 처음 학생 배치
        arr[1][1] = students.get(0);

        //학생들 순서대로 배치
        for(int i = 1; i<N*N;i++){
            Student now = students.get(i);

            getInfo(now); // 현재 학생이 들어갈 수 있는 위치 구하기

            arr[opt.r][opt.c] = now; // 학생 배치

        }

        getScore(); // 만족도 계산
        System.out.println(ans);

    }
    static void getInfo(Student student){
        opt =  new Pos(-1,-1,-1,-1);
        for(int i = 0; i <N;i++){
            for(int j = 0;j<N;j++){
                if(arr[i][j] != null) continue; // 학생이 있는 칸이면 pass
                int likeCnt=0;
                int emptyCnt=0;
                for(int d = 0 ;d<4;d++){
                    int mr = i + dr[d];
                    int mc = j + dc[d];
                    if(mr < 0 || mr >=N||mc<0||mc>=N) continue;
                    if(arr[mr][mc] == null) emptyCnt++; // 비어있는 인접칸
                    else if(contain(student.likes,arr[mr][mc].n)) likeCnt++; // 좋아하는 학생이 있는 인접칸
                }

                // 최적위치 업데이트
                if(opt.like < likeCnt){
                    opt = new Pos(likeCnt,emptyCnt,i,j);
                }else if(opt.like == likeCnt){
                    if( opt.empty < emptyCnt){
                        opt = new Pos(likeCnt,emptyCnt,i,j);
                    }
                }
            }
        }
    }

    static void getScore(){
        for(int i = 0; i <N;i++){
            for(int j = 0;j<N;j++){
                int likeCnt=0;
                for(int d = 0 ;d<4;d++){
                    int mr = i + dr[d];
                    int mc = j + dc[d];
                    if(mr < 0 || mr >=N||mc<0||mc>=N) continue;
                    if(contain(arr[i][j].likes, arr[mr][mc].n)) likeCnt++;
                }
                if(likeCnt==1) ans += 1;
                else if(likeCnt==2) ans+=10;
                else if(likeCnt==3) ans+=100;
                else if(likeCnt==4) ans+=1000;
            }
        }
    }

    static boolean contain(int[] like, int num){
        for(int i = 0; i< 4;i++){
            if(like[i] == num) return true;
        }
        return false;
    }

}
