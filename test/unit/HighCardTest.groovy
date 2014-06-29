import org.junit.*

@Mixin(RankTestMixin)
class HighCardTest {

  def rank = new HighCard()

  @Test
  public void should_return_rank() {
    assert new HighCard().evaluate(new Hand()) == true
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'TH', '2S', '3C', '8C'])
    checkWinner(rank,a,b)

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'KD', '3S', '9D', '7C'])
    checkWinner(rank,a,b)

    a = new Hand(['TD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'QD', '3S', '9D', '7C'])
    checkWinner(rank,b,a)
  }
}