package secondTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
    private ArrayList<Node> tree;
    private Stack<Integer> stackChildren;
    private int countOfChild;
    private int size;

    Tree(int size, int countOfChild) {
        this.countOfChild = countOfChild;
        this.size = size;
        tree = new ArrayList<>();
        stackChildren = new Stack<>();
        //закидали всё в дерево
        for (int i = 0; i < size; i++) {
            Node tmp = new Node(i);
            tree.add(tmp);
        }
        for (int i = 0; i < tree.size(); i++)
            searchChildren(i);
    }


    Node searchNode(int index) {
        Node result = tree.get(index);
        return result;
    }

    /**
     * Delete part of tree. Method started from node with number index
     */
    void delNode(int index) {
        LinkedList<Node> openNode = new LinkedList<>();
        openNode.add(tree.get(index));
        while ((openNode.size() != 0)) {
            Node first = openNode.getFirst();
            if (first.getChildren().size() != 0)
                openNode.addAll(first.getChildren());
            stackChildren.add((int) first.getId());
            openNode.pop();
        }

        while (stackChildren.size() != 0) {
            //Node last = tree.get(stackChildren.peek());
            tree.get(stackChildren.peek()).deleteChildren();
            tree.remove((int) stackChildren.pop());
        }

    }

    private void searchChildren(int id) {
        long start = leftChild(id);
        if (start != -1) {
            long finish = rightChild(id);
            for (long i = start; i <= finish; i++) {
                tree.get(id).addChild(tree.get((int) i));
            }
        }
    }

    private long leftChild(int id) {
        long left = id * countOfChild + 1;
        if (left >= tree.size())
            return -1;
        else
            return left;
    }

    private long rightChild(int id) {
        long right = leftChild(id);
        if (right == -1)
            return -1;
        else
            return min(right + countOfChild - 1, tree.size() - 1);
    }

    private long min(long a, long b) {
        if (a <= b)
            return a;
        else
            return b;
    }

    void printTree() {
        for (Node i : tree) {
            System.out.print("Node: " + i.getId());

            if (i.getChildren().size() != 0) {
                System.out.print(" Its children: ");
                for (Node index_child : i.getChildren())
                    System.out.print(index_child.getId() + " ");
                System.out.println();
            } else {
                System.out.println(" Hasn't children =(");

            }
        }
    }

}

