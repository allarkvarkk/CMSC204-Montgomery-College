/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: JUnit tests for the sorted linked list class
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
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SortedDoubleLinkedListTest_STUDENT {
    private SortedDoubleLinkedList<String> stringList;
    private SortedDoubleLinkedList<Character> charList;
    private Comparator<String> stringComparator;
    private Comparator<Character> charComparator;
    private static final String[] S = {"fart", "cheese", "scooby doo"};
    private static final Character[] C = {'D', '^'};

    @Before
    public void setUp() throws Exception {
        stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        };
        charComparator = new Comparator<Character>() {
            @Override
            public int compare(Character character, Character t1) {
               return character.compareTo(t1);
            }
        };
        stringList = new SortedDoubleLinkedList<>(stringComparator);
        charList = new SortedDoubleLinkedList<>(charComparator);
        stringList.add(S[0]);
        stringList.add(S[1]);
        stringList.add(S[2]);
        charList.add(C[0]);
        charList.add(C[1]);
    }

    @After
    public void tearDown() throws Exception {
        stringList = null;
        charList = null;
        stringComparator = null;
        charComparator = null;
    }

    @Test
    public void iterator() {
        ListIterator<String> stringIt = stringList.iterator();
        ListIterator<Character> charIt = charList.iterator();
        assertFalse(stringIt.hasPrevious());
        assertTrue((stringIt.hasNext()));
        assertEquals(S[1], stringIt.next());
        assertFalse(stringIt.hasPrevious());
        assertEquals(S[0], stringIt.next());
        assertTrue(stringIt.hasPrevious());
        assertEquals(S[2], stringIt.next());
        assertFalse(stringIt.hasNext());
        assertEquals(S[2], stringIt.previous());
        assertEquals(C[0], charIt.next());
        assertEquals(C[1], charIt.next());
        try{
            charIt.next();
            fail("Should throw no such element exception");
        }catch(NoSuchElementException e){
            assertTrue("Passed", true);
        }catch(Exception e){
            fail("Wrong expception");
        }
    }

    @Test
    public void add() {
        ArrayList<String> stringArr = new ArrayList<>();
        ArrayList<Character> charArr = new ArrayList<>();
        stringArr.add(S[1]);
        stringArr.add(S[0]);
        stringArr.add(S[2]);
        charArr.add(C[0]);
        charArr.add(C[1]);
        assertEquals(stringArr, stringList.toArrayList());
        assertEquals(charArr, charList.toArrayList());
        stringList.add("fortnite :)");
        stringArr.add(stringArr.get(2));
        stringArr.set(2, "fortnite :)");
        assertEquals(stringArr, stringList.toArrayList());
    }

    @Test
    public void addToEnd() {
        try{
            stringList.addToEnd("cheese");
            fail("Should throw unsupported operation exception");
        }catch(UnsupportedOperationException e){
            assertTrue("Passed", true);
        }catch(Exception e){
            fail("Wrong exception");
        }
    }

    @Test
    public void addToFront() {
        try{
            stringList.addToFront("cheese");
            fail("Should throw unsupported operation exception");
        }catch(UnsupportedOperationException e){
            assertTrue("Passed", true);
        }catch(Exception e){
            fail("Wrong exception");
        }
    }

    @Test
    public void remove() {
        assertEquals(2, charList.getSize());
        System.out.println(charList.remove(C[0], charComparator).data);
        assertEquals(C[1], charList.getFirst());
        assertEquals(C[1], charList.getLast());
        assertEquals(1, charList.getSize());
    }
}