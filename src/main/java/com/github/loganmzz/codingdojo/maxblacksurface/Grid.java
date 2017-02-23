package com.github.loganmzz.codingdojo.maxblacksurface;

public class Grid {


    private int maxBlackSurface;

    public Grid(String s) {
        maxBlackSurface = s.isEmpty() ? 0 : 1;
    }

    public int getMaxBlackSurface() {
        return maxBlackSurface;
    }
}
