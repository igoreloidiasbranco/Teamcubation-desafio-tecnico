package com.tecnico.desafio.dto;

public class EstatisticaDTO {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public Long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    public void setSum(Double sum) {
        this.sum = sum;
    }


    public void setAvg(Double avg) {
        this.avg = avg;
    }


    public void setMin(Double min) {
        this.min = min;
    }


    public void setMax(Double max) {
        this.max = max;
    }
}
