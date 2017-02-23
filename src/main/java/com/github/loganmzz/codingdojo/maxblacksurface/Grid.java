package com.github.loganmzz.codingdojo.maxblacksurface;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid {


    private int maxBlackSurface;

    public Grid(String blackCellCoordinates) {
        if (!blackCellCoordinates.isEmpty()) {
            int[][] grid = new int[10][10];
            for (String blackCellCoordinate : blackCellCoordinates.split(",")) {
                int colIndex = Integer.parseInt(blackCellCoordinate.substring(0, 1));
                int rowIndex = Integer.parseInt(blackCellCoordinate.substring(1, 2));
                grid[colIndex][rowIndex] = 1;
            }

            for (int colIndex = 0; colIndex < grid.length; colIndex++) {
                for (int rowIndex = 0; rowIndex < grid[colIndex].length; rowIndex++) {
                    if (grid[colIndex][rowIndex] == 1) {
                        if (colIndex > 0) grid[colIndex][rowIndex] += grid[colIndex-1][rowIndex  ];
                        if (rowIndex > 0) grid[colIndex][rowIndex] += grid[colIndex  ][rowIndex-1];
                    }
                }
            }
            maxBlackSurface = Stream.of(grid).flatMapToInt(col -> IntStream.of(col)).max().getAsInt();
        }
    }

    public int getMaxBlackSurface() {
        return maxBlackSurface;
    }
}
