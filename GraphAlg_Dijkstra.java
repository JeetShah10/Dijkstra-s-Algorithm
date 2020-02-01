import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphAlg_Dijkstra 
{
	Map<String, Map<String, LinkedList<Integer>>> adj = new HashMap<String, Map<String, LinkedList<Integer>>>();
    int number_of_vertices;
    int[] distances;
	
	public GraphAlg_Dijkstra(int Number_of_Vertex)
	{
		number_of_vertices = Number_of_Vertex;
		 distances = new int[number_of_vertices];
	}
	
    public void addNode(String node) 
    {
        adj.putIfAbsent(node, new HashMap<String, LinkedList<Integer>>());
    }

    public void addNeighbor(String v1,String v2) 
    {
       adj.get(v1).putIfAbsent(v2, new LinkedList<Integer>());
    }
    
    public void addDistance(String v1,String v2,Integer v3) 
    {
	       adj.get(v1).get(v2).add(v3);
	}

    public LinkedList<Integer> getNeighbors(String v) 
    {
       return adj.get(v).get(v);
    }
    
    public void Dijkstra(Map<String, Map<String, LinkedList<Integer>>> adj,int S) throws FileNotFoundException
    {
    	int evaluationNode;
    	for(int i=0; i < number_of_vertices; i++)
    	{
    		distances[i] = Integer.MAX_VALUE;
    	}
    	distances[S] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<Node>(number_of_vertices,new Node());
    	for(int i=0; i < number_of_vertices; i++)
    	{
    		pq.add(new Node(i, distances[i]));
    	}
    	while (!pq.isEmpty())
        {
            evaluationNode = pq.remove().node;
            for(String key : adj.get(""+evaluationNode).keySet())
            {
            	if(distances[evaluationNode] + adj.get(""+evaluationNode).get(""+key).get(0) < distances[Integer.parseInt(key)])
            	{
            		distances[Integer.parseInt(key)] = distances[evaluationNode] + adj.get(""+evaluationNode).get(""+key).get(0);
            		pq.add(new Node(Integer.parseInt(key), distances[Integer.parseInt(key)]));
            	}
            }
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        String filePath = "input.txt";
    	File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;
        String [] tokens1;
        int Source = 0;
        
        line = br.readLine();
        tokens1 = line.split("\\s+");
        int Number_of_Vertex = Integer.parseInt(tokens1[0]);
        int Number_of_Edges = Integer.parseInt(tokens1[1]);
        GraphAlg_Dijkstra g = new GraphAlg_Dijkstra(Number_of_Vertex);
        while( (line = br.readLine()) != null )
        {
           tokens = line.split("\\s+");
           g.addNode( tokens[0]);
           g.addNode( tokens[1]);
           g.addNeighbor( tokens[0], tokens[1]);
           g.addDistance( tokens[0], tokens[1], (Integer.parseInt(tokens[2])));
        }
        br.close();
        g.Dijkstra(g.adj, Source);
        
        String Distance = Arrays.toString(g.distances);
  	  	Distance = Distance.replaceAll(",", "").replaceAll(" ", "\t").replace("[", "").replace("]", "");
  	  	String Vertex = String.join(",", g.adj.keySet());
  	  	Vertex = Vertex.replaceAll(",", "\t");
  	  	PrintStream o = new PrintStream(new File("output.txt"));
        System.setOut(o);
        System.out.print("Vertex\t"+Vertex);
        System.out.println();
        System.out.println("Distance\t"+Distance);
   }
}
class Node implements Comparator<Node>
{
  public int node;
  public int cost;

  public Node()
  {
  }

  public Node(int node, int cost)
  {
      this.node = node;
      this.cost = cost;
  }
  
  @Override
  public int compare(Node node1, Node node2)
  {
      if (node1.cost < node2.cost)
          return -1;
      if (node1.cost > node2.cost)
          return 1;
      return 0;
  }
}