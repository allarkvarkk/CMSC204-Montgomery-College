import java.util.ArrayList;

public class MyQueue <t> implements QueueInterface <t>{
    private final ArrayList<t> arr; //final because we can add and remove but not reassign
    private final int size; //constant because this is the max size
    public MyQueue(int size){
        this.size = size; //Assign parameter to instance variable
        arr = new ArrayList<>(); //initialize the ArrayList
    }
    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public boolean isFull() {
        return arr.size() == size;
    }

    @Override
    public t dequeue() throws QueueUnderflowException {
        if(arr.isEmpty()){
            throw new QueueUnderflowException();
        }
        t dequeuedElement = arr.get(0); //Save the element first
        arr.remove(0); //remove it from the arraylist
        return dequeuedElement; //return the saved element
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean enqueue(t e) throws QueueOverflowException {
        if(arr.size() == size){
            throw new QueueOverflowException();
        }
        return arr.add(e); //returns true if added false if not
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(t a : arr){
            sb.append(a);
        }
        return sb.toString();
    }

    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for(t a : arr){

            sb.append(a).append(delimiter);
        }
        return sb.substring(0,sb.length()-1); // goes to sb.length()-1 to exclude the delimiter at the very end
    }

    @Override
    public void fill(ArrayList<t> list) throws QueueOverflowException {
        if(arr.size() + list.size() > size){ //if the new size is greater than max size throw exception
            throw new QueueOverflowException();
        }
        arr.addAll(list);
    }
}
