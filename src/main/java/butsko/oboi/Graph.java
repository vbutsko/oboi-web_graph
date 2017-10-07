package butsko.oboi;

import java.util.*;

public class Graph
{
    private Map<Integer, Set<Integer>> graph;

    public Graph(int n)
    {
        graph = new HashMap<>(n);
    }

    public void updateVertex(int vertex, int edgeVertex)
    {
        final Set<Integer> edges = getEdgesForVertex(vertex);
        if (edges.isEmpty())
        {
            graph.put(vertex, new TreeSet<>(Arrays.asList(edgeVertex)));
        }
        else
        {
            edges.add(edgeVertex);
        }
    }

    public void updateVertex(int vertex, Set<Integer> edgeVertex)
    {
        final Set<Integer> edges = getEdgesForVertex(vertex);
        if (edges.isEmpty())
        {
            graph.put(vertex, edgeVertex);
        }
        else
        {
            edges.addAll(edgeVertex);
        }
    }

    public Set<Integer> getEdgesForVertex(int vertex)
    {
        final Set<Integer> edges = graph.get(vertex);
        return edges != null ? edges : Collections.emptySet();
    }

    public int size()
    {
        return graph.size();
    }

    public Set<Map.Entry<Integer, Set<Integer>>> getEntrySet()
    {
        return  graph.entrySet();
    }

    public void printGraph()
    {
        for(Map.Entry<Integer, Set<Integer>> vertex : graph.entrySet())
        {
            System.out.print(vertex.getKey() + " : ");
            for(Integer vert: vertex.getValue())
            {
                System.out.print(vert + "   ");
            }
            System.out.println();
        }
    }

    public int getDiameter()
    {
        int v = 0;
        v = getMaxIndex(bfs(v));
        int[] d = bfs(v);
        v = getMaxIndex(d);
        return d[v] != Integer.MAX_VALUE ? d[v] : graph.size();
    }

    private int[] bfs(int u)
    {
        int[] d = new int[graph.size()];
        for(int i = 0; i < d.length; i++)
            d[i] = Integer.MAX_VALUE;
        d[u] = 0;
        final Queue<Integer> queue = new PriorityQueue<>(d.length);
        queue.add(u);
        while(!queue.isEmpty())
        {
            u = queue.poll();
            for(Integer index : graph.get(u))
            {
                if(d[index] == Integer.MAX_VALUE)
                {
                    d[index] = d[u] + 1;
                    queue.add(index);
                }
            }
        }
        return d;
    }

    private int getMaxIndex(int[] mas)
    {
        int k = 0;
        for(int i = 0; i < mas.length; i++)
        {
            if (mas[i] > mas[k])
                k = i;
        }
        return k;
    }
}
