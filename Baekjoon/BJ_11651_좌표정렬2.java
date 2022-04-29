package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11651_좌표정렬2 {

    static class Point implements Comparable<Point>{
        int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        public int compareTo(Point o){
            if(this.y == o.y) return this.x - o.x;
            return this.y - o.y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine());

        ArrayList<Point> points = new ArrayList<Point>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(points);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N;i++){
            sb.append(points.get(i).x).append(" ").append(points.get(i).y).append("\n");
        }

        System.out.println(sb.toString());

    }
}
