import java.util.*;

class Main {
    static class Node {
        int key;
        Vector<Node> child =
                new Vector<>();
    }

    // Function to create a new node
    static Node createNode(int key) {
        Node temp = new Node();
        temp.key = key;
        return temp;
    }

    // Function to return the n° of siblings of a given node
    static int countSiblings(Node root, int value) {
        int count = 0;

        if (root == null)
            return count;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();

            for (int i = 0; i < temp.child.size(); i++) {
                if (temp.child.get(i).key == value) {
                    count = temp.child.size() - 1;
                    break;
                }

                q.add(temp.child.get(i));
            }
        }

        return count;
    }

    // Function to return the process number of the parent
    static int findParent(Node root, int processNumber){
      return countSiblings(root, processNumber) + 1;
    }


    static Node constructTree() {
        Node root = createNode(1);

        root.child.add(createNode(2));

        (root.child.get(0).child).add(createNode(3));
        (root.child.get(0).child).add(createNode(4));

        root.child.get(0).child.get(0).child.add(createNode(5));
        root.child.get(0).child.get(0).child.add(createNode(6));
        root.child.get(0).child.get(0).child.add(createNode(7));

        root.child.get(0).child.get(1).child.add(createNode(8));
        root.child.get(0).child.get(1).child.add(createNode(9));
        root.child.get(0).child.get(1).child.add(createNode(10));
        root.child.get(0).child.get(1).child.add(createNode(11));
        return root;
    }

    public static void main(String[] args) {
        Node root = constructTree();

        int X = 6;

        int i = findParent(root, X);
        System.out.println("For " + X + " the parent process would be " + i + " .");
    }
}

