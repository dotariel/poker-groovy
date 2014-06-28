import org.junit.*

class HandTest {

  @Test
  public void should_make_hand_from_string() {
    def hand = new Hand(['TC', '9H', '3S', '4D', 'AH'])

    println hand.cards
  }

  @Test
  public void should_sort_cards() {
    def hand = Hand.mockHighCard()
    hand.sort()

    assert hand.cards.collect { it.value } == ['K', 'J', 'T', '9', '2']
  }
}