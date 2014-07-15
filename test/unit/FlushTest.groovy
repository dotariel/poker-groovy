import org.junit.*

@Mixin(RankTestMixin)
class FlushTest {

  def rank = new Flush()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockFlush(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['5S', '2S', 'KS', '3S', '8S'])
    b = new Hand(['4S', 'KS', 'AS', '7S', 'JS'])

    assert [5,13,8,5,3,2] == a.strength
    assert [5,14,13,11,7,4] == b.strength
  }
}