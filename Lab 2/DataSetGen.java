import java.util.Formatter;

public class DataSetGen <t>{
    private double sum;
    private Measurable maximum;
    private int count;

    public DataSetGen(){

    }

    public void add(Measurable x){
        sum += x.getMeasure();
        if (count == 0 || maximum.getMeasure() < x.getMeasure())
            maximum = x;
        count++;
    }

    public double getAverage()
    {
        if (count == 0) return 0;
        else return sum / count;
    }

    public t getMaximum()
    {
        return (t) maximum;
    }

}
