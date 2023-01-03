import java.util.ArrayList;

/**
 * Projekt 1 - ruttsökning
 * <p>
 * Datastrukturer och algoritmer 2021
 * <p>
 * Programmeringsteam: ekstroem-svartsjr
 */
public class Main {

    public static void main(String[] args) {
        GraphData graph = new GraphData();
        ArrayList<Node> route = new ArrayList<Node>();
        AStar aStar = new AStar();
        Selection selection = new Selection(graph);

        graph.showNodesAndLinks();
        route = aStar.getRoute(selection.getSource(), selection.getDestination());
        aStar.showRoute(route);
    }
}