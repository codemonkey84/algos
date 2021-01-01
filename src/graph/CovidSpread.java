package graph;


import java.io.*;
import java.util.*;

/**
 * Implemented BFS traversal to find if all vertexes are reachable in a
 * undirected and un-weighted graph
 *
 * @author amishra
 *
 */
public class CovidSpread{
    public int helpaterp(int[][] hospital) {
       // code here
       Queue<Node> queue = new LinkedList<>();
       int unitTimeRequired = 0;
       Node delim = new Node(-1, -1);
       int R = hospital.length;
       int C = hospital[0].length;
       
       // Check initially how many node is impacted
       for (int i = 0; i < R; i++) {
           for (int j = 0; j < C; j++) {
               if (hospital[i][j] == 2) {
                   Node node = new Node(i, j);
                   queue.add(node);
               }
           }
       }
       
      
       // If there are nodes which are impacted initially,
       // add a delimeter at the end
       
       if (!queue.isEmpty())
           queue.add(delim);
       
       while (!queue.isEmpty()) {
           boolean isImpactedOnce = false;
           while (queue.peek().x != -1 && queue.peek().y != -1) {
               Node node = queue.poll();
               
               // Check if upper adjacent node is impacted
               if (node.x - 1 >= 0 && hospital[node.x - 1][node.y] == 1) {
                   hospital[node.x - 1][node.y] = 2;
                   queue.add(new Node(node.x - 1, node.y));
                   if (!isImpactedOnce) {
                       isImpactedOnce = true;
                       unitTimeRequired++;
                   }
               }
               
               // Check if lower adjacent node is impacted
               if (node.x + 1 < R && hospital[node.x + 1][node.y] == 1) {
                   hospital[node.x + 1][node.y] = 2;
                   queue.add(new Node(node.x + 1, node.y));
                   if (!isImpactedOnce) {
                       isImpactedOnce = true;
                       unitTimeRequired++;
                   }
               }
               
               // Check if left adjacent node is impacted
               if (node.y - 1 >= 0 && hospital[node.x][node.y - 1] == 1) {
                   hospital[node.x][node.y - 1] = 2;
                   queue.add(new Node(node.x, node.y - 1));
                   if (!isImpactedOnce) {
                       isImpactedOnce = true;
                       unitTimeRequired++;
                   }
               }
               
               // Check if right adjacent node is impacted
               if (node.y + 1 < C && hospital[node.x][node.y + 1] == 1) {
                   hospital[node.x][node.y + 1] = 2;
                   queue.add(new Node(node.x, node.y + 1));
                   if (!isImpactedOnce) {
                       isImpactedOnce = true;
                       unitTimeRequired++;
                   }
               }
           }
           
           // Renove the delimeter
           queue.poll();
           
           // Add the delimeter back if any node is impacted during current iteration
           if (!queue.isEmpty())
               queue.add(delim);
       }
       
       // Chceck if any node is still not impacted
       for (int i = 0; i < R; i++) {
           for (int j = 0; j < C; j++) {
               if (hospital[i][j] == 1) {
                   unitTimeRequired = -1;
                   break;
               }
           }
       }
       return unitTimeRequired;
   }
   
   static class Node {
       int x;
       int y;
       
       Node (int x, int y) {
           this.x = x;
           this.y = y;
       }
   }
}

class GFG1
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            CovidSpread ob = new CovidSpread();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

