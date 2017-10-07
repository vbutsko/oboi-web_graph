package butsko.oboi;

import java.util.*;


public class GraphGenerator
{
    private int deg[];
    private int currentN;
    private Map<Integer, Set<Integer>> graph;


    public GraphGenerator(int n, int m)
    {
        this.deg = new int[n * m];
        this.currentN = 0;
        buildGraph(n, m);
    }

    public Map<Integer, Set<Integer>> getGraph()
    {
        return graph;
    }

    protected void buildGraph(int n, int m)
    {
        final Random random = new Random();
        graph = new HashMap<>(n);
        for (int i = 0; i < m*n; i++)
        {
            currentN++;
            deg[i]++;
            int index = getVertexIndex(random.nextDouble());
            deg[index]++;
            Set<Integer> vertexList = graph.get(index);
            if (vertexList == null)
            {
                vertexList = new HashSet<>(Arrays.asList(i));
                graph.put(index, vertexList);
            }
            else
            {
                vertexList.add(i);
            }
            final Set<Integer> newVertexList = new HashSet<>(Arrays.asList(index));
            graph.put(i, newVertexList);
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
