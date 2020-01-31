package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class acm2805 {
    static public int M, N;
    static public int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(bsch());
    }

    private static long bsch() {
        long low =0;
        long high = arr[arr.length-1];
        long answ = 0;

        while(low <= high){
            long mid = (low + high) / 2;
            long sumVal = 0;

            for(int i=0; i<N; i++){
                if(arr[i] - mid >= 0)
                    sumVal += (arr[i] - mid);
            }

            if(sumVal < M) {
                high = mid - 1;
            } else if(sumVal >= M){
                answ = Math.max(answ, mid);
                low = mid + 1;
            }
        }
        return answ;
    }
}
