package CrackingCodingInterview.TreesAndGraphs;

public class App {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");
        Vertex j = new Vertex("J");

        a.addNeighbor(b);
        a.addNeighbor(f);
        a.addNeighbor(g);

        b.addNeighbor(c);
        b.addNeighbor(a);
        b.addNeighbor(d);

        c.addNeighbor(b);

        d.addNeighbor(b);
        d.addNeighbor(e);

        f.addNeighbor(a);

        g.addNeighbor(a);
        g.addNeighbor(h);

        h.addNeighbor(g);

       Graph graph = new Graph(a);
       //graph.bfsTraversal();
      // System.out.println("route exists? :" + graph.routeExists(b,h));
        //graph.dfsTraversal();
        graph.dfsUsingRecursion(graph.getRoot());

    }
}
