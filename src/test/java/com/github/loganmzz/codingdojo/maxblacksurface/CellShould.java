package com.github.loganmzz.codingdojo.maxblacksurface;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static org.junit.Assert.assertEquals;

public class CellShould {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    private Stream<Cell> allCells() {
        return
                rangeClosed(-1, 9).boxed()              // x range
                .flatMap(x -> rangeClosed(-1, 9)        // y range
                        .mapToObj(y -> new Cell(x, y))  // (x,y) -> Cell
                )
        ;
    }

    @Test
    public void haveUniqueHashCodeForNegativeToNineRanges() {
        allCells()
                .collect(groupingBy(Cell::hashCode))      // group by hash
                .entrySet().stream()                      // browse map
                .filter(e -> e.getValue().size() > 1)     // only keep hash duplicates
                .forEach(e -> {                           // adds them to error
                    errorCollector.addError(new AssertionError(String.format("%s have all same hash (%s)", e.getValue(), e.getKey())));
                })
        ;
    }

    @Test
    public void haveNoDuplicatesForNegativeToNineRanges() {
        allCells()
                .collect(groupingBy(identity()))       // group by itself
                .entrySet().stream()                   // browse map
                .filter(e -> e.getValue().size() > 1)  // only keep duplicates
                .forEach(e -> {                        // adds them to error
                    errorCollector.addError(new AssertionError(String.format("%s shouldn't be equal", e.getValue(), e.getKey())));
                })
        ;
    }

    @Test
    public void have_m10_10_0m1_01_siblings_for_00() {
        assertEquals(
                Stream.of(new Cell(-1, 0), new Cell(1, 0), new Cell(0, -1), new Cell(0, 1)).collect(toSet()),
                new Cell(0,0).computeSiblings()
        );
    }

    @Test
    public void parseTo_X0_Y0_When_00() {
        assertEquals(new Cell(0, 0), Cell.parse("00"));
    }

    @Test
    public void parseTo_X1_Y0_When_10() {
        assertEquals(new Cell(1, 0), Cell.parse("10"));
    }

    @Test
    public void parseTo_X0_Y1_When_01() {
        assertEquals(new Cell(0, 1), Cell.parse("01"));
    }
}
