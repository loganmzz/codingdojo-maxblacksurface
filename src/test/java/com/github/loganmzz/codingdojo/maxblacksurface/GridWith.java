package com.github.loganmzz.codingdojo.maxblacksurface;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GridWith {

    @Parameterized.Parameters(name = "{1}")
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] {   0, "" },
                new Object[] {   1, "01" },
                new Object[] {   2, "01,02" },
                new Object[] {   1, "01,03" },
                new Object[] {   4, "00,01,10,11" },
                new Object[] {   1, "00,00" },
                new Object[] {   2, "00,01" },
                new Object[] {   3, "00,10,01" },
                new Object[] {   4, "00,10,01,02" },
                // ####
                // #
                new Object[] {   5, "00,01,02,03,10" },
                // #
                // ###
                // #
                new Object[] {   5, "00,10,11,12,20" },
                // ###
                // ###
                // ###
                new Object[] {   9, "00,01,02,10,11,12,20,21,22" },
                // ###
                // # #
                // ###
                new Object[] {   8, "00,01,02,10,12,20,21,22" },
                // ####
                // ###
                // ###
                new Object[] {  10, "00,01,02,03,10,11,12,20,21,22" },
                // ###
                // #
                // ###
                //  #
                new Object[] {   8, "00,01,02,10,20,21,22,31" },
                new Object[] {   1, toString(range(0, 10).map(i -> i*11)) },
                new Object[] {   1, toString(iterate( 0, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(11, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(20, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(31, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(40, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(51, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(60, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(71, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(80, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate(91, GridWith::alternateCell).limit( 5)) },
                new Object[] {   1, toString(iterate( 0, GridWith::alternateCell).limit(50)) },
                new Object[] { 100, toString(range(0, 100)) },
                new Object[] {  99, toString(range(0, 100).filter(i -> i != 55)) }
        );
    }

    static int alternateCell(int continuousIndex) {
        int add;
        switch (continuousIndex % 10) {
            case 8:   add = 3; break;
            case 9:   add = 1; break;
            default:  add = 2;
        }
        return continuousIndex + add;
    }

    static String toString(IntStream stream) {
        return stream.mapToObj(i -> format("%02d", i)).collect(joining(","));
    }

    private int expectedMaxBlackSurface;
    private String gridSpecification;

    public GridWith(int expectedMaxBlackSurface, String gridSpecification) {
        this.expectedMaxBlackSurface = expectedMaxBlackSurface;
        this.gridSpecification       = gridSpecification;
    }

    @Test
    public void shouldHaveExpectedMaxBlackSurface() {
        assertEquals(expectedMaxBlackSurface, new Grid(gridSpecification).getMaxBlackSurface());
    }
}
