import java.util.ArrayList;

public class Node {
    static int start = 6;
    static int limit = 78;
    static int mult = 3;
    static int plus = 5;
    int data;
    Node left;
    Node right;
    String history;

    Node(){
        this.data = Node.start;
        this.left = null;
        this.right = null;
        this.history = "";
    }
    public void add_nodes(){
        if (this.data * Node.mult <= Node.limit) {
            this.left = new Node();
            this.left.data = this.data * Node.mult;
            this.left.history = this.history + " mult";
        }
        if (this.data + Node.mult <= Node.limit) {
            this.right = new Node();
            this.right.data = this.data + Node.plus;
            this.right.history = this.history + " plus";
        }
    }

    public ArrayList<Node> build_tree() {
        this.add_nodes();
        ArrayList<Node> lst_of_nodes = new ArrayList<Node>();
        lst_of_nodes.add(this);
        for(int i = 0; i <= lst_of_nodes.size() - 1; ++i){
            if (lst_of_nodes.get(i) != null) {
                lst_of_nodes.get(i).add_nodes();
                lst_of_nodes.add(lst_of_nodes.get(i).left);
                lst_of_nodes.add(lst_of_nodes.get(i).right);
            }
        }
        return lst_of_nodes;
    }

    public static void node_tree_params(int a, int b, int c, int d){
        Node.start = a;
        Node.limit = b;
        Node.mult = c;
        Node.plus = d;
    }
}
