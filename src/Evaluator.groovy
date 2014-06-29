class Evaluator {

  static List<Rank> ranks = [
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
    if ( ranks.indexOf(getRank(a)) < ranks.indexOf(getRank(b)) )
      return a

    if ( ranks.indexOf(getRank(a)) < ranks.indexOf(getRank(b)) )
      return b

    if ( ranks.indexOf(getRank(a)) == ranks.indexOf(getRank(b)) ) {
      return getRank(a).resolveTie(a, b)
    }
  }

  private Rank getRank(Hand hand) {
    ranks.find { rank -> rank.evaluate(hand) }
  } 
}
