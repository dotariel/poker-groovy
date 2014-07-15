class Evaluator {
  public Hand choose(Hand a, Hand b) {
    [a,b].each { it.assignRank() }

    int comparison = a.compareTo(b)

    if (comparison > 0) return a
    if (comparison < 0) return b
  }
}
