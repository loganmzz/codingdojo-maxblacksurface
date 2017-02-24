package com.github.loganmzz.codingdojo.maxblacksurface;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

class Cell {

    final int x;
    final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Cell parse(String coordinate) {
        int colIndex = Integer.parseInt(coordinate.substring(0, 1));
        int rowIndex = Integer.parseInt(coordinate.substring(1, 2));
        return new Cell(colIndex, rowIndex);
    }

    Set<Cell> computeSiblings() {
        return new HashSet<>(asList(
                new Cell(x-1, y),
                new Cell(x+1, y),
                new Cell(x, y-1),
                new Cell(x, y+1)
        ));
    }

    @Override
    public String toString() {
        return x + "" + y;
    }

    @Override
    public int hashCode() {
        //No collision for x,y in [-1..9]
        return x * 100 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof  Cell)) return false;

        Cell that = (Cell) obj;

        return
                   this.x == that.x
                && this.y == that.y
        ;
    }
}
