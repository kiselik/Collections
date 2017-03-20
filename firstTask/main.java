package firstTask;

import java.util.LinkedList;

public class main {
    public  static void main(String[] argc){
        LinkedList<Integer> test=new LinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(6);
        test.add(8);
        test.add(5);
        test.add(2);

        duplicate<Integer> test2=new duplicate<>(test);
        test2.deleteDuplicateInList();
        LinkedList<Integer> result=new LinkedList<>();
        result= (LinkedList<Integer>) test2.deleteDuplicate();

    }
}
