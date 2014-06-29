import org.junit.*

class EvaluatorTest {

  @After
  public void after() {
    Evaluator.reset()
  }

  @Test
  public void should_assign_highest_rank_for_a_given_hand() {
    checkRank(Hand.mockHighCard(), HighCard)
    checkRank(Hand.mockPair(), Pair)
    checkRank(Hand.mockTwoPair(), TwoPair)
    checkRank(Hand.mockThreeOfAKind(), ThreeOfAKind)
    checkRank(Hand.mockStraight(), Straight)
    checkRank(Hand.mockFlush(), Flush)
    checkRank(Hand.mockFullHouse(), FullHouse)
    checkRank(Hand.mockFourOfAKind(), FourOfAKind)
    checkRank(Hand.mockStraightFlush(), StraightFlush)
  }

  @Test
  public void should_determine_winner_based_on_higher_rank() {
    def a = new Hand(['5D', '5H', 'TC', '9S', '8D'])
    def b = new Hand(['AD', 'KH', '2S', '3C', '8C'])

    assert new Evaluator().choose(a,b) == a
  }

  @Test
  public void should_determine_winner_by_resolving_tie() {
    def a = new Hand(['2D', '5H', 'TC', '9S', '8D']) // High Card: T
    def b = new Hand(['AD', 'KH', '2S', '3C', '8C']) // High Card: A

    assert new Evaluator().choose(a,b) == b
  }

  @Test
  public void should_result_in_tie() {
    def a,b
    def evaluator = new Evaluator()

    a = new Hand(['AD', 'AH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'AC', '3S', '9C', '8H'])

    assert evaluator.choose(a,b) == null
  }

  private void checkRank(hand, rank) {
    new Evaluator().assignRank(hand)
    assert hand.rank.class == rank
  }
}
