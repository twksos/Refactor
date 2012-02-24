import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriceTest {
    @Test
    public void test_getCharge_of_NewReleasePrice_with_1_daysRented_should_return_3() throws Exception {
        assertThat(new NewReleasePrice().getCharge(1), is(3.0));
    }
    @Test
    public void test_getCharge_of_ChildrensPrice_with_0_daysRented_should_return_3() throws Exception {
        assertThat(new ChildrensPrice().getCharge(0), is(1.5));
    }
    @Test
    public void test_getCharge_of_ChildrensPrice_with_3_daysRented_should_return_3() throws Exception {
        assertThat(new ChildrensPrice().getCharge(3), is(1.5));
    }
    @Test
    public void test_getCharge_of_ChildrensPrice_with_4_daysRented_should_return_3() throws Exception {
        assertThat(new ChildrensPrice().getCharge(4), is(3.0));
    }

    @Test
    public void test_getCharge_of_RegularPrice_with_0_daysRented_should_return_3() throws Exception {
        assertThat(new RegularPrice().getCharge(0), is(2.0));
    }
    @Test
    public void test_getCharge_of_RegularPrice_with_2_daysRented_should_return_3() throws Exception {
        assertThat(new RegularPrice().getCharge(2), is(2.0));
    }
    @Test
    public void test_getCharge_of_RegularPrice_with_3_daysRented_should_return_3() throws Exception {
        assertThat(new RegularPrice().getCharge(3), is(3.5));
    }
}
