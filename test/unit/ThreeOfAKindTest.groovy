import org.junit.*

@Mixin(RankTestMixin)
class ThreeOfAKindTest {

  def rank = new ThreeOfAKind()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockThreeOfAKind(), ThreeOfAKind)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', '3C', '8C'])
    b = new Hand(['AD', 'AH', 'AC', '9S', '8D'])
    checkWinner(rank,b,a)

    a = new Hand(['KS', 'KH', 'KD', '3C', '8C'])
    b = new Hand(['KS', 'KH', 'KD', '3C', '7D'])
    checkWinner(rank,a,b)

    a = new Hand(['KS', 'KH', 'KD', '3C', '8C'])
    b = new Hand(['KS', 'KH', 'KD', '3C', '8D'])
    checkTie(rank,a,b)
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