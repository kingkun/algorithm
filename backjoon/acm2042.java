package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class acm2042 {
    static long[] arr;
    static long[] tree;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());K = Integer.parseInt(st.nextToken());

        int h = (int)Math.ceil((Math.log10(N)/Math.log10(2)));
        int t_size = (1 << (h+1));

        arr = new long[N];
        tree = new long[t_size];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 0, N-1);

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());long b = Long.parseLong(st.nextToken());long c = Long.parseLong(st.nextToken());

            if(a == 1){
                long diff = c-arr[(int)(b-1)];
                arr[(int)(b-1)] = c;
                update(1,0,N-1,(int)(b-1), diff);
            } else if(a == 2) {
                System.out.println(sum(1,0,N-1,(int)(b-1),(int)(c-1)));
            }
        }
    }

    private static long init(int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        } else {
            return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1,(start+end)/2+1, end);
        }
    }

    private static void update(int node, int start, int end, int idx, long diff){
        if(idx < start || idx > end)
            return;
        tree[node] = tree[node] + diff;
        if(start != end){
            update(node*2, start, (start+end)/2, idx, diff);
            update(node*2+1, (start+end)/2+1, end, idx, diff);
        }
    }

    private static long sum(int node, int start, int end, int left, int right){
        if(left > end || right < start)
            return 0;
        if(left <= start && end <= right)
            return tree[node];
        return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
    }
}
