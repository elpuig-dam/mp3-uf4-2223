package setmana1;

public class Card {
    private int num;
    private String pal;

    public Card(int num, String pal) {
        this.num = num;
        this.pal = pal;
    }

    public Card() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    @Override
    public boolean equals(Object o) {
        Card card = (Card) o;
        if (this.num == card.num && this.pal.equals(card.getPal())) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (pal != null ? pal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carc{" +
                "num=" + num +
                ", pal='" + pal + '\'' +
                '}';
    }
}
