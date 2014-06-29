import org.junit.*

@Mixin(RankTestMixin)
class FourOfAKindTest {

  def rank = new FourOfAKind()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockFourOfAKind(), FourOfAKind)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', 'KC', '8C'])
    b = new Hand(['AD', 'AH', 'AC', 'AS', '8D'])
    checkWinner(rank,b,a)

    a = new Hand(['KS', 'KH', 'KD', 'KC', '8C'])
    b = new Hand(['KS', 'KH', 'KD', 'KC', '9D'])
    checkWinner(rank,b,a)

    a = new Hand(['KS', 'KH', 'KD', 'KC', '8C'])
    b = new Hand(['KS', 'KH', 'KD', 'KC', '8C'])
    checkTie(rank,a,b)
  }
}