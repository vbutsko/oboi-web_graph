package butsko.oboi;


import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final GraphGenerator graphGenerator = new GraphGenerator(100, 10);
        Map<Integer, Set<Integer>> graph = graphGenerator.getMNGraphes();
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
