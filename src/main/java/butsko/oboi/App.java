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
        int n = 100, m = 10;
        final GraphGenerator graphGenerator = new GraphGenerator(n, m);
        graphGenerator.getGraph().printGraph();
        System.out.println("===========================================================================================");
        graphGenerator.collapseGraph(m);
        graphGenerator.getGraph().printGraph();
    }
}
