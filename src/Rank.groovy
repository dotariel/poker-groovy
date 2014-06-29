interface Rank {
  boolean evaluate(Hand hand);
  Hand resolveTie(Hand a, Hand b);
}