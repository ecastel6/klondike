package models;

public enum CardSuit {
    PICA, CORAZON, DIAMANTE, TREBOL;

    public Color getColor() {
        if (this.name().equals(PICA) || this.name().equals(TREBOL)) {
            return Color.NEGRO;
        } else {
            return Color.ROJO;
        }
    }
}
