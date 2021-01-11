package graph;

import java.util.Scanner;

public class BellmanFord1
{
    private int distances[];
    private int numberofvertices;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord1(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adjacencymatrix[][])
    {
        for (int node = 1; node <= numberofvertices; node++)
        {
            distances[node] = MAX_VALUE;
        }
 
        distances[source] = 0;
        for (int node = 1; node <= numberofvertices - 1; node++)
        {
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
            {
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
                {
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                    {
                        if (distances[destinationnode] > distances[sourcenode] 
                                + adjacencymatrix[sourcenode][destinationnode])
                            distances[destinationnode] = distances[sourcenode]
                                + adjacencymatrix[sourcenode][destinationnode];
                    }
                }
            }
        }
 
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
                if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                {
                    if (distances[destinationnode] > distances[sourcenode]
                           + adjacencymatrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            System.out.println("distance of source  " + source + " to "
                      + vertex + " is " + distances[vertex]);
        }
    }
 
    public static void main(String[] args)  
    { 
        int V = 5; // Number of vertices in graph 
        int E = 8; // Number of edges in graph 
      
        // Every edge has three values (u, v, w) where 
        // the edge is from vertex u to v. And weight 
        // of the edge is w. 
        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 }, 
                        { 1, 2, 3 }, { 1, 3, 2 },  
                        { 1, 4, 2 }, { 3, 2, 5 },  
                        { 3, 1, 1 }, { 4, 3, -3 } }; 
      
       BellmanFord1 b=new BellmanFord1(4); 
       b.BellmanFordEvaluation(1, graph);
        }

	
    }
