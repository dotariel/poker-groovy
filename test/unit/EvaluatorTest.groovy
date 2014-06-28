import org.junit.*

class EvaluatorTest {

  @Test
  public void should_return_highest_rank_for_a_given_hand() {
    def evaluator = new Evaluator()

    assert evaluator.getRank(Hand.mockHighCard()) instanceof HighCard
    assert evaluator.getRank(Hand.mockPair()) instanceof Pair
    assert evaluator.getRank(Hand.mockTwoPair()) instanceof TwoPair
    assert evaluator.getRank(Hand.mockThreeOfAKind()) instanceof ThreeOfAKind
    assert evaluator.getRank(Hand.mockStraight()) instanceof Straight
    assert evaluator.getRank(Hand.mockFlush()) instanceof Flush
    assert evaluator.getRank(Hand.mockFullHouse()) instanceof FullHouse
    assert evaluator.getRank(Hand.mockFourOfAKind()) instanceof FourOfAKind
    assert evaluator.getRank(Hand.mockStraightFlush()) instanceof StraightFlush
  }

  @Test
  public void should_determine_winner_based_on_higher_rank() {
    def winner = new Hand(['5D', '5H', 'TC', '9S', '8D'])
    def loser = new Hand(['AD', 'KH', '2S', '3C', '8C'])

    def evaluator = new Evaluator()
    def result = evaluator.choose(winner, loser)

    assert result == winner
  }
}