package graphs.util;

public class GraphUtilsTest {

    public static void main(String[] args) {
        GraphUtils graphUtils = new GraphUtils();
        Graph g = graphUtils.constructGraph();
        graphUtils.DFS(g);
        g.print();
        System.out.println(" Is Graph acyclic? " + (graphUtils.isAcyclic(g) ? "Yes " : " No"));

    }


}
