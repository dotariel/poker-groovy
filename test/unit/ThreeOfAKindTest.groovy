import org.junit.*

class ThreeOfAKindTest {

  @Test
  public void should_return_rank() {
    def rank = new ThreeOfAKind()

    assert rank.evaluate(Hand.mockThreeOfAKind()) == true
    assert rank.evaluate(Hand.mockTwoPair()) == false
    assert rank.evaluate(Hand.mockPair()) == false
    assert rank.evaluate(Hand.mockHighCard()) == false
  }
}