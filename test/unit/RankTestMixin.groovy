class RankTestMixin {
  void checkVisit(hand, rank) {
    rank.newInstance().visit(hand)
    assert hand.rank?.class == rank
  }
}