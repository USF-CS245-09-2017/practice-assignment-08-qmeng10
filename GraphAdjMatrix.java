import java.util.Stack;

public class GraphAdjMatrix implements Graph{
	private int[][]edges;
	
	//create graph martrix
	public GraphAdjMatrix(int vertices){
		edges = new int[vertices][vertices];
	}

	//add edges
	public void addEdge(int v, int w){
		edges[v][w] = 1;
	}

	//find the neighbors of the vertex
	public int[] neighbors(int vertex){
		int increment = 0;
		int[] neighbors = new int[outdegree(vertex)];
		for(int i = 0; i < edges.length; i++){
			if(edges[vertex][i] != 0){
				neighbors[increment] = i;
				increment++;
			}
		}
		return neighbors;
	}
	
	//find the number of edges point out from the vertex
	public int outdegree(int v1){
		int degree = 0;
		for(int i = 0; i < edges.length; i++){
			if(edges[v1][i] == 1)
				degree++;
		}
		
		return degree;
	}

	//find the number of edges point towards the vertex
	public int indegree(int v1){
		int degree = 0;
		for(int i = 0; i < edges.length; i++){
			if(edges[i][v1] == 1)
				degree++;
		}
		
		return degree;
	}


	//first search
	public void topologicalSort() {
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i < edges.length; i++){
			if(!visited[i]){
				topologicalSort(i, visited);
			}
		}
		
	}
	
	//check all the vertex one by one
	private void topologicalSort(int vertex, boolean[] visited) {
		Stack<Integer> s = new Stack<Integer>();
		visited[vertex] = true;
		s.push(new Integer(vertex));
		System.out.print(vertex);
		while(!s.empty()){
			int v = s.pop();
			int[] it = neighbors(v);
			for(int i = it.length; i > 0; i--){
				if(!visited[i]){
					System.out.print(i);
					visited[i] = true;
					s.push(new Integer(i));
					}
				}
			}
		}
}