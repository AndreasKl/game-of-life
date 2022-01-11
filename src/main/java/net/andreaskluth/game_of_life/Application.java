package net.andreaskluth.game_of_life;

public class Application {

  public static void main(String[] args) {
    var seedGrid = new boolean[][]{
        {true, false, false, false, false, false, false},
        {false, true, true, false, false, false, false},
        {false, false, false, false, false, false, false},
        {false, false, true, false, false, false, false},
        {false, false, true, false, false, false, false},
        {false, false, true, false, false, false, false},
        {false, false, false, false, false, false, false},
    };
    var gol = new GameOfLife(seedGrid, 20);
    gol.runAndRender(Application::render);
  }

  private static void render(int stage, boolean[][] grid) {
    System.out.printf("Generation: %d%n", stage);
    for (var rows : grid) {
      for (var isAlive : rows) {
        System.out.print(isAlive ? "█" : "▓");
      }
      System.out.println();
    }
  }

}
