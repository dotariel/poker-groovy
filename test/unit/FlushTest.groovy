import org.junit.*

@Mixin(RankTestMixin)
class FlushTest {

  def rank = new Flush()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockFlush(), Flush)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['5S', '2S', 'KS', '3S', '8S'])
    b = new Hand(['4S', 'KS', 'AS', '7S', 'JS'])

    rank.visit(a)
    rank.visit(b)

    assert [5,13,8,5,3,2] == a.strength
    assert [5,14,13,11,7,4] == b.strength
  }
}