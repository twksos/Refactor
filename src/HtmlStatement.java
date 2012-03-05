import java.util.Enumeration;

public class HtmlStatement extends Statement {
    @Override
    public String value(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = headerString(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); //show figures for each rental
            result += eachRentalString(each);
        }

        result += footerString(customer);
        return result;
    }

    private String footerString(Customer customer) {
        return "<P>You owe <EM>" + String.valueOf(customer.getTotalCharge())
                + "</EM><P>\n"
                + "On this rental you earned <EM>" +
                String.valueOf(customer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    }

    private String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
    }

    private String headerString(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
