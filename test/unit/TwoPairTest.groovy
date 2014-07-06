import org.junit.*

@Mixin(RankTestMixin)
class TwoPairTest {

  def rank = new TwoPair()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockTwoPair(), TwoPair)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['AD','AH','7C','7S','8D']) // Two Pair: A,7
    b = new Hand(['KD','KC','8C','8S','2C']) // Two Pair: K,8
    checkWinner(rank,b,a)

    a = new Hand(['2D','2H','3C','3S','8D']) // Two Pair: 2,3
    b = new Hand(['4D','4C','2C','2S','8C']) // Two Pair: 2,4
    checkWinner(rank,b,a)

    a = new Hand(['2D','2H','3C','3S','8D']) // Two Pair: 2,3
    b = new Hand(['2D','2H','3C','3S','8D']) // Two Pair: 2,3
    checkTie(rank,a,b)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['AD','AH','7C','7S','8D']) // Two Pair: A,7
    b = new Hand(['KD','KC','8C','8S','2C']) // Two Pair: K,8

    rank.visit(a)
    rank.visit(b)

    assert [2,14,7,8,0,0] == a.strength
    assert [2,13,8,2,0,0] == b.strength
  }
}