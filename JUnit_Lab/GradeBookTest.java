/*
 * Class: CMSC204-30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Junit tests
 * Due: 1/30/2024
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

import static org.junit.Assert.assertEquals;

public class GradeBookTest {
    GradeBook gradeBook1, gradeBook2;
    @Before
    public void setUp() throws Exception {
        gradeBook1 = new GradeBook(3);
        gradeBook2 = new GradeBook(5);
        gradeBook1.addScore(80.33);
        gradeBook1.addScore(70.50);
        gradeBook1.addScore(14.75);
        gradeBook2.addScore(100.00);
        gradeBook2.addScore(94.50);
        gradeBook2.addScore(98.00);
        gradeBook2.addScore(90.20);
        gradeBook2.addScore(92.25);
    }

    @After
    public void tearDown() throws Exception {
        gradeBook1 = gradeBook2 = null;
    }

    @Test
    public void testAddScore() {
       assertEquals("80.33 70.5 14.75 ", gradeBook1.toString());
       assertEquals(3, gradeBook1.getScoresSize());
       assertEquals("100.0 94.5 98.0 90.2 92.25 ", gradeBook2.toString());
       assertEquals(5, gradeBook2.getScoresSize());
    }

    @Test
    public void sum() {
        assertEquals(165.58, gradeBook1.sum(), 0.01);
        assertEquals(474.95, gradeBook2.sum(), 0.01);
    }

    @Test
    public void minimum() {
        assertEquals(14.75, gradeBook1.minimum(),0.01);
        assertEquals(90.20, gradeBook2.minimum(),0.01);
    }

    @Test
    public void finalScore() {
        assertEquals(150.83,gradeBook1.finalScore(),0.01);
        assertEquals(384.75, gradeBook2.finalScore(),0.01);
    }

}