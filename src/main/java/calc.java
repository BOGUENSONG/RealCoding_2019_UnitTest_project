import lombok.AllArgsConstructor;

@AllArgsConstructor
public class calc {

    private double temp; //계산결과를 임시 저장하는곳
    public double getTemp()
    {
        return this.temp;
    }
    public void setTemp(double t)
    {
        this.temp = t;
    }

    public double sub(double a , double b) //빼기
    {
        return a - b;
    }

    public double mul(double a , double b) //곱하기
    {
        return a*b;
    }

    public double add(double a , double b) //더하기
    {
        return a+b;
    }

    public double div(double a, double b)
    {
        if (b == 0)
        {
            throw new IllegalArgumentException();
        }
        return a/b;

    }
}
