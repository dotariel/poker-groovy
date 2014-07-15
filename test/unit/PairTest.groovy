import org.junit.*

@Mixin(RankTestMixin)
class PairTest {

  def rank = new Pair()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockPair(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['AD', 'AH', '3C', '9S', '8D'])
    b = new Hand(['7S', '7H', '2S', '3C', '8C'])

    assert [1,14,9,8,3,0] == a.strength
    assert [1,7,8,3,2,0] == b.strength
  }
}