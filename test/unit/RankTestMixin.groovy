class RankTestMixin {
  void checkWinner(rank, winner, loser) {
    assert rank.resolveTie(winner, loser) == winner
  }
}