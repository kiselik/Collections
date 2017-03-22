package secondTask;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Node {
    private long id;
    private List<Node> children;

    Node(long id) {
        this.id = id;
        children=new ArrayList<>();
    }


    void addChild(Node child) {
        children.add(child);
    }

    void deleteChild(int index) {
        ListIterator<Node> iterator = children.listIterator();
        long result = -1;
        if (children.size() != 0) {
            result = iterator.next().getId();
            while (iterator.hasNext() && result != index)
                result = iterator.next().getId();
        }

            children.remove(iterator.previousIndex());
    }

    List<Node> getChildren(){
        return children;
    }

    long getId(){
        return id;
    }




}

