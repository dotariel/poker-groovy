import org.junit.*

class StraightTest {

  @Test
  public void should_return_rank() {
    def rank = new Straight()

    assert rank.evaluate(Hand.mockStraight()) == true
    assert rank.evaluate(Hand.mockThreeOfAKind()) == false
    assert rank.evaluate(Hand.mockTwoPair()) == false
    assert rank.evaluate(Hand.mockPair()) == false
    assert rank.evaluate(Hand.mockHighCard()) == false
  }

  @Test
  public void should_determine_if_values_are_consecutive() {
    def rank = new Straight()

    assert rank.isConsecutive([1,2,3,4,6]) == false
    assert rank.isConsecutive([1,2,3,4,5]) == true
  }
}