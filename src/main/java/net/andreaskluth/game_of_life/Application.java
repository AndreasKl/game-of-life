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
    var gameOfLife = new GameOfLife(seedGrid, 20);
    gameOfLife.runAndRender();
  }

}
