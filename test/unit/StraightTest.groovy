import org.junit.*

@Mixin(RankTestMixin)
class StraightTest {

  def rank = new Straight()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockStraight(), Straight)
  }

  @Test
  public void should_determine_if_values_are_consecutive() {
    def rank = new Straight()

    assert rank.isConsecutive([1,2,3,4,6]) == false
    assert rank.isConsecutive([1,2,3,4,5]) == true
  }

  @Test
  public void should_resolve_tie() {
    def a,b

    a = new Hand(['4S', '5H', '6D', '7C', '8C'])
    b = new Hand(['5D', '6C', '7S', '8D', '9C'])
    checkWinner(rank,b,a)

    a = new Hand(['4S', '5H', '6D', '7C', '8C'])
    b = new Hand(['4C', '5D', '6H', '7H', '8S'])
    checkTie(rank,a,b)
  }  
}