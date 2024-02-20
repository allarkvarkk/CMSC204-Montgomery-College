import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest_STUDENT {
    private MyStack<Double> s1;
    private MyStack<Integer> s2;
    private MyStack<Boolean> s3;
    private MyStack<String> s4;
    private MyStack<Character> s5;
    @BeforeEach
    void setUp() {
        s1 = new MyStack<>(2);
        s2 = new MyStack<>(5);
        s3 = new MyStack<>(5);
        s4 = new MyStack<>(6);
        s5 = new MyStack<>(0);
        try{
            s1.push(23.3d); s1.push(255.5d);
            s2.push(2);
            s4.push("scooby doo"); s4.push("cheese"); s4.push("roblox");
        }catch(StackOverflowException e){
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;
        s5 = null;
    }

    @Test
    void isEmpty() {
        assertFalse(s1.isEmpty());
        assertFalse(s2.isEmpty());
        assertTrue(s3.isEmpty());
        assertFalse(s4.isEmpty());
        assertTrue(s5.isEmpty());
    }

    @Test
    void isFull() {
        assertTrue(s1.isFull());
        assertFalse(s2.isFull());
        assertFalse(s3.isFull());
        assertFalse(s4.isFull());
        assertTrue(s5.isFull());
    }

    @Test
    void pop() {
        try{
            s1.pop();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s2.pop();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s3.pop();
            fail("Should throw exception");
        }catch(StackUnderflowException e){
        }
        try{
            s4.pop();
            s4.pop();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s5.pop();
            fail("Should throw exception");
        }catch(StackUnderflowException e){
        }
    }

    @Test
    void top() {
        try{
            s1.top();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s2.top();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s3.top();
            fail("Should throw exception");
        }catch(StackUnderflowException e){
        }
        try{
            s4.top();
        }catch(StackUnderflowException e){
            fail("Should not throw exception");
        }
        try{
            s5.top();
            fail("Should throw exception");
        }catch(StackUnderflowException e){
        }
    }

    @Test
    void size() {
        assertEquals(2,s1.size());
        assertEquals(1, s2.size());
        assertEquals(0,s3.size());
        assertEquals(3,s4.size());
        assertEquals(0,s5.size());
    }

    @Test
    void push() {
        try{
            s1.push(232.2);
            fail("Should throw exception");
        }catch(StackOverflowException e) {
        }
        try{
            s2.push(3);
        }catch(StackOverflowException e){
            fail("Shoud not throw exception");
        }
        try{
            s3.push(false);
        }catch(StackOverflowException e){
            fail("Should not throw exception");
        }
        try{
            s4.push("Cheese boogie man");
        }catch(StackOverflowException e){
            fail("Should not throw exception");
        }
        try{
            s5.push('#');
            fail("Should throw exception");
        }catch(StackOverflowException e){
        }
    }

    @Test
    void testToString() {
        assertEquals("23.3255.5", s1.toString());
        assertEquals("2", s2.toString());
        assertEquals("", s3.toString());
        assertEquals("scooby doocheeseroblox", s4.toString());
        assertEquals("", s5.toString());
    }

    @Test
    void testToStringDelimiter() {
        assertEquals("23.3%255.5", s1.toString("%"));
        assertEquals("2",s2.toString("asdasd"));
        assertEquals("", s3.toString("!!"));
        assertEquals("scooby doo@#@#cheese@#@#roblox", s4.toString("@#@#"));
        assertEquals("",s5.toString(""));
    }

    @Test
    void fill() {
        ArrayList<Double> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Boolean> a3 = new ArrayList<>();
        ArrayList<String> a4 = new ArrayList<>();
        ArrayList<Character> a5 = new ArrayList<>();
        a2.add(4); a2.add(2); a2.add(203); a2.add(210230);
        a3.add(true);
        a4.add("batman"); a4.add("robin"); a4.add("slade"); a4.add("shaggy");
        a5.add('/');
        try{
            s1.fill(a1);
        }catch(StackOverflowException e){
            fail("Should not throw exception");
        }
        try{
            s2.fill(a2);
        }catch(StackOverflowException e){
            fail("Should not throw exception");
        }
        try{
            s3.fill(a3);
        }catch(StackOverflowException e){
            fail("Should not throw exception");
        }
        try{
            s4.fill(a4);
            fail("Should throw exception");
        }catch(StackOverflowException e){
        }
        try{
            s5.fill(a5);
            fail("Should throw exception");
        }catch(StackOverflowException e){
        }
        assertEquals("23.3255.5", s1.toString());
        assertEquals("242203210230", s2.toString());
        assertEquals("true", s3.toString());
        assertEquals("scooby doocheeseroblox", s4.toString());
        assertEquals("", s5.toString());
    }
}