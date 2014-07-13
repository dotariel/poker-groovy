import org.junit.*

@Mixin(RankTestMixin)
class FullHouseTest {

  def rank = new FullHouse()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(mockFullHouse(), FullHouse)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', '3C', '3H'])
    b = new Hand(['AD', 'AH', 'AC', '9S', '9H'])

    rank.visit(a)
    rank.visit(b)

    assert [6,13,3,0,0,0] == a.strength
    assert [6,14,9,0,0,0] == b.strength
  }
}