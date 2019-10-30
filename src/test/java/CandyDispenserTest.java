import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CandyDispenserTest {

  private CandyDispenser candyDispenser = new CandyDispenser();

  @Test
  public void child_accept_minimum_2_candies() {
    String response = candyDispenser.trickOrTreat(1, Arrays.asList(Arrays.asList(CandyDispenser.CANDY)));
    assertTrickOrTreat(response);
  }

  @Test
  public void child_accept_only_candies() {
    String response = candyDispenser.trickOrTreat(1,
        Arrays.asList(Arrays.asList(CandyDispenser.CANDY, CandyDispenser.APPLE, CandyDispenser.APPLE)));
    assertTrickOrTreat(response);
  }

  @Test
  public void child_is_satisfied_with_2_or_more_candies() {
    String response = candyDispenser.trickOrTreat(1,
        Arrays.asList(Arrays.asList(CandyDispenser.CANDY, CandyDispenser.CANDY, CandyDispenser.APPLE)));
    assertThankYou(response);
  }

  @Test
  public void child_is_not_satisfied_with_bomb() {
    String response = candyDispenser.trickOrTreat(1,
        Arrays.asList(Arrays.asList(CandyDispenser.BOMB, CandyDispenser.CANDY, CandyDispenser.CANDY)));
    assertTrickOrTreat(response);
  }

  @Test
  public void children_should_get_candies() {
    String response = candyDispenser.trickOrTreat(2,
        Arrays.asList(Arrays.asList(CandyDispenser.CANDY, CandyDispenser.CANDY, CandyDispenser.CANDY), Arrays.asList(CandyDispenser.CANDY, CandyDispenser.CANDY)));
    assertThankYou(response);
  }

  @Test
  public void children_should_be_happy() {
    String response = candyDispenser.trickOrTreat(2, Arrays.asList(Arrays.asList(CandyDispenser.CANDY, CandyDispenser.CANDY, CandyDispenser.CANDY),
            Arrays.asList(CandyDispenser.APPLE, CandyDispenser.CANDY)));
    assertTrickOrTreat(response);
  }

  private void assertThankYou(String response) {
    Assert.assertEquals(CandyDispenser.THANK_YOU_STRANGE_UNCLE, response);
  }

  private void assertTrickOrTreat(String response) {
    Assert.assertEquals(CandyDispenser.TRICK_OR_TREAT, response);
  }
}
