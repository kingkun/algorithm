package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class acm2014 {
    public static PriorityQueue<Long> q = new PriorityQueue<>();
    public static long[] arr;
    public static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            q.add(arr[i] = tmp);
        }

        long head = 0;
        for(int i = 0; i < N; i++) {
            head = q.poll();

            for (int j = 0; j < K; j++) {
                long value = head * arr[j];
                q.add(value);

                if (head % arr[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(head);
    }
}
