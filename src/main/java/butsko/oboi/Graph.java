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

    public void upateVertex(int vertex, Set<Integer> edgeVertex)
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
}
