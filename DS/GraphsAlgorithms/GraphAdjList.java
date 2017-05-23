package GraphsAlgorithms;

import LinkList.LinkedList;

public class GraphAdjList {
	private LinkedList<Integer>[] adjList ; 
	private int vertexCount;
	private boolean isDirectedGraph;
	public GraphAdjList(int vertexCount,boolean directedGraph){
		this.isDirectedGraph = directedGraph; 
		this.vertexCount = vertexCount;
		adjList = new LinkedList[vertexCount];
		for(int i=0;i<vertexCount;i++){
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	private void addDirectedEdge(int source,int destination){
		adjList[source].add(destination);
	}
	
	
	private void addUnDirectedEdge(int source,int destination){
		adjList[source].add(destination);
		adjList[source].add(destination);
	}
	
	public void addEdge(int source , int destination){
		if(isDirectedGraph){
			addDirectedEdge(source, destination);
		}else{
			addUnDirectedEdge(source, destination);
		}
	}
	
	public LinkedList<Integer> getOutgoingEdges(int node){
		return adjList[node];
	}
}
