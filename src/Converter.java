public class Converter
{
    double stepLength = 0.75;
    double ccalForStep= 0.05;


    double convertDistance(int steps)
    {
        return (steps*stepLength)/100;
    }
    public double Ccal(int steps)
    {
        return steps*ccalForStep;
    }
}