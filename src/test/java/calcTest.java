import org.junit.Test;
import org.mockito.Mock;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class calcTest {

    double a = 10.0;
    double b = 5.0;
    double c = 0.0;

    calc defaultcalc = new calc(0);

    @Test
    public void 더하기테스트() {

        assertThat(defaultcalc.add(a, b), is((double) 15));
    }

    @Test
    public void 뺄셈테스트() {
        assertThat(defaultcalc.sub(a, b), is((double) 5));
    }

    @Test
    public void 곱셈테스트() {
        assertThat(defaultcalc.mul(a, b), is((double) 50));
    }

    @Test
    public void 나눗셈테스트() {
        assertThat(defaultcalc.div(a, b), is((double) 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 영으로나눈다() {
        assertThat(defaultcalc.div(a, c), is((double) 0));
    }
}