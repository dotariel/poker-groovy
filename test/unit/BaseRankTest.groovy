import org.junit.*

class BaseRankTest {

  @Test
  public void should_get_high_card() {
    def hand = new Hand(['9S', '3D', '2C', 'JH', '7C'])

    def rank = new BaseRank() { }

    assert rank.getHighCard(hand).toString() == 'JH'
  }
}