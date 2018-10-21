package Graph;

import java.util.*;
class Topological{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0)
        {
            ArrayList<Integer>[] graph;
            int N,E;
            E=sc.nextInt();
            N=sc.nextInt();
            graph = new ArrayList[10001];
            for (int i=0; i<10001; ++i)
                graph[i] = new ArrayList();
            for(int i=0;i<E;i++)
            {
                int u,v;
                u=sc.nextInt();
                v=sc.nextInt();
                graph[u].add(v);
            }
            GfG g=new GfG();
            int res[] = g.topoSort(graph,N);
            boolean valid =true;
            for(int i=0;i<N;i++)
            {
                int n=graph[res[i]].size();
                for(int j=0;j<graph[res[i]].size();j++)
                {
                    for(int k=i+1;k<N;k++)
                    {
                        if(res[k]==graph[res[i]].get(j))
                            n--;
                    }
                }
                if(n!=0)
                {
                    valid =false;
                    break;
                }
            }
            if(valid==false)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{

    public static void topoSortUtil(int node,ArrayList<Integer> graph[],int n,boolean[] visited,Stack<Integer> stack){
        visited[node] = true;
        ArrayList<Integer> neighbours = graph[node];
        for(Integer neighnourNode : neighbours){
            if(!visited[neighnourNode]){
                topoSortUtil(neighnourNode,graph,n,visited,stack);
            }
        }
        stack.push(node);
    }

    public static int[] topoSort(ArrayList<Integer> graph[],int n)
    {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                topoSortUtil(i,graph,n,visited,stack);
            }

        }
        int[] result = new int[n];
        for(int i = 0 ; i< n ; i++){
            result[i] = stack.pop();
        }

        return result;


    }
}