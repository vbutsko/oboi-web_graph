package butsko.oboi;

import java.util.*;


public class GraphGenerator
{
    private int deg[];
    private int currentN;
    private Graph graph;


    public GraphGenerator(int n, int m)
    {
        this.deg = new int[n * m];
        this.currentN = 0;
        buildGraph(n, m);
    }

    public Graph getGraph()
    {
        return graph;
    }

    public void collapseGraph(int m)
    {
        Graph collapsedGraph = new Graph(graph.size() / m);
        int indexNewVertex = 0;
        int currentM = 0;
        Set<Integer> newVertexIndexSet = new TreeSet<>();
        for(Map.Entry<Integer, Set<Integer>> vertex : graph.getEntrySet())
        {
            if (currentM == m)
            {
                collapsedGraph.updateVertex(indexNewVertex, newVertexIndexSet);
                newVertexIndexSet = new TreeSet<>();
                currentM = 0;
                indexNewVertex++;
            }
            newVertexIndexSet.addAll(vertex.getValue());
            currentM++;
        }
        currentN = graph.size() / m;
        collapsedGraph.updateVertex(indexNewVertex, newVertexIndexSet);
        graph = collapsedGraph;
    }

    protected void buildGraph(int n, int m)
    {
        graph = new Graph(n*m);
        final Random random = new Random();
        for (int i = 0; i < m*n; i++)
        {
            currentN++;
            deg[i]++;
            int index = getVertexIndex(random.nextDouble());
            deg[index]++;
            graph.updateVertex(i, index);
            graph.updateVertex(index, i);
        }
    }
    
    protected int getVertexIndex(double probability)
    {
        int previousDegSum = deg[0];
        int index = 0;
        while (previousDegSum / (2. * currentN - 1.) < probability)
        {
            previousDegSum += deg[index];
            index++;
        }
        return index;
    }
}
