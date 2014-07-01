import org.junit.*

class HandTest {

  @Test(expected=InvalidHand)
  public void should_throw_exception_if_hand_is_not_correct_length() {
    def hand = new Hand(['TC'])
  }

  @Test
  public void should_make_hand_from_string() {
    def hand = new Hand(['TC', '9H', '3S', '4D', 'AH'])

    assert hand.cards.collect { c -> c.toString() } == ['TC', '9H', '3S', '4D', 'AH']
  }

  @Test
  public void should_sort_cards() {
    def hand = Hand.mockHighCard()
    hand.sort()

    assert hand.cards.collect { it.value } == ['K', 'J', 'T', '9', '2']
  }

  @Test
  public void should_get_pairs() {
    assert new Hand(['2S','2C','AH','KD','QS']).pairs.size() == 1
    assert new Hand(['2S','2C','AH','AD','QS']).pairs.size() == 2
  }

  @Test
  public void should_get_sets() {
    assert new Hand(['2S','2C','2H','KD','QS']).sets.size() == 1
  }

  @Test
  public void should_get_quads() {
    assert new Hand(['2S','2C','2H','2D','QS']).quads.size() == 1
  }

  @Test
  public void should_compare_cards() {
    def a,b

    a = makeSet(['A','K'])
    b = makeSet(['A','Q'])
    assert new Hand().compare(a,b) == 1

    a = makeSet(['T','2'])
    b = makeSet(['3','4'])
    assert new Hand().compare(a,b) == -1

    a = makeSet(['T','2'])
    b = makeSet(['T','2'])
    assert new Hand().compare(a,b) == 0
  }

  private def makeSet(List<String> str) {
    def set = [:]
    str.each { s ->
      set.put(s, [ new Card("${s}H"), new Card("${s}D") ])
    }
    set
  }
}