package net.andreaskluth.game_of_life;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class GameOfLife {

  private final int maxStage;
  private final int columns;
  private final int rows;
  private final boolean[][] grid;

  public GameOfLife(boolean[][] initialGrid, int maxStage) {
    if (initialGrid.length == 0) {
      throw new IllegalArgumentException("initialGrid must be a 2d array");
    }
    if (maxStage < 0) {
      throw new IllegalArgumentException("maxStage must not be negative");
    }

    this.grid = copy(initialGrid);
    this.rows = this.grid.length;
    this.columns = this.grid[0].length;
    this.maxStage = maxStage;
  }

  public void runAndRender(BiConsumer<Integer, boolean[][]> renderer) {
    renderer.accept(0, grid);
    int currentStage = 0;
    while (true) {
      if (currentStage == maxStage) {
        return;
      }
      renderer.accept(++currentStage, nextGeneration());
    }
  }

  public boolean[][] nextGeneration() {
    boolean[][] immutableCopy = copy(this.grid);
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        var neighbours = checkNeighbours(immutableCopy, row, column);
        grid[row][column] = deadOrAlive(immutableCopy[row][column], neighbours);
      }
    }
    return copy(grid);
  }

  private boolean deadOrAlive(boolean aliveStatus, Neighbours neighbours) {
    if (aliveStatus) {
      return neighbours.alive() >= 2 && neighbours.alive() <= 3;
    }
    return neighbours.alive() == 3;
  }

  private Neighbours checkNeighbours(boolean[][] immutableGrid, int locationX, int locationY) {
    var coordinates =
        filterOffGridCoordinates(possibleCoordinates(locationX, locationY), this.rows,
            this.columns);

    var count =
        coordinates.stream().filter(c -> immutableGrid[c.x()][c.y()]).count();
    return new Neighbours(count);
  }

  static List<Coordinate> possibleCoordinates(int locationX, int locationY) {
    var coordinates = new ArrayList<Coordinate>();
    for (int x = locationX - 1; x <= locationX + 1; x++) {
      for (int y = locationY - 1; y <= locationY + 1; y++) {
        if (x == locationX && y == locationY) {
          continue;
        }
        coordinates.add(new Coordinate(x, y));
      }
    }
    return coordinates;
  }

  static List<Coordinate> filterOffGridCoordinates(
      List<Coordinate> coordinates, int maxX, int maxY
  ) {
    return coordinates.stream()
        .filter(c -> c.x() >= 0)
        .filter(c -> c.x() < maxX)
        .filter(c -> c.y() >= 0)
        .filter(c -> c.y() < maxY)
        .toList();
  }

  private boolean[][] copy(boolean[][] source) {
    boolean[][] newCopy = new boolean[source.length][source[0].length];
    for (int i = 0; i < newCopy.length; i++) {
      newCopy[i] = Arrays.copyOf(source[i], source[0].length);
    }
    return newCopy;
  }

  private record Neighbours(long alive) {

  }

  record Coordinate(int x, int y) {

  }
}
