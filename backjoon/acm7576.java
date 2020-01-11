package backjoon;

import java.util.*;

public class acm7576 {
    static int N, M, answ = 0;
    static int[][] map = new int[1001][1001];
    static int[] cx = {-1,1,0,0};
    static int[] cy = {0,0,-1,1};
    static Queue<Node> q = new LinkedList<Node>();

    static class Node{
        int y, x, day;
        public Node(int _y, int _x, int _day){
            this.y = _y; this.x = _x; this.day = _day;
        }
    }

    private static boolean isWrong(int y, int x){
        if(y>=N || y<0 || x>=M || x<0 || map[y][x] != 0)
            return true;
        return false;

    }

    private static int printAnsw(){
        for(int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                if(map[i][j] == 0)
                    return -1;
            }
        }
        return answ;
    }


    private static void bfs() {
        while(!q.isEmpty()){
            Node node = q.peek();
            q.remove();
            for(int i=0; i<4; i++){
                int ny = node.y + cy[i];
                int nx = node.x + cx[i];
                int nday = node.day + 1;

                if (isWrong(ny, nx))
                    continue;

                map[ny][nx] = 1;
                answ = nday;
                q.add(new Node(ny, nx, nday));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1)
                    q.add(new Node(i,j,0));
            }
        }

        bfs();
        System.out.println(printAnsw());
    }
}
