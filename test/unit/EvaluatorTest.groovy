import org.junit.*

class EvaluatorTest {

  @Test
  public void should_return_highest_rank_for_a_given_hand() {
    def evaluator = new Evaluator()

    assert evaluator.evaluate(Hand.mockHighCard()) instanceof HighCard
    assert evaluator.evaluate(Hand.mockPair()) instanceof Pair
    assert evaluator.evaluate(Hand.mockTwoPair()) instanceof TwoPair
    assert evaluator.evaluate(Hand.mockThreeOfAKind()) instanceof ThreeOfAKind
    assert evaluator.evaluate(Hand.mockStraight()) instanceof Straight
    assert evaluator.evaluate(Hand.mockFlush()) instanceof Flush
    assert evaluator.evaluate(Hand.mockFullHouse()) instanceof FullHouse
    assert evaluator.evaluate(Hand.mockFourOfAKind()) instanceof FourOfAKind
    assert evaluator.evaluate(Hand.mockStraightFlush()) instanceof StraightFlush
  }
}