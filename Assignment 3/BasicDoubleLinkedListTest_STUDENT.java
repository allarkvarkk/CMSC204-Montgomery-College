/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: JUnit tests for the basic linked list class
 * Due: 3.11.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class BasicDoubleLinkedListTest_STUDENT {
    private BasicDoubleLinkedList<String> stringList;
    private BasicDoubleLinkedList<Character> charList;
    private BasicDoubleLinkedList<BasicDoubleLinkedList<Integer>> intListList;
    private static final String[] S = {"fart", "scooby doo", "batman"};
    private static final Character[] C = {'s', 'o', 'd', 'f'};
    private Comparator<String> stringComparator;
    private Comparator<Character> charComparator;



    @Before
    public void setUp() throws Exception {
        stringList = new BasicDoubleLinkedList<>();
        charList = new BasicDoubleLinkedList<>();
        intListList = new BasicDoubleLinkedList<>();
        stringComparator = new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                // TODO Auto-generated method stub
                return arg0.compareTo(arg1);
            }
        };
        charComparator = new Comparator<Character>() {
            @Override
            public int compare(Character character, Character t1) {
                return character.compareTo(t1);
            }
        };

        stringList.addToFront(S[0]);
        stringList.addToFront(S[1]);
        stringList.addToEnd(S[2]);

        charList.addToFront(C[0]);
        charList.addToEnd(C[1]);
        charList.addToFront(C[2]);
        charList.addToEnd(C[3]);

    }

    @After
    public void tearDown() throws Exception {
        stringList = null;
        charList = null;
        intListList = null;
        stringComparator = null;
        charComparator = null;
    }

    @Test
    public void getSize() {
        assertEquals(3, stringList.getSize());
        assertEquals(4, charList.getSize());
        assertEquals(0, intListList.getSize());
    }

    @Test
    public void addToEnd() {
        assertEquals(S[2], stringList.getLast());
        stringList.addToEnd("bark");
        assertEquals("bark", stringList.getLast());
        assertEquals(C[3], charList.getLast());
        charList.addToEnd('m');
        assertEquals('m',(char) charList.getLast());
        assertNull(intListList.getLast());
        BasicDoubleLinkedList<Integer> temp = new BasicDoubleLinkedList<>();
        temp.addToFront(4);
        temp.addToEnd(65);
        temp.addToFront(0);
        intListList.addToFront(temp);
        assertEquals(temp, intListList.getLast());
    }

    @Test
    public void addToFront() {
        assertEquals(S[1], stringList.getFirst());
        stringList.addToFront("oak");
        assertEquals("oak", stringList.getFirst());
        assertEquals(C[2], charList.getFirst());
        charList.addToFront('@');
        assertEquals('@', (char) charList.getFirst());
        assertNull(intListList.getFirst());
        BasicDoubleLinkedList<Integer> temp = new BasicDoubleLinkedList<>();
        temp.addToFront(67);
        temp.addToEnd(99);
        temp.addToFront(9999);
        intListList.addToFront(temp);
        assertEquals(temp, intListList.getFirst());
    }

    @Test
    public void iterator() {
        ListIterator<String> stringIt = stringList.iterator();
        ListIterator<Character> charIt = charList.iterator();
        assertEquals(S[1], stringIt.next());
        assertEquals(S[0], stringIt.next());
        assertEquals(S[2], stringIt.next());
        assertFalse(stringIt.hasNext());
        assertEquals(S[2], stringIt.previous());
        assertFalse(charIt.hasPrevious());
        assertEquals(C[2], charIt.next());
        assertFalse(charIt.hasPrevious());
        assertTrue(charIt.hasNext());
        assertEquals(C[0], charIt.next());
        assertEquals(C[1], charIt.next());
        assertEquals(C[1], charIt.previous());
        assertEquals(C[0], charIt.previous());
        try{
            charIt.nextIndex();
            fail("Should throw no such operation");
        }catch(UnsupportedOperationException e){
            assertTrue("Passed", true);
        }catch(Exception e){
            fail("Wrong exception");
        }
    }

    @Test
    public void toArrayList() {
        ArrayList<String> stringArr = new ArrayList<>();
        ArrayList<Character> charArr = new ArrayList<>();
        stringArr.add(S[1]);
        stringArr.add(S[0]);
        stringArr.add(S[2]);
        charArr.add(C[2]);
        charArr.add(C[0]);
        charArr.add(C[1]);
        charArr.add(C[3]);
        assertEquals(stringArr, stringList.toArrayList());
        assertEquals(charArr, charList.toArrayList());
    }

    @Test
    public void remove() {
       assertEquals(S[1], stringList.getFirst());
       System.out.println(stringList.remove(S[1], stringComparator));
       assertEquals(S[0], stringList.getFirst());
       assertEquals(S[2], stringList.getLast());
       System.out.println(stringList.remove(S[2], stringComparator));
       assertEquals(S[0], stringList.getLast());
       assertEquals(1, stringList.getSize());
       assertNull(stringList.remove("Should be null", stringComparator));

       assertEquals(C[2], charList.getFirst());
       System.out.println(charList.remove(C[2], charComparator));
       assertEquals(C[0], charList.getFirst());
       assertEquals(C[3], charList.remove(C[3], charComparator).data);
    }

    @Test
    public void retrieveFirstElement() {
        assertEquals(S[1], stringList.retrieveFirstElement());
        assertEquals(S[0], stringList.getFirst());
        assertEquals(S[0], stringList.retrieveFirstElement());
        assertEquals(S[2], stringList.retrieveFirstElement());
        assertNull(stringList.retrieveFirstElement());
    }

    @Test
    public void retrieveLastElement() {
        assertEquals(C[3], charList.retrieveLastElement());
        assertEquals(C[1], charList.getLast());
        assertEquals(C[1], charList.retrieveLastElement());
    }
}