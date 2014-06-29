class RankTestMixin {
  void checkWinner(rank, winner, loser) {
    assert rank.compare(winner, loser) == winner
  }

  void checkTie(rank, winner, loser) {
    assert rank.compare(winner, loser) == null
  }

  void checkVisit(hand, rank) {
    rank.newInstance().visit(hand)
    assert hand.rank?.class == rank
  }
}