import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest_STUDENT {
    MyQueue<?>[] qs;
    @BeforeEach
    void setUp() {
        qs = new MyQueue<?>[5];
        MyQueue<Double> q1 = new MyQueue<>(1);
        MyQueue<Float> q2 = new MyQueue<>(2);
        MyQueue<Integer> q3 = new MyQueue<>(3);
        MyQueue<Boolean> q4 = new MyQueue<>(4);
        MyQueue<String> q5 = new MyQueue<>(5);
        try {
            q2.enqueue(11.11f);
            q3.enqueue(23); q3.enqueue(22); q3.enqueue(1);
            q4.enqueue(true); q4.enqueue(false); q4.enqueue(true);
            q5.enqueue("hello");
            qs[0] = q1;
            qs[1] = q2;
            qs[2] = q3;
            qs[3] = q4;
            qs[4] = q5;
        }catch(QueueOverflowException e){
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        for(MyQueue<?> q : qs){
            q = null;
        }
    }

    @Test
    void testIsEmpty() {
        assertTrue(qs[0].isEmpty());
        assertFalse(qs[1].isEmpty());
        assertFalse(qs[2].isEmpty());
        assertFalse(qs[3].isEmpty());
        assertFalse(qs[4].isEmpty());

    }

    @Test
    void testIsFull() {
        assertFalse(qs[0].isFull());
        assertFalse(qs[1].isFull());
        assertTrue(qs[2].isFull());
        assertFalse(qs[3].isFull());
        assertFalse(qs[4].isFull());
    }

    @Test
    void dequeue() {
        for(int i = 0; i < qs.length; i ++){
            try{
                if(i == 0){
                    qs[i].dequeue();
                    fail("Should throw exception");
                }else if(i == 4){
                    qs[i].dequeue();
                    qs[i].dequeue();
                    fail("Should throw exception");
                }else{
                    qs[i].dequeue();
                    assertTrue(true,"Passed");
                }
            }catch(QueueUnderflowException e){
                if(i == 0 || i == 4){
                    assertTrue(true, "Passed");
                }else{
                    fail("Should not throw exception");
                }
            }
        }
    }

    @Test
    void size() {
       assertEquals(0, qs[0].size());
       assertEquals(1, qs[1].size());
       assertEquals(3, qs[2].size());
       assertEquals(3, qs[3].size());
       assertEquals(1, qs[4].size());
    }

    @Test
    void enqueue() {
        try{
            ((MyQueue<Double>)qs[0]).enqueue(11.11d);
            assertTrue(true, "passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
        try{
            ((MyQueue<Float>)qs[1]).enqueue(1.1f);
            assertTrue(true, "passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
        try{
            ((MyQueue<Integer>)qs[2]).enqueue(1);
            fail("Should throw exception");
        }catch(QueueOverflowException e){
            assertTrue(true, "Passed");
        }
        try{
            ((MyQueue<Boolean>)qs[3]).enqueue(false);
            ((MyQueue<Boolean>)qs[3]).enqueue(true);
            fail("Should throw exception");
        }catch(QueueOverflowException e){
            assertTrue(true, "Passed");
        }
        try{
            ((MyQueue<String>)qs[4]).enqueue("test1");
            ((MyQueue<String>)qs[4]).enqueue("test2");
            assertTrue(true, "Passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
    }

    @Test
    void testToString() {
        assertEquals("", qs[0].toString());
        assertEquals("11.11",qs[1].toString());
        assertEquals("23221", qs[2].toString());
        assertEquals("truefalsetrue", qs[3].toString());
        assertEquals("hello", qs[4].toString());
    }

    @Test
    void testToStringDelimiter() {
        assertEquals("",qs[0].toString("fart"));
        assertEquals("11.11", qs[1].toString("$"));
        assertEquals("23 22 1", qs[2].toString(" "));
        assertEquals("true@#false@#true", qs[3].toString("@#"));
        assertEquals("hello",qs[4].toString(""));
    }

    @Test
    void fill() {
        ArrayList<Double> a1 = new ArrayList<>();
        ArrayList<Float> a2 = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        ArrayList<Boolean> a4 = new ArrayList<>();
        ArrayList<String> a5 = new ArrayList<>();
        a1.add(20.2);
        a2.add(2.2f);
        a4.add(true);
        a4.add(false);
        a5.add("new");
        a5.add("other");
        a5.add("cheese");
        a5.add("scoobydoo");
        try{
            ((MyQueue<Double>)qs[0]).fill(a1);
            assertTrue(true, "Passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
        try{
            ((MyQueue<Float>)qs[1]).fill(a2);
            assertTrue(true, "Passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
        try{
            ((MyQueue<Integer>)qs[2]).fill(a3);
            assertTrue(true, "Passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
        try{
            ((MyQueue<Boolean>)qs[3]).fill(a4);
            fail("Should throw exception");
        }catch(QueueOverflowException e){
            assertTrue(true, "Passed");
        }
        try{
            ((MyQueue<String>)qs[4]).fill(a5);
            assertTrue(true, "Passed");
        }catch(QueueOverflowException e){
            fail("Should not throw exception");
        }
    }
}