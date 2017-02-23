package com.github.loganmzz.codingdojo.maxblacksurface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridShould {

    @Test
    public void return_0_when_empty() {
        assertEquals(0, new Grid("").getMaxBlackSurface());
    }

    @Test
    public void return_1_when_01() {
        assertEquals(1, new Grid("01").getMaxBlackSurface());
    }

    @Test
    public void return_2_when_01_02() {
        assertEquals(2, new Grid("01,02").getMaxBlackSurface());
    }
}
