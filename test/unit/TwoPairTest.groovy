import org.junit.*

@Mixin(RankTestMixin)
class TwoPairTest {

  def rank = new TwoPair()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockTwoPair(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['AD','AH','7C','7S','8D']) // Two Pair: A,7
    b = new Hand(['KD','KC','8C','8S','2C']) // Two Pair: K,8

    assert [2,14,7,8,0,0] == a.strength
    assert [2,13,8,2,0,0] == b.strength
  }
}