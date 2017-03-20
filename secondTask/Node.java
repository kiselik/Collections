package secondTask;

import java.util.ArrayList;
import java.util.List;

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

    void deleteChildren() {
        children.clear();
    }

    List<Node> getChildren(){
        return children;
    }

    long getId(){
        return id;
    }




}

