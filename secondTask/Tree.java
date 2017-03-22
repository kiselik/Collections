package secondTask;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tree {
    private LinkedList<Node> tree;
    private int countOfChild;
    private int size;

    Tree(int size, int countOfChild) {
        this.countOfChild = countOfChild;
        this.size = size;
        tree = new LinkedList<>();
        //закидали всё в дерево
        for (int i = 0; i < size; i++) {
            Node tmp = new Node(i);
            tree.add(tmp);
        }
        for (int i = 0; i < tree.size(); i++)
            searchChildren(i);
    }


    private void searchChildren(int id) {
        int start = id * countOfChild + 1;
        int finish = start + countOfChild - 1;
        for (int i = start; (i <= finish) && (i < size); i++) {
            tree.get(id).addChild(tree.get((int) i));
        }
    }

    /**
     * this method find number of Node in our tree, which has id=index
     */
    long searchNode(long index) {
        ListIterator<Node> iterator = tree.listIterator();
        long result = -1;
        if (tree.size() != 0) {
            result = iterator.next().getId();
            while (iterator.hasNext() && result != index)
                result = iterator.next().getId();
        }
        return iterator.previousIndex();
    }


    /**
     * Delete part of tree. Method started from node with number index
     */
    void delNode(int index) {
        //список вершин, которые надо удалить
        LinkedList<Node> openNode = new LinkedList<>();

        long parent = (index - 1) / countOfChild;
        tree.get((int) parent).deleteChild(index);

        openNode.add(tree.get(index));
        while ((openNode.size() != 0)) {
            Node first = openNode.getFirst();
            openNode.addAll(first.getChildren());
            //нашли номер вершины first в текущем списке tree
            tree.remove((int) searchNode(first.getId()));
            openNode.pop();
        }
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

