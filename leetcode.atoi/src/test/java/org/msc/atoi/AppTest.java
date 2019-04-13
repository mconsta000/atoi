package org.msc.atoi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private App app = null;

    public AppTest() {
        app = new App();
    }

    @Test
    public void testPostiveInteger() {
        assertEquals(42, app.myAtoi("42"));
    }

    @Test
    public void testNegativeInteger() {
        assertEquals(-42, app.myAtoi("   -42"));
    }

    @Test
    public void testLeaderingInteger() {
        assertEquals(4193, app.myAtoi("4193 with words"));
    }

    @Test
    public void testTrailingInteger() {
        assertEquals(0, app.myAtoi("words and 987"));
    }

    @Test
    public void testUnderFlow(){
        assertEquals(-2147483648, app.myAtoi("-91283472332"));
    }

    @Test
    public void testOverFlow(){
        assertEquals(2147483647, app.myAtoi("91283472332"));
    }

    @Test
    public void TestOverFlow2(){
        assertEquals(2147483647, app.myAtoi("9223372036854775808"));
    }

    @Test
    public void TestUnderFlow2() {
        assertEquals(-2147483648, app.myAtoi("-6147483648"));
    }
}
