package model;

import java.awt.Point;
import java.util.Random;

/**
 * This strategy selects the first available move at random.  It is easy to beat
 * 
 * @throws IGotNowhereToGoException whenever asked for a move that is impossible to deliver
 * 
 * @author mercer
 */
public class RandomAI implements TicTacToeStrategy {

  private static Random generator;

  public RandomAI() {
    generator = new Random();
  }

  // Find the first open spot randomly. Not likely to win against Stopper,
  // at least it loses more than Stopper and wins less than Stopper
  @Override
  public Point desiredMove(TicTacToeGame theGame) {
    boolean set = false;
    while (!set) {
      if (theGame.maxMovesRemaining() == 0)
        throw new IGotNowhereToGoException(
            " -- Hey there programmer, the board is filled");

      // Otherwise, try to randomly find an open spot 
      int row = generator.nextInt(theGame.size());
      int col = generator.nextInt(theGame.size());
      if (theGame.available(row, col)) {
        set = true;
        return new Point(row, col);
      }
    }
    return null;
  }
}