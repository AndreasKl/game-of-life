package net.andreaskluth.game_of_life;

import static org.assertj.core.api.Assertions.assertThat;

import net.andreaskluth.game_of_life.GameOfLife.Coordinate;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  @Test
  void validateGenerations() {
    var seedGrid = new boolean[][]{
        {true, false, false, false},
        {false, true, true, false},
        {false, false, false, false},
        {false, false, true, false}
    };

    var gameOfLife = new GameOfLife(seedGrid, Integer.MAX_VALUE);

    var firstGeneration = gameOfLife.nextGeneration();
    var expectedFirst = new boolean[][]{
        {false, true, false, false},
        {false, true, false, false},
        {false, true, true, false},
        {false, false, false, false}
    };
    assertThat(firstGeneration).isDeepEqualTo(expectedFirst);

    var secondGeneration = gameOfLife.nextGeneration();
    var expectedSecond = new boolean[][]{
        {false, false, false, false},
        {true, true, false, false},
        {false, true, true, false},
        {false, false, false, false}
    };
    assertThat(secondGeneration).isDeepEqualTo(expectedSecond);

    var thirdGeneration = gameOfLife.nextGeneration();
    var expectedThird = new boolean[][]{
        {false, false, false, false},
        {true, true, true, false},
        {true, true, true, false},
        {false, false, false, false}
    };
    assertThat(thirdGeneration).isDeepEqualTo(expectedThird);
  }

  @Test
  void coordinatesShouldCalculateSurrounding() {
    var coordinates = GameOfLife.coordinates(1, 1);
    assertThat(coordinates.size()).isEqualTo(8);
    assertThat(coordinates).contains(new Coordinate(0, 0));
  }

}
