import java.util.ArrayList;

public class Node {

    String name;
    double latitude;
    double longitude;
    ArrayList<Node> neighbours = new ArrayList<Node>();
    String id;
    Node previous;

    Node(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    public void addNeighbour(Node neighbour) {
        this.neighbours.add(neighbour);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getPreviousNode() {
        return this.previous;
    }

    public void setPreviousNode(Node previous) {
        this.previous = previous;
    }

    /**
     * Calculate estimated distance from Node
     *
     * @param node destination
     * @return H distance
     */
    public double calculateH(Node node) {
        double hDistance = Utils.getDistance(this.getLongitude(), this.getLatitude(), node.getLongitude(),
                node.getLatitude());
        return hDistance;
    }

    /**
     * Calculate total distance (g) from source node
     *
     * @param source
     * @return Total distance (price) g
     */
    public double calculateG(Node source) {
        double g = 0;
        Node current = this;


        while (current != source) {
            double distance = Utils.getDistance(current.getLongitude(), current.getLatitude(), current.previous.getLongitude(), current.previous.getLatitude());
            g += distance;
            current = current.previous;
        }
        return g;
    }

    public double getF(Node source, Node destination) {
        return calculateG(source) + calculateH(destination);
    }

    public String getId() {
        return id;
    }
}