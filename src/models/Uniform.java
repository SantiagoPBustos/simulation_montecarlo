package models;

import java.util.ArrayList;
import java.util.List;

public class Uniform {
    private int quantity;
    private List<Double> aleatory;

    public Uniform(int quantity) {
        this.quantity = quantity;
        this.aleatory = new ArrayList<Double>();
    }

    public List<Double> getAleatory() {
        this.generateRandom();
        return this.aleatory;
    }

    private void generateRandom() {
        while (this.quantity > 0) {
            this.aleatory.add(Math.random());
            --this.quantity;
        }

    }
}
