import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandyDispenser {

    public static final String TRICK_OR_TREAT = "Trick or treat!";
    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";
    public static final String CANDY = "candy";
    public static final String APPLE = "apple";
    public static final String BOMB = "bomb";
    private static final int minimumOfCandies = 2;

    public String trickOrTreat(int numberOfChild, List<List<String>> candies) {
        if (containsBomb(candies)
                || rightNumberOfPackOfCandies(numberOfChild, candies)
                || notSameNumberOfCandiesByPack(candies)
                || notEnoughCandies(numberOfChild, candies)) {
            return TRICK_OR_TREAT;
        }
        return THANK_YOU_STRANGE_UNCLE;
    }

    private boolean notEnoughCandies(int numberOfChild, List<List<String>> candies) {
        final long numberOfHappyChild = candies.stream().filter(this::isHappy).count();
        return numberOfHappyChild != numberOfChild;
    }

    private boolean notSameNumberOfCandiesByPack(List<List<String>> packOfCandies) {
        Set<Long> numberOfCandies = new HashSet<>();
        packOfCandies.forEach(candies ->
                numberOfCandies.add(getNumberOFCandies(candies)));
        return numberOfCandies.size() != 1;
    }

    private boolean rightNumberOfPackOfCandies(int numberOfChild, List<List<String>> candies) {
        return numberOfChild != candies.size();
    }

    private boolean containsBomb(List<List<String>> candies) {
        return candies.stream().flatMap(Collection::stream).anyMatch(s -> s.contains(BOMB));
    }

    private boolean isHappy(List<String> candies) {
        return (minimumOfCandies <= getNumberOFCandies(candies));
    }

    private long getNumberOFCandies(List<String> candies) {
        return candies.stream().filter(s -> s.contains(CANDY)).count();
    }
}
