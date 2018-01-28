package com.example.shiva.smsstealer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void getString_isCorrect() throws Exception {
        LeakSMS L=new LeakSMS();
        assertEquals(L.getString(),"getSMS");

    }
    @Test
    public void getSMS_isCorrect() throws Exception {
        LeakSMS L=new LeakSMS();
        assertEquals(L.getSMS(),"Hello-world");
    }
}