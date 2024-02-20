import java.util.ArrayList;

public class MyStack <t> implements StackInterface<t>{
    private final ArrayList<t> arr; //final because we can add and remove but not reassign
    private final int size; //constant because this is the max size
    public MyStack(int size){
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
    public t pop() throws StackUnderflowException {
        if(arr.isEmpty()){
            throw new StackUnderflowException();
        }
       t poppedItem = arr.get(arr.size() - 1); //Save the last element
       arr.remove(arr.size() - 1); //remove it from the arraylist
       return poppedItem; //return the saved element
    }

    @Override
    public t top() throws StackUnderflowException {
        if(arr.isEmpty()){
            throw new StackUnderflowException();
        }
        return arr.get(arr.size() - 1);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean push(t e) throws StackOverflowException {
        if(arr.size() == size){
            throw new StackOverflowException();
        }
        arr.add(e);
        return true;
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
        if(arr.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(t a : arr){
            sb.append(a).append(delimiter);
        }
        return sb.substring(0, sb.length() - delimiter.length()); // goes to sb.length()-1 to exclude the delimiter at the very end
    }

    @Override
    public void fill(ArrayList<t> list) throws StackOverflowException {
        if(arr.size() + list.size() > size){ //if the new size is greater than max size throw exception
            throw new StackOverflowException();
        }
        arr.addAll(list);
    }
}
