package butsko.oboi;

import java.util.*;


public class GraphGenerator
{
    private int n;
    private int m;
    private int deg[];
    private int currentN;


    public GraphGenerator(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.deg = new int[n * m];
        this.currentN = 0;
    }

    public Map<Integer, Set<Integer>> getMNGraphes()
    {
        final Random random = new Random();
        final Map<Integer, Set<Integer>> graphes = new HashMap<Integer, Set<Integer>>(n);
        for (int i = 0; i < m*n; i++)
        {
            currentN++;
            deg[i]++;
            int index = getVertexIndex(random.nextDouble());
            deg[index]++;
            Set<Integer> vertexList = graphes.get(index);
            if (vertexList == null)
            {
                vertexList = new HashSet<>(Arrays.asList(i));
                graphes.put(index, vertexList);
            }
            else
            {
                vertexList.add(i);
            }
            final Set<Integer> newVertexList = new HashSet<>(Arrays.asList(index));
            graphes.put(i, newVertexList);
        }
        return graphes;
    }

    private int getVertexIndex(double probability)
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
