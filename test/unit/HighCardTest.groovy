import org.junit.*

@Mixin(RankTestMixin)
class HighCardTest {

  def rank = new HighCard()

  @Test
  public void should_set_rank_on_visit() {
    checkVisit(new Hand(), HighCard)
  }

  @Test
  public void should_get_strength() {
    def a,b

    a = new Hand(['AD', 'KH', '3C', '9S', '8D'])
    b = new Hand(['AS', 'TH', '2S', '3C', '8C'])

    new HighCard().visit(a)
    new HighCard().visit(b)

    assert [0, 14, 13, 9, 8, 3] == a.strength
    assert [0, 14, 10, 8, 3, 2] == b.strength
  }
}