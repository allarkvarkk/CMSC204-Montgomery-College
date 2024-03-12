/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Basic double linked list class
 * Due: 3.11.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.*;

public class BasicDoubleLinkedList <T> implements Iterable<T>{
    protected Node head, tail;
    protected int size;
    public BasicDoubleLinkedList(){
        head = tail = null; //initializing the local variables
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public void addToEnd(T data){
        Node temp = new Node(data);
        if(tail != null){
            temp.prev = tail; //swap new element with the end
            tail.next = temp;
        }
        if(head == null){
            head = temp; //Means empty so assigns a head
        }
        size++; //increase size
        tail = temp; //make the new element the tail
        temp.next = null; //it's the end so there is no next
    }
    public void addToFront(T data){
        Node temp = new Node(data);
        if (size > 0) {
            temp.next = head; //swap new element with the start
            head.prev = temp;
        }
        if(tail == null){
            tail = temp;
        }
        size++; //increase size
        head = temp; //make the new element the head
        temp.prev = null; //it's the start so there is no prev
    }
    public T getFirst(){
        return head != null ? head.data : null;
    }
    public T getLast(){
        return tail != null ? tail.data : null;
    }
    @Override
    public DoubleLinkedListIterator iterator() {
        return new DoubleLinkedListIterator();
    }
    public ArrayList<T> toArrayList(){
        ArrayList<T> temp = new ArrayList<>();
        for (T t : this) {
            temp.add(t); //add each element to the arraylist
        }
        return temp;
    }
    public Node remove(T targetData, Comparator<T> comparator) {
        Node curr = head; //start at the head
        while (curr != null) {
            if (comparator.compare(curr.data, targetData) != 0) { //Not a match
                curr = curr.next; //go to the next node
                continue;
            } //else
                if (curr.prev != null) {curr.prev.next = curr.next;} else {head = curr.next;} //if prev is null make next the head
                if (curr.next != null) {curr.next.prev = curr.prev;} else {tail = curr.prev;} //if next is null make it the tail
                size--; //decrease size
                return curr; //return
        }
        return null;
    }
    public T retrieveFirstElement(){
        if(head != null){
            T headData = head.data;
            head = head.next; //will assign to null if next is null
            size--; //decrease size
            return headData;
        }
        return null;
    }
    public T retrieveLastElement(){
        if(tail != null){
            T tailData = tail.data;
            tail = tail.prev; //will assign to null if prev is null
            size--; //decrease size
            return tailData;
        }
        return null;
    }
    public class DoubleLinkedListIterator implements ListIterator<T>{
        private Node curr, lastPos;
        private final Node dummyHead, dummyTail;
        public DoubleLinkedListIterator(){
            dummyHead = new Node(null);
            dummyTail = new Node(null);
            lastPos = new Node(null);
            lastPos = dummyHead; //lastPos starts at the dummy head since that is where the iterator stars
            dummyTail.prev = tail; //set dummyTail to a null node after the tail
            dummyHead.next = head; //set dummyHead to a null node before the head
            curr = dummyHead; //start at the dummy head so the first next() goes to the head
        }
        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public T next() throws NoSuchElementException {
            if(hasNext()){
               if(curr.next != lastPos) { //if this is false it stays at the same pos and last pos will be the same
                   curr = curr.next;  //go to the next node
               }
                T temp = curr.data; //make a temp for curr.data in case the next if statement is true
                if(curr.data == getLast()) {
                    curr = dummyTail; //if it's at the tail go to the dummy node, so prev goes back to the tail
                }else {
                    lastPos = curr.prev; //update the last position
                }
                return temp;
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return curr.prev != null;
        }

        @Override
        public T previous() throws NoSuchElementException{
            if(hasPrevious()){
                if(curr.prev != lastPos) { //if this is false it stays at the same pos and last pos will be the same
                    curr = curr.prev; //go to the prev node
                }
                T temp = curr.data; //make a temp for curr.data in case the next if statement is true
                if(curr.data == getFirst()){
                    curr = dummyHead; //if it's at the head go to the dummy node, so next goes back to the head
                }else {
                    lastPos = curr.next; //update last position
                }
                return temp;
            }
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

         @Override
         public void set(T o) {
             throw new UnsupportedOperationException();
         }

         @Override
         public void add(T o) {
             throw new UnsupportedOperationException();
         }

     }
     public class Node{
        protected T data;
        protected Node prev, next;
        public Node(T dataNode){
            data = dataNode;
        }
    }
}
