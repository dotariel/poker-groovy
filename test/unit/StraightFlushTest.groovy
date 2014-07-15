import org.junit.*

@Mixin(RankTestMixin)
class StraightFlushTest {

  def rank = new StraightFlush()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockStraightFlush(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['4S', '5S', '6S', '7S', '8S'])
    b = new Hand(['6C', '7C', '8C', '9C', 'TC'])

    assert [8,8,7,6,5,4] == a.strength
    assert [8,10,9,8,7,6] == b.strength
  }

}