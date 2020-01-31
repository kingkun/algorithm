package backjoon;

import java.util.*;

public class acm2805 {
    static public int M, N;
    static public int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
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
