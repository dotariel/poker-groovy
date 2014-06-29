import org.junit.*

class HighCardTest {

  @Test
  public void should_return_rank() {
    assert new HighCard().evaluate(new Hand()) == true
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'TH', '2S', '3C', '8C'])
    checkWinner(a,b)

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'KD', '3S', '9D', '7C'])
    checkWinner(a,b)
  }

  private void checkWinner(winner, loser) {
    assert new HighCard().resolveTie(winner, loser) == winner
  }

}