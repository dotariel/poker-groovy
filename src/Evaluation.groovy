class Evaluation {
  Hand winner
  Rank rank

  public Evaluation(winner, rank) {
    this.winner = winner
    this.rank = rank
  }

  public String toString() {
    "Winner: ${winner} (${rank})"
  }
}