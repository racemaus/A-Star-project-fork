import java.util.ArrayList;
import java.util.Scanner;

public class Selection {
    Node source;
    Node destination;
    GraphData graph;

    // User selecton of start and destination
    public Selection(GraphData graph) {
        ArrayList<Node> nodes = graph.createGraph();
        Scanner sc = new Scanner(System.in);
        Boolean validInput = false;
        System.out.println("---------------");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(i + 1 + ". " + nodes.get(i).getName());
        }

        System.out.println("---------------\nFind route:\n");
        int input = 0;

        //Loops until valid selection
        while (!validInput) {
            System.out.println("Start: ");
            checkInput(sc);
            input = sc.nextInt() - 1;
            if (input >= 0 && input <= nodes.size() - 1) {
                this.source = nodes.get(input);
                validInput = true;
                break;
            } else {
                System.out.println("Selection out of bounds");
            }

        }
        validInput = !validInput;
        while (!validInput) {
            System.out.println("Destination: ");
            checkInput(sc);
            input = sc.nextInt() - 1;
            if (input >= 0 && input <= nodes.size() - 1) {

                if (this.source == nodes.get(input)) {
                    System.out.println("You're already here, try a different destination\n");
                } else {
                    this.destination = nodes.get(input);
                    validInput = true;
                    break;
                }

            } else {
                System.out.println("Selection out of bounds");
            }
        }


    }

    public Node getSource() {
        return this.source;
    }

    public Node getDestination() {
        return this.destination;
    }

    // Checks input for integers
    private void checkInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid selection, try again!");
            sc.next();
        }
    }
}
