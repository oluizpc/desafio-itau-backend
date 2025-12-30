package desafio_vagaJr_itau.demo.dto;

import java.util.DoubleSummaryStatistics;

public class EstatiscasResponse {
    private long count;
    private double sum;
    private double avg; 
    private double max;
    private double min;

    public EstatiscasResponse(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }   

    public double getAverage() {
        return avg;
    }   

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}
