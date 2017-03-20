package secondTask;

import java.util.ArrayList;

public class main {
    public static void main(String[] argc) {
        Tree<Integer> test=new Tree(10,2);
        test.delNode(1);
        test.printTree();
    }
}
