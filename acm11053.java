import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class acm11053 {
    static int N, answ = 1;
    static int[] a = new int[1001];
    static int[] d = new int[1001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            d[i] = 1;
            for(int j=0; j<i; j++){
                if(a[i] > a[j] && d[i] < d[j] +1) {
                    d[i] = d[j] + 1;
                    answ = Math.max(d[i], answ);
                }
            }
        }

        System.out.println(answ);

    }
}
