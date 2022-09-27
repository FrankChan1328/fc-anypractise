package lot2.entity;

import java.util.List;

public class NumProbability {
    private int num;
    private Double probability;
    private List<NumProbability> nextPros;

    public NumProbability(int num, Double probability) {
        this.num = num;
        this.probability = probability;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public List<NumProbability> getNextPros() {
        return nextPros;
    }

    public void setNextPros(List<NumProbability> nextPros) {
        this.nextPros = nextPros;
    }
}
