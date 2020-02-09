package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acm11437 {
    static int N, M;
    static int[] dep;
    static int[] parTree;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dep = new int[N+1];
        parTree = new int[N+1];
        visited = new boolean[N+1];
        table = new ArrayList<>();

        for(int i=0; i<=N+1; i++)
            table.add(new ArrayList<>());

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table.get(a).add(b);
            table.get(b).add(a);
        }
        makeTree(1, 1);

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
        int diff = dep[a] - dep[b];

        if(diff < 0){
            while(diff != 0){
                b = parTree[b];
                diff++;
            }
        } else if(diff>0){
            while(diff != 0){
                a = parTree[a];
                diff--;
            }
        }

        while(a != b){
            a = parTree[a];
            b = parTree[b];
        }

        return a;
    }

    private static void makeTree(int node, int depth) {
        if(visited[node])
            return;

        dep[node] = depth;
        visited[node] = true;

        for(int i=0; i<table.get(node).size(); i++){
            if(parTree[table.get(node).get(i)] == 0)
                parTree[table.get(node).get(i)] = node;
            if(visited[table.get(node).get(i)] == false)
                makeTree(table.get(node).get(i), depth + 1);
        }
    }
}
