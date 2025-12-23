package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthClosestPointFromOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] p : points){
            int x = p[0];
            int y = p[1];
            int dist = x*x + y*y;
            pq.add(new Triplet(dist,x,y));
            if(pq.size()>k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i<k; i++){
            Triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }
        return ans;
    }

}
