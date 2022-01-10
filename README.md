``` 
Conway’s Game of Life
Problem statement
Implement a simulation of Conway's Game of Life, where the only inputs are the initial board, and a maximum number of stages.
At each stage, print the current board.
Stop the simulation as soon as the maximum number of stages is reached.
Game of Life definition
Imagine we have an n x n grid (n>=4) with each cell containing an organism. At any stage a cell can be alive or dead. The cell’s lifecycle is determined by its state (alive or dead) in the previous stage.

Example of a starting grid (T=0):
0 0 0 0
0 1 1 0
0 0 0 0
0 0 1 0

Where 0 and 1 represent dead and live organisms, respectively.
Rules for Subsequent stages:
Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.
Example of subsequent grid stages:
T=1
0 0 0 0
0 0 0 0
0 1 1 0
0 0 0 0

T=2
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
```


