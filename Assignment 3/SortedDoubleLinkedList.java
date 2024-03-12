/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Sorted double linked list class
 * Due: 3.11.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.*;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList <T> {
    private final Comparator<T> comparator;
    public SortedDoubleLinkedList(Comparator<T> comparator){
        this.comparator = comparator;
    }

    @Override
    public DoubleLinkedListIterator iterator() {
        return super.iterator();
    }

    public void add(T data){
        Node curr = head, temp;
        temp = new Node(data);
            while (curr != null) {
                if (comparator.compare(curr.data, data) <= 0) {
                    if(curr.next != null) {
                        curr = curr.next;
                        continue;
                    }
                    tail.next = temp;
                    temp.prev = tail;
                    tail = temp;
                    size++;
                    return;
                }
                temp.next = curr;
                if(curr.prev == null){
                    head = temp;
                }else{
                    curr.prev.next = temp;
                    temp.prev = curr.prev;
                }
                curr.prev = temp;
                size++;
                return;
            }
                if(getSize() == 0){
                    head = temp;
                    tail = temp;
                }
                size++;
    }

    public void addToEnd(T data){
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    public void addToFront(T data){
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    @Override
    public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator) {
        return super.remove(data, comparator);
    }
}
