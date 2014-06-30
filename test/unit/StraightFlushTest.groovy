import org.junit.*

@Mixin(RankTestMixin)
class StraightFlushTest {

  def rank = new StraightFlush()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockStraightFlush(), StraightFlush)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['4S', '5S', '6S', '7S', '8S'])
    b = new Hand(['6C', '7C', '8C', '9C', 'TC'])
    checkWinner(rank,b,a)

    a = new Hand(['4S', '5S', '6S', '7S', '8S'])
    b = new Hand(['4C', '5C', '6C', '7C', '8C'])
    checkTie(rank,a,b)
  }
}