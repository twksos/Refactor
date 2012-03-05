import java.util.Vector;

class Customer {
    private String _name;


    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public Vector<Rental> getRentals() {
        return _rentals;
    }

    public String getName() {
        return _name;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

    double getTotalFrequentRenterPoints() {
        double total = 0;
        for (Rental rental : _rentals) {
            total += rental.getFrequentRenterPoints();
        }
        return total;
    }

    double getTotalCharge() {
        double total = 0;
        for (Rental rental : _rentals) {
            total += rental.getCharge();
        }
        return total;
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

}
