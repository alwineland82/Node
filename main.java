import java.util.ArrayList;

public class Main {

    static int[] solve(int a, int b, int c, int d) {
        int[] arr = new int[b + 1];
        arr[a] = 1;
        for (int index = a + 1; index <= b; index++) {
            if (index % d == 0) {
                arr[index] = arr[index - c] + arr[index / d];
            } else {
                arr[index] = arr[index - c];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 78;
        int c = 3;
        int d = 5;
        var so = solve(a, b, c, d);
        Node x = new Node();
        ArrayList<Node> res = x.build_tree();
        for(Node i : res){
            if(i != null && i.data == Node.limit) {
                System.out.println(i.history);
            }
        }

        for (int i = 0; i < so.length; i++) {
            System.out.printf("%d -> %d\n", i, so[i]);
        }
    }
}
