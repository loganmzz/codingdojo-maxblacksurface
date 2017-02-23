Goal
====

You receive as input a single string composed of a two digit sequence, each item separated by a ','.

It represents black cells in a 10x10 grid. For each item, first digit represents column index and second one the row
index.

Finally computes the size (number of cells) of biggest contiguous cell cluster. By contiguous, it means cells are
connected in horizontal or in vertical.

Examples:

Cells are not connected:
```
_#_
__#
```

but them are:
```
#__  ##_
#__  ___
```
