import org.junit.*

class HandTest {

  @Test
  public void should_sort_cards() {
    def hand = Hand.mockHighCard()
    hand.sort()

    assert hand.cards.collect { it.value } == ['K', 'J', '10', '9', '2']
  }

  @Test
  public void should_return_highest_card() {
    assert Hand.mockHighCard().getHighCard().toString() == "KC"
  }

}