import org.junit.*

@Mixin(RankTestMixin)
class StraightTest {

  def rank = new Straight()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockStraight(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b,c,d

    a = new Hand(['4S', '5H', '6D', '7C', '8C'])
    b = new Hand(['5D', '6C', '7S', '8D', '9C'])
    c = new Hand(['AD', '2C', '3S', '4D', '5C'])
    d = new Hand(['2D', '3C', '4S', '5D', '6C'])

    assert [4,8,7,6,5,4] == a.strength
    assert [4,9,8,7,6,5] == b.strength
    assert [4,5,4,3,2,0] == c.strength
    assert [4,6,5,4,3,2] == d.strength
  }
}