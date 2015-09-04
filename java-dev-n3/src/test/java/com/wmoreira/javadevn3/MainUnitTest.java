package com.wmoreira.javadevn3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wellington.362@gmail.com
 */

public class MainUnitTest {

    @Test
    public void testFirstCharCase1() {
        assertEquals(new Character('a'), Main.firstChar(new StreamImpl("AbbAacXx")));
    }

    public void testFirstCharCase2() {
        assertEquals(new Character('b'), Main.firstChar(new StreamImpl("aAbBABac")));
    }

    public void testFirstCharCase3() {
        assertNull(Main.firstChar(new StreamImpl("aabbccdd")));
    }

    public void testFirstCharCase4() {
        assertEquals(new Character('z'), Main.firstChar(new StreamImpl("aaaaaabbbbbbbbbccccccccccccccccddddddddDDeEEEEffFFqqzxl")));
    }

    public void testFirstCharCase5() {
        assertEquals(new Character('a'), Main.firstChar(new StreamImpl("a")));
    }

    public void testFirstCharCase6() {
        assertNull(Main.firstChar(new StreamImpl("")));
    }
}
