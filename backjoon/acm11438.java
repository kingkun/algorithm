package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acm11438 {
    static int N, M;
    static int[] dep;
    static int[][] parTree;
    static ArrayList<ArrayList<Integer>> table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dep = new int[N+1];
        parTree = new int[N+1][20];
        table = new ArrayList<>();

        for(int i=0; i<=N; i++)
            table.add(new ArrayList<>());

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table.get(a).add(b);
            table.get(b).add(a);
        }
        dep[0] = -1;
        makeTree(1, 0);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }
    }

    private static int LCA(int a, int b) {
        if(dep[a] > dep[b]){
            int tmp = a; a = b; b = tmp;
        }

        for(int i = 17; i >= 0; i--){
            if (dep[a] <= dep[parTree[b][i]])
                b = parTree[b][i];
        }
        int lca = a;

        if(a != b){
            for(int i = 17; i >= 0; i--){
                if(parTree[a][i] != parTree[b][i]){
                    a = parTree[a][i];
                    b = parTree[b][i];
                }
                lca = parTree[a][i];
            }
        }
        return lca;
    }

    private static void makeTree(int node, int parent) {
        dep[node] = dep[parent] + 1;
        parTree[node][0] = parent;

        for(int i=1; i<=17; i++){
            int tmp = parTree[node][i-1];
            parTree[node][i] = parTree[tmp][i-1];
        }

        int len = table.get(node).size();
        for(int i=0; i<len; i++){
            int there = table.get(node).get(i);
            if(there != parent)
                makeTree(there, node);
        }
    }
}
