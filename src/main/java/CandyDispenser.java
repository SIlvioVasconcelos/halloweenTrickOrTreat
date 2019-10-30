import java.util.Collection;
import java.util.List;

public class CandyDispenser {

  public static final String TRICK_OR_TREAT = "Trick or treat!";
  public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";
  public static final String CANDY = "candy";
  public static final String APPLE = "apple";
  public static final String BOMB = "bomb";
  public static final int minimumOfCandies = 2;

  public String trickOrTreat(int numberOfChild, List<List<String>> candies) {

    if (containsBomb(candies)) {
      return TRICK_OR_TREAT;
    }

    final long numberOfHappyChild = candies.stream().filter(this::isHappy).count();
    return numberOfHappyChild == numberOfChild ? THANK_YOU_STRANGE_UNCLE : TRICK_OR_TREAT;
  }

  private boolean containsBomb(List<List<String>> candies) {
    return candies.stream().flatMap(Collection::stream).anyMatch(s -> s.contains(BOMB));
  }

  private boolean isHappy(List<String> candies) {
    return (minimumOfCandies <= candies.stream().filter(s -> s.contains(CANDY)).count());
  }
}
