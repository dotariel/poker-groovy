import org.junit.*

@Mixin(RankTestMixin)
class ThreeOfAKindTest {

  def rank = new ThreeOfAKind()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(mockThreeOfAKind(), ThreeOfAKind)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', '3C', '8C'])
    b = new Hand(['AD', 'AH', 'AC', '9S', '8D'])

    rank.visit(a)
    rank.visit(b)

    assert [3,13,8,3,0,0] == a.strength
    assert [3,14,9,8,0,0] == b.strength
  }
}