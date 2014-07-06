class Evaluator {
  protected static List<Rank> ranks = [
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
  
  public Hand choose(Hand a, Hand b) {
    [a,b].each { assignRank(it) }

    if (a.rank == b.rank) 
      return a.rank.compare(a,b)

    if (rVal(a.rank) < rVal(b.rank)) return a
    if (rVal(a.rank) > rVal(b.rank)) return b
  }

  public Hand chooseWinner(Hand a, Hand b) {
    for (int i=0; i<a.strength.size() ; i++) {
      if (a.strength[i] > b.strength[i]) return a
      if (a.strength[i] < b.strength[i]) return b
    }
  }

  private void assignRank(Hand hand) {
    ranks.find { rank -> rank.visit(hand) }
  }

  private int rVal(Rank r) {
    ranks.indexOf(r)
  }
}
