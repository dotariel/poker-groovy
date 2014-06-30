import org.junit.*

@Mixin(RankTestMixin)
class FlushTest {

  def rank = new Flush()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockFlush(), Flush)
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['5S', '2S', 'KS', '3S', '8S'])
    b = new Hand(['4S', 'KS', 'AS', '7S', 'JS'])
    checkWinner(rank,b,a)

    a = new Hand(['KS', 'QS', 'JS', 'TS', '8S'])
    b = new Hand(['KC', 'QC', 'JC', 'TC', '8C'])
    checkTie(rank,a,b)
  }  
}