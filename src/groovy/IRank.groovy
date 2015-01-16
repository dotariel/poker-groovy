interface IRank {
  boolean visit(Hand h)
  List getStrength(Hand h)
}