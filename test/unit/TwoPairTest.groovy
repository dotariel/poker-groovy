import org.junit.*

class TwoPairTest {

  @Test
  public void should_return_rank() {
    def rank = new TwoPair()

    assert rank.evaluate(Hand.mockTwoPair()) == true
    assert rank.evaluate(Hand.mockPair()) == false
    assert rank.evaluate(Hand.mockHighCard()) == false
  }
}