class Evaluator {

  protected static List<Rank> ranks

  static reset() {
    ranks = [
      new StraightFlush(),
      new FourOfAKind(),
      new FullHouse(),
      new Flush(),
      new Straight(),
      new ThreeOfAKind(),
      new TwoPair(),
      new Pair(), 
      new HighCard()
    ]
  }
  static {
    reset()
  }
 
  public Hand choose(Hand a, Hand b) {
    if (getRankVal(a) < getRankVal(b)) return a
    if (getRankVal(a) < getRankVal(b)) return b
    if (getRankVal(a) == getRankVal(b))
      return getRank(a).resolveTie(a, b)
  }

  private int getRankVal(Hand hand) {
    ranks.indexOf(getRank(hand))
  }

  private Rank getRank(Hand hand) {
    ranks.find { rank -> rank.evaluate(hand) }
  } 
}
