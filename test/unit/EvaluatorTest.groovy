import org.junit.*

@Mixin(RankTestMixin)
class EvaluatorTest {

  @Test
  public void should_determine_winner_based_on_strength() {
    def a = new Hand(['5D', '5H', 'TC', '9S', '8D'])
    def b = new Hand(['AD', 'KH', '2S', '3C', '8C'])

    assert new Evaluator().choose(a,b) == a
  }

  private void checkRank(hand, rank) {
    new Evaluator().assignRank(hand)
    assert hand.type.rank.class == rank
  }
}
