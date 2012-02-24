import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("customer");
        Rental titanic3d = new Rental(new Movie("Titanic 3D",Movie.NEW_RELEASE),3);
        Rental seven = new Rental(new Movie("Seven",Movie.REGULAR),1);
        Rental happyTreeFriends = new Rental(new Movie("Happy Tree Friends",Movie.CHILDRENS),2);
        customer.addRental(titanic3d);
        customer.addRental(seven);
        customer.addRental(happyTreeFriends);
    }

    @Test
    public void test_should_get_statement() throws Exception {
        assertThat(customer.statement(), is("Rental Record for customer\n\tTitanic 3D\t9.0\n\tSeven\t2.0\n\tHappy Tree Friends\t1.5\nAmount owed is 12.5\nYou earned 4.0 frequent renter points"));
    }

    @Test
    public void test_should_get_htmlStatement() throws Exception {
        assertThat(customer.htmlStatement(), is("<H1>Rentals for <EM>customer</EM></H1><P>\nTitanic 3D: 9.0<BR>\nSeven: 2.0<BR>\nHappy Tree Friends: 1.5<BR>\n<P>You owe <EM>12.5</EM><P>\nOn this rental you earned <EM>4.0</EM> frequent renter points<P>"));
    }
}
