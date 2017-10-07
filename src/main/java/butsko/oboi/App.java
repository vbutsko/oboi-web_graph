package butsko.oboi;


import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void printGraph(final Map<Integer, Set<Integer>> graph)
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

    public static void main( String[] args )
    {
        int n = 100, m = 10;
        final GraphGenerator graphGenerator = new GraphGenerator(n, m);
        printGraph(graphGenerator.getGraph());
        System.out.println("===========================================================================================");
        graphGenerator.collapseGraph(m);
        printGraph(graphGenerator.getGraph());
    }
}
