import java.util.Enumeration;

public class TextStatement extends Statement {
    @Override
    public String value(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = headerString(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); //show figures for this rental
            result += eachRentalString(each);
        }

        result += footerString(customer);
        return result;
    }

     String footerString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalCharge())
                + "\n" + "You earned " +
                String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

     String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" +
                String.valueOf(each.getCharge()) + "\n";
    }

     String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
