import org.junit.*

class FlushTest {

  @Test
  public void should_return_rank() {
    def rank = new Flush()

    assert rank.evaluate(Hand.mockFlush()) == true
    assert rank.evaluate(Hand.mockStraight()) == false
    assert rank.evaluate(Hand.mockThreeOfAKind()) == false
    assert rank.evaluate(Hand.mockTwoPair()) == false
    assert rank.evaluate(Hand.mockPair()) == false
    assert rank.evaluate(Hand.mockHighCard()) == false
  }
}