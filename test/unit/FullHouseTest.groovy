import org.junit.*

@Mixin(RankTestMixin)
class FullHouseTest {

  def rank = new FullHouse()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockFullHouse(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', '3C', '3H'])
    b = new Hand(['AD', 'AH', 'AC', '9S', '9H'])

    assert [6,13,3,0,0,0] == a.strength
    assert [6,14,9,0,0,0] == b.strength
  }
}