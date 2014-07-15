import org.junit.*

@Mixin(RankTestMixin)
class HighCardTest {

  def rank = new HighCard()

  @Test
  public void should_return_visit_result() {
    checkVisit(new Hand(), rank)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'TH', '2S', '3C', '8C'])

    assert [0, 14, 13, 9, 8, 3] == a.strength
    assert [0, 14, 10, 8, 3, 2] == b.strength
  }
}