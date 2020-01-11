package backjoon;

import java.util.*;

public class acm7569 {
    static int M, N, H, answ = 0;
    static int[][][] map = new int[101][101][101];
    static int[] cy = {1, 0, -1, 0, 0, 0};
    static int[] cx = {0, 1, 0, -1, 0, 0};
    static int[] cz = {0, 0, 0, 0, 1, -1};
    static Queue<Node> q = new LinkedList<>();

    public static class Node{
        int y, x, z, day;
        public Node(int _y, int _x, int _z, int _day){
            this.y = _y; this.x = _x; this.z = _z; this.day = _day;
        }
    }
    private static boolean isAll() {
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(map[n][m][h] == 0)
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean isWrong(int y, int x, int z) {
        if(y<0 || y>=N || x<0 || x>=M || z<0 || z>=H || map[y][x][z] != 0){
            return true;
        }
        return false;
    }

    private static void BFS() {

        while(!q.isEmpty()){
            Node node = q.peek();
            q.remove();

            for(int i=0; i<6; i++){
                int ny = node.y + cy[i];
                int nx = node.x + cx[i];
                int nz = node.z + cz[i];
                int nday = node.day;

                if(isWrong(ny, nx, nz))
                    continue;

                map[ny][nx][nz] = 1;
                answ = nday;
                q.add(new Node(ny, nx, nz, nday + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        //Insert Map, queue
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    map[n][m][h] = sc.nextInt();
                    if(map[n][m][h] == 1)
                        q.add(new Node(n,m,h,1));
                }
            }
        }

        //BFS
        BFS();

        if(isAll())
            System.out.println(answ);
        else
            System.out.println(-1);
    }

}

