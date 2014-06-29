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
    assignRank(a)
    assignRank(b)

    if (a.rank == b.rank) 
      return a.rank.compare(a,b)

    if (rVal(a.rank) < rVal(b.rank)) return a
    if (rVal(a.rank) > rVal(b.rank)) return b
  }

  private void assignRank(Hand hand) {
    ranks.find { rank -> rank.visit(hand) }
  }

  private int rVal(Rank r) {
    ranks.indexOf(r)
  }
}
