class Card {

  static List suits = ['C','H','D','S']

  static Map values = [
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    'T': 10,
    'J': 11,
    'Q': 12,
    'K': 13,
    'A': 14 
  ]

  private String card

  public Card(String card) {
    if (!(card ==~ /[2-9KTQJA]{1}[CDSH]{1}/)) // AH, 2C, 9D, etc
      throw new IllegalArgumentException()
    
    this.card = card
  }

  public String getFace() {
    card[0]
  }

  public String getSuit() {
    card[1]
  }

  public int getValue() {
    values[face]
  }

  @Override
  public String toString() {
    card
  }
}
