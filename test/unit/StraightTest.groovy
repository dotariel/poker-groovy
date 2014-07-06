import org.junit.*

@Mixin(RankTestMixin)
class StraightTest {

  def rank = new Straight()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(Hand.mockStraight(), Straight)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['4S', '5H', '6D', '7C', '8C'])
    b = new Hand(['5D', '6C', '7S', '8D', '9C'])

    rank.visit(a)
    rank.visit(b)

    assert [4,8,7,6,5,4] == a.strength
    assert [4,9,8,7,6,5] == b.strength
  }
}