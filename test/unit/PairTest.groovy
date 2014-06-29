import org.junit.*

@Mixin(RankTestMixin)
class PairTest {

  def rank = new Pair()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockPair(), Pair)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    // Different Pairs
    a = new Hand(['AD', 'AH', '3C', '9S', '8D'])
    b = new Hand(['7S', '7H', '2S', '3C', '8C'])
    checkWinner(rank,a,b)

    // Same Pair, different kickers
    a = new Hand(['AD', 'AH', '3C', '7S', '8C'])
    b = new Hand(['AS', 'AC', '3D', '9S', '8H'])
    checkWinner(rank,b,a)
  }
}