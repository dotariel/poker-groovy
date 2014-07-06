class RankTestMixin {
  void checkWinner(rank, winner, loser) {
    assert rank.compare(winner, loser) == winner
  }

  void checkVisit(hand, rank) {
    rank.newInstance().visit(hand)
    assert hand.rank?.class == rank
  }
}