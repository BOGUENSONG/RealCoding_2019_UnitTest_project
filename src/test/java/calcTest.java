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
    public void 더하기테스트()
    {

        assertThat(defaultcalc.add(a,b), is((double)15));
    }
    @Test
    public void 뺄셈테스트()
    {
        assertThat(defaultcalc.sub(a,b),is((double)5));
    }

    @Test
    public void 곱셈테스트()
    {
        assertThat(defaultcalc.mul(a,b),is((double)50));
    }

    @Test
    public void 나눗셈테스트()
    {
        assertThat(defaultcalc.div(a,b),is((double)2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 영으로나눈다()
    {
        assertThat(defaultcalc.div(a,c),is((double)0));
    }

    @Test
    public void temp100으로설정하기()
    {
        calc nump = mock(calc.class);
        nump.setTemp(100);
        verify(nump).setTemp(100);
    }

    @Test
    public void 더하기두번했는지()
    {
        calc nump = mock(calc.class);
        nump.add(4,5);
        nump.add(4,5);
        verify(nump,times(2)).add(4,5);
    }

    @Test
    public void 더하기_절대호출되면안됨()
    {
        calc nump = mock(calc.class);
        verify(nump,never()).add(4,5);//add4,5함수가 실행되면안됨.
    }

    @Test
    public void 곱하기_최소한번이상실행()
    {
        calc nump = mock(calc.class);
        nump.setTemp(nump.mul(a,b));

        verify(nump,atLeastOnce()).mul(a,b);
    }

    @Mock
    calc nump;
    @Test
    public void 이백마이크로세컨드이내에실행()
    {
        calc nump = mock(calc.class);
        nump.setTemp(10);
        verify(nump,timeout(200).atLeast(1)).setTemp(10);
    }




}