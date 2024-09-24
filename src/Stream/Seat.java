package Stream;

public record Seat(char rowMarked, int seatNumber, double price) {

    public Seat(char rowMarked, int seatNumber) {
        this(rowMarked, seatNumber,
                rowMarked > 'C' && (seatNumber <=2 ||
                         seatNumber >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        return "%c%03d %.0f".formatted(rowMarked, seatNumber,
                price);
    }
}
