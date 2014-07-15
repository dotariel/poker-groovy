import org.junit.*

@Mixin(RankTestMixin)
class FourOfAKindTest {

  def rank = new FourOfAKind()

  @Test
  public void should_return_visit_result() {
    checkVisit(mockFourOfAKind(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['KS', 'KH', 'KD', 'KC', '8C'])
    b = new Hand(['AD', 'AH', 'AC', 'AS', '8D'])

    assert [7,13,8,0,0,0] == a.strength
    assert [7,14,8,0,0,0] == b.strength
  }
}