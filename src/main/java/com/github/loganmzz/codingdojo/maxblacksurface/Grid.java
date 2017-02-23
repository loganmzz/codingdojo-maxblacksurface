package com.github.loganmzz.codingdojo.maxblacksurface;

public class Grid {


    private int maxBlackSurface;

    public Grid(String s) {
        maxBlackSurface = s.isEmpty() ? 0 : s.split(",").length;
    }

    public int getMaxBlackSurface() {
        return maxBlackSurface;
    }
}
