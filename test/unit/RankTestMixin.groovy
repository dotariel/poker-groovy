class RankTestMixin {

  public Hand mockHighCard() {
    new Hand(['9H', 'JC', 'KC', '2S', 'TD'])
  }

  public Hand mockPair() {
    new Hand(['9H', 'JC', 'KC', '2S', '9D'])
  }

  public Hand mockTwoPair() {
    new Hand(['AH', 'AD', 'KC', '2S', '2D'])
  }

  public Hand mockThreeOfAKind() {
    new Hand(['AH', 'AD', 'KC', 'AS', '9D'])
  }

  public Hand mockStraight() {
    new Hand(['4H', '5D', '6C', '7S', '8D'])
  }

  public Hand mockFlush() {
    new Hand(['2H', '4H', '6H', '8H', 'TH'])
  }

  public Hand mockFullHouse() {
    new Hand(['2H', '2D', '2S', '7D', '7H'])
  }

  public Hand mockFourOfAKind() {
    new Hand(['2H', '2D', '2S', '2C', '7H'])
  }

  public Hand mockStraightFlush() {
    new Hand(['4H', '5H', '6H', '7H', '8H'])
  }

  void checkVisit(hand, rank) {
    rank.newInstance().visit(hand)
    assert hand.rank?.class == rank
  }
}