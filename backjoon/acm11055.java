package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class acm11055 {
    static int N, answ;
    static int[] a = new int[1001];
    static int[] d = new int[1001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        answ = a[0];

        for(int i=0; i<N; i++){
            d[i] = a[i];
            for(int j=0; j<i; j++){
                if(a[i] > a[j] && d[i] < d[j] + a[i]){
                    d[i] = d[j] + a[i];
                    answ = Math.max(answ, d[i]);
                }
            }
        }

        System.out.println(answ);

    }
}
