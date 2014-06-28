import org.junit.*

class FourOfAKindTest {

  @Test
  public void should_return_rank() {
    def rank = new FourOfAKind()

    assert rank.evaluate(Hand.mockFourOfAKind()) == true
    assert rank.evaluate(Hand.mockFlush()) == false
    assert rank.evaluate(Hand.mockStraight()) == false
    assert rank.evaluate(Hand.mockThreeOfAKind()) == false
    assert rank.evaluate(Hand.mockTwoPair()) == false
    assert rank.evaluate(Hand.mockPair()) == false
    assert rank.evaluate(Hand.mockHighCard()) == false
  }
}