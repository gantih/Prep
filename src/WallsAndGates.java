import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int m,n = 0;
    Queue<Coordinate> q;
    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        n = rooms[0].length;
        q = new LinkedList<Coordinate>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new Coordinate(i,j));
                }
            }
        }
        while(q.peek() != null) {
            Coordinate c = q.remove();
            int c_xl = c.x;
            int c_xr = c.x;
            int c_xt = c.x-1;
            int c_xb = c.x+1;
            int c_yl = c.y-1;
            int c_yr = c.y+1;
            int c_yt = c.y;
            int c_yb = c.y;
            findShortestPath(rooms,c_xl,c_yl,rooms[c.x][c.y]);
            findShortestPath(rooms,c_xr,c_yr,rooms[c.x][c.y]);
            findShortestPath(rooms,c_xt,c_yt,rooms[c.x][c.y]);
            findShortestPath(rooms,c_xb,c_yb,rooms[c.x][c.y]);

        }
    }
    public void findShortestPath(int[][]rooms, int i, int j, int val){
        if(0<=i &&i<m && 0<=j && j<n && rooms[i][j] == Integer.MAX_VALUE){
            rooms[i][j] = Math.min(rooms[i][j], val+1);
            q.add(new Coordinate(i,j));
        }

    }
}

public class WallsAndGates {

   public static void main(String[] args) {
       Solution sol = new Solution();
       int[][]rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
       sol.wallsAndGates(rooms);
       System.out.println("HIMAJAAA");
   }
}
