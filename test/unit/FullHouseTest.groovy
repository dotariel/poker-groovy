import org.junit.*

@Mixin(RankTestMixin)
class FullHouseTest {

  def rank = new FullHouse()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockFullHouse(), FullHouse)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', '3C', '3H'])
    b = new Hand(['AD', 'AH', 'AC', '9S', '9H'])
    checkWinner(rank,b,a)

    a = new Hand(['2S', '2H', '2D', 'JC', 'JH'])
    b = new Hand(['5D', '5H', '5C', 'AS', 'AH'])
    checkWinner(rank,b,a)

    a = new Hand(['KS', 'KH', 'KD', '3C', '3H'])
    b = new Hand(['KS', 'KH', 'KD', '3D', '3S'])
    checkTie(rank,a,b)
  }
}