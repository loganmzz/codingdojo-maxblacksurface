package com.github.loganmzz.codingdojo.maxblacksurface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

public class Grid {

    private int maxBlackSurface;

    public Grid(String blackCellCoordinates) {
        if (!blackCellCoordinates.isEmpty()) {
            maxBlackSurface = Stream
                    .of(blackCellCoordinates.split(","))
                    .map(Cell::parse)
                    .collect(HashMap::new, Grid::appendToCluster, (a,b) -> { throw new UnsupportedOperationException(); })
                    .entrySet().stream()
                    .mapToInt(e -> e.getValue().size())
                    .max().getAsInt()
            ;
        }
    }

    private static Map<Cell, Set<Cell>> appendToCluster(Map<Cell, Set<Cell>> cellToCluster, Cell blackCell) {
        Set<Cell> cluster = Stream.concat(
                blackCell.computeSiblings().stream().flatMap(sibling -> cellToCluster.getOrDefault(sibling, emptySet()).stream()),
                Stream.of(blackCell)
        ).collect(toSet());
        cluster.forEach(cell -> cellToCluster.put(cell, cluster));
        return cellToCluster;
    }

    public int getMaxBlackSurface() {
        return maxBlackSurface;
    }
}
