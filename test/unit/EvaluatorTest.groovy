import org.junit.*

class EvaluatorTest {

  @Test
  public void should_return_highest_rank_for_a_given_hand() {
    def evaluator = new Evaluator()

    assert evaluator.evaluate(Hand.mockHighCard()) instanceof HighCard
    assert evaluator.evaluate(Hand.mockPair()) instanceof Pair
  }
}