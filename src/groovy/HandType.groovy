public enum HandType {
  STRAIGHT_FLUSH  (8, new StraightFlush()),
  FOUR_OF_A_KIND  (7, new FourOfAKind()),
  FULL_HOUSE      (6, new FullHouse()),
  FLUSH           (5, new Flush()),
  STRAIGHT        (4, new Straight()),
  THREE_OF_A_KIND (3, new ThreeOfAKind()),
  TWO_PAIR        (2, new TwoPair()),
  PAIR            (1, new Pair()),
  HIGH_CARD       (0, new HighCard())

  private int value
  private IRank rank

  private HandType(int value, IRank rank) {
    this.value = value
    this.rank = rank
  }

  public int getValue() {
    this.value
  }

  public IRank getRank() {
    this.rank
  }

  public static IRank firstMatchingRank(Closure c) {
    this.values().collect { it.rank }.find(c)
  }

  public static HandType findByRank(IRank rank) {
    this.values().find { it.rank.class == rank.class }
  }
}