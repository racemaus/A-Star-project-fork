import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AStar {

    public ArrayList<Node> getRoute(Node source, Node destination) {

        HashMap<String, Node> candidates = new HashMap<>();
        HashMap<String, Node> visited = new HashMap<>();
        Node current = source;
        Boolean isDone = false;

        while (!isDone) {
            double minF = 0;
            Node next = null;
            // Loop all neighbors of current
            for (Node neighbor : current.getNeighbours()) {
                // Check if neighbor is already in candidates or visited hashmap
                if (!candidates.containsKey(neighbor.getId()) && !visited.containsKey(neighbor.getId())) {
                    neighbor.setPreviousNode(current);
                    candidates.put(neighbor.getId(), neighbor);
                }
            }
            //Loop through all possible candidates
            for (Node candidate : candidates.values()) {
                // Are we at the destination?
                if (candidate == destination) {
                    isDone = true;
                    break;
                } else {

                    // Calculate the F value for the candidate
                    double f = candidate.getF(source, destination);

                    if (minF == 0 || minF > f) {
                        // We found our next _possible_ node to traverse to. Loop might still be looping.
                        minF = f;
                        next = candidate;
                    }
                }
            }

            if (!isDone) {
                // Traversed over to the node we chose
                current = next;
                visited.put(current.getId(), current);
                candidates.remove(current.getId());
            }
        }

        ArrayList<Node> route = new ArrayList<>();
        current = destination;

        // Generate the route by going backwards depending on the node's previous value
        while (current != source) {
            route.add(current);
            current = current.previous;
        }
        route.add(source);
        Collections.reverse(route);

        return route;
    }

    public void showRoute(ArrayList<Node> route) {
        System.out.println("---------------\nFastest route: \n");
        for (int i = 0; i < route.size(); i++) {
            System.out.println(i + 1 + ". " + route.get(i).getName());
        }
    }
}