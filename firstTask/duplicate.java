package firstTask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class duplicate<T> {
    private HashMap<T, Object> table;
    private List<T> list;

    duplicate(List<T> dubl_list) {
        list = dubl_list;
    }

    /**
     * this method deletes duplicate elements in original list
     *
     */
    void deleteDuplicateInList() {
        table = new HashMap<T, Object>();
        ListIterator<T> iterator=list.listIterator();
        T current=iterator.next();

        while (iterator.hasNext()) {
            if (table.containsKey(current)) {
                iterator.remove();
            } else {
                table.put(current, true);
            }
            current=iterator.next();
        }
    }

    List<T> getList(){
        return list;
    }

    /**
     * this method return new list without duplicate elements
     *
     */
    List<T> deleteDuplicate() {
        table = new HashMap<T, Object>();
        LinkedList<T> tmp = new LinkedList<T>();

        for (T current : list) {
            if (!table.containsKey(current)) {
                table.put(current, true);
                tmp.add(current);
            }
        }
        return tmp;
    }
}
