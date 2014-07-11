import org.junit.*

class EvaluatorTest {

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
  public void should_determine_winner_based_on_strength() {
    def a = new Hand(['5D', '5H', 'TC', '9S', '8D'])
    def b = new Hand(['AD', 'KH', '2S', '3C', '8C'])

    assert new Evaluator().choose(a,b) == a
  }

  private void checkRank(hand, rank) {
    new Evaluator().assignRank(hand)
    assert hand.rank.class == rank
  }
}
