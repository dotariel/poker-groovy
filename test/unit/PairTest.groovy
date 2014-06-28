import org.junit.*

class PairTest {
  @Test
  public void should_return_rank() {
    def rank = new Pair()

    assert rank.evaluate(Hand.mockPair()) == true
    assert rank.evaluate(Hand.mockHighCard()) == false
  }
}