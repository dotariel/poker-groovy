import org.junit.*

@Mixin(RankTestMixin)
class HandTest {

  @Test(expected=InvalidHand)
  public void should_throw_exception_if_hand_is_not_correct_length() {
    def hand = new Hand(['TC'])
  }

  @Test
  public void should_make_hand_from_string() {
    def hand = new Hand(['TC', '9H', '3S', '4D', 'AH'])

    assert hand.cards.collect { c -> c.toString() } == ['AH', 'TC', '9H', '4D', '3S']
  }

  @Test
  public void should_sort_cards() {
    def hand = mockHighCard()
    hand.sort()

    assert hand.cards.collect { it.face } == ['K', 'J', 'T', '9', '2']
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
  public void should_determine_straight() {
    assert new Hand(['AC','2S','3C','4H','5D']).isStraight() == true
    assert new Hand(['2S','3C','4H','5D','6S']).isStraight() == true
    assert new Hand(['AS','KC','QH','JD','TS']).isStraight() == true
    assert new Hand(['2S','3C','4H','5D','7S']).isStraight() == false
  }

  @Test
  public void should_determine_flush() {
    assert new Hand(['2S','3S','9S','TS','AS']).isFlush() == true
    assert new Hand(['2S','3C','4H','5D','7S']).isFlush() == false
  }

  @Test
  public void should_determine_straight_flush() {
    def hand = new Hand(['AS','KS','QS','JS','TS'])

    assert hand.isFlush() && hand.isStraight()
  }

  @Test
  public void should_assign_type() {
    checkRankAssignment(mockHighCard(), HighCard)
    checkRankAssignment(mockPair(), Pair)
    checkRankAssignment(mockTwoPair(), TwoPair)
    checkRankAssignment(mockThreeOfAKind(), ThreeOfAKind)
    checkRankAssignment(mockStraight(), Straight)
    checkRankAssignment(mockFlush(), Flush)
    checkRankAssignment(mockFourOfAKind(), FourOfAKind)
    checkRankAssignment(mockStraightFlush(), StraightFlush)
  }

  private checkRankAssignment(Hand hand, Class rank) {
    hand.assignType()
    assert hand.type.rank.class == rank
  }

  @Test
  public void should_get_high_card() {
    assert new Hand(['2S','3S','9S','TS','AS']).highCard.face == 'A'
    assert new Hand(['2S','3S','9S','TS','4S']).highCard.face == 'T'
  }

  @Test
  public void should_compare_to_hand() {
    checkComparison([0,0,0,0,0,0], [0,0,0,0,0,0], 0)
    checkComparison([1,0,0,0,0,0], [0,0,0,0,0,0], 1)
    checkComparison([0,0,0,0,0,0], [1,0,0,0,0,0], -1)
    checkComparison([1,1,0,0,0,0], [1,0,0,0,0,0], 1)
    checkComparison([1,1,1,0,0,0], [1,1,0,0,0,0], 1)
    checkComparison([1,1,1,1,0,0], [1,1,0,0,0,0], 1)
    checkComparison([1,1,1,1,1,0], [1,1,0,0,0,0], 1)
    checkComparison([1,1,1,1,1,1], [1,1,0,0,0,0], 1)
    checkComparison([1,5,0,0,0,0], [1,4,0,0,0,0], 1)
  }

  private void checkComparison(List mockStrength1, List mockStrength2, int expected) {
    def a = new Hand()
    a.metaClass.getStrength = { -> mockStrength1 }
      
    def b = new Hand()
    b.metaClass.getStrength = { -> mockStrength2 }
    
    assert a.compareTo(b) == expected
  }

  @Test
  public void should_get_string() {
    def hand

    hand = new Hand(['9H', 'JC', 'KC', '2S', 'TD'])
    checkString(hand, new HighCard(), 'KC JC TD 9H 2S (High Card: K)')

    hand = new Hand(['AH', 'AC', 'KC', '2S', 'TD'])
    checkString(hand, new Pair(), 'AH AC KC TD 2S (Pair: A)')
  }

  private def checkString(Hand h, IRank r, String expected) {
    h.assignType()
    assert h.toString() == expected
  }

  private def makeSet(List<String> str) {
    def set = [:]
    str.each { s ->
      set.put(s, [ new Card("${s}H"), new Card("${s}D") ])
    }
    set
  }
}