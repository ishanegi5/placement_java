import java.util.*;
public class graphs_50 {
    static class Edge{
        int src;
        int des;
        int wgt;
        public Edge(int src,int des,int wgt){
            this.src=src;
            this.des=des;
            this.wgt=wgt;
        }

    }
    public static void createGraph(int v){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }

        //vertex: 0
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        //vertex: 1
        graph[1].add(new Edge(1,3,1));
        graph[1].add(new Edge(1,0,1));

        //vertex 2:
        graph[2].add(new Edge(2,4,1));
        graph[2].add(new Edge(2,0,1));

        //vertex: 3
        graph[3].add(new Edge(3,5,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,1,1));

        //vertex: 4
        graph[4].add(new Edge(4,5,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,2,1));

        //vertex 5:
        graph[5].add(new Edge(5,6,1));
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));

        //vertex 6:
        graph[6].add(new Edge(6,5,1));
    }
    public static void main(){
        /*
        Graphs: very important data structure 
        it is networks of node
        isme vertex(vertices pural) hoti h and edges hote h image leke google se bataungi


        Types of graph:
        1)unidirectional
        2)bidirectional or Unidirectional
        3)weighted graph
        4)unweighted graph
        Note: graph inke combo se milte h hume 1+3 ya 1+4 ya 2+3 ya 2+4 so
        baki weight yaha cost ho skti ya importance ho skti kisi vertex ki
        
        
        Storing a Graph:
            1.Adjacency List
            2.Adjacency Matrix
            3.Edge List
            4.2D Matrix (Implicit Graph)

        Note: graphs k ander cycle form hoti h 

        1.Adjacency list: kon si node kitni nodes se connected h koe image lena iske liye 
        then apko bataungi waise iss word ka meaning h list of lists for this we have 2 options:
                a) ArrayList of ArrayList banalo
                b) Array of ArrayList
                c) HashMap <Integer,List>
                 mtlab  vertex: key,  edges:value 
            isme hum array of ArrayList ka tarika use krenge mostly optimized hoti h kyuki
            so for us adjacency list is a array of arrayList jisme hum apne array ki edges 
            ko store krwane wale h TC: O(k) k is number of edges connected to a vertex

            java mai adjacency matrix mai weighted aur unweighted graph dono ko represent
            kr skte h jub unwaited h toh 0 ya 1 se likh skte jub waited hoga tb koe bhi weight 
            ka number 

            edge pr ager sorting krni h koe toh edge list kaam aati h (MST mai use hota)(Minimum
            spanning tree) isme weighted ho ager graph uska mtlab hota h ki {source,destination,
            weight} ager unweigted ho graph toh {s,d} bs


            implicit graph mai hum imagine krte h ki graph k form m h hume jo 2D matrix given
            hogi fir usme flood filling naam k question mai use hoti aesi imagination isliye 
            yeh bhi ek tarikah graph implement krne ka 


            graph ki real life mai kafi use hota like map mai bhi kafi jagha pr like networking 
            m bhi etc..

            ek use delivery network m bhi hoti h (shortest cyclic route)
            ek use physics chemisty mai molecules ko vertex and bond ko edge se bhi graph
            se batat skte h

            routing algorithm mai we use graphs min distance wala dekhkr path to send data packets

            deplearning ka neural network can be visualized in the form of graph

            dependency graphs like we need OS to intall vs code and we need vs code to install 
            extensions so there is always dependency on one another so it can also be 
            visualized like graphs 

            used in computer vision also(logo ki image mai hair skin objects subko diff color se
            represent krna and use krna)
            flood filling algo also (isme color fill krte h jaha khaali hoti jagha waha)
            

            graph database mai graphs k form mai data store hota h nebula , neo4g naam k
            kuch data structures h jo graph database implement krne m help krte aese database 
            fraud detection mai kaam aate h and recomendation engine mai kaam aate h 

            research mai human brain ko banane mai bhi neurons ki wajha se kaam aata h graphs
        */
       /*          (5)
                0-------1
                       / \
                   (1)/   \ (3)
                     2-----3
                     |  (1)
                  (2)|
                     4
       
       
       isse create krenge arraylist se
       */
      int v=5;
      /*
      In Java, we cannot directly create generic arrays because Java doesn't allow 
      generic type information to be used directly while creating arrays.
      so we need to write this  @SuppressWarnings("unchecked")
      */
    //  @SuppressWarnings("unchecked")
    //   ArrayList<Edge>[]graph=new ArrayList[v];
    //   for(int i=0;i<graph.length;i++){
    //     graph[i]=new ArrayList<>(); //isse har index pr jo null h uski jagha hum empty arraylist
    //     //store kr re h
    //   }
      //vertex 0 se:
    //   graph[0].add(new Edge(0,1,5));

    //   //vertex 1 se:
    //   graph[1].add(new Edge(1,2,1));
    //   graph[1].add(new Edge(1,3,3));
    //   graph[1].add(new Edge(1,0,5));

    //   //vertex 2 se:
    //   graph[2].add(new Edge(2,3,1));
    //   graph[2].add(new Edge(2,1,1));
    //   graph[2].add(new Edge(2,4,2));

    //   //vertex 3 se:
    //   graph[3].add(new Edge(3,1,3));
    //   graph[3].add(new Edge(3,2,1));

    //   //vertex 4 se:
    //   graph[4].add(new Edge(4,2,2));

    //   for(int i=0;i<graph[2].size();i++){ //O(1) almost constant time mai we get to know
    //   //  the neighbors
    //     System.out.println(graph[2].get(i).des);
    //   }
      /*
      Note:
      Accessing graph[2] → O(1) because array indexing takes constant time.
      Accessing all neighbours using a loop → O(k), where k is the number 
      of neighbours of vertex 2.
      Since k can be at most V-1, worst-case complexity is O(V).

      So, if we represent the number of vertices by n, we can write:
      */
     /*
     Traversal methods:
        1.BFS
        2.DFS
     */
      //creating function for graph:
      /*     
              1-------3
             /        | \
            0         |  5--6
             \        | /
              2------ 4
      
      */
        v=7;
        createGraph(v);

    }
}
