package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;

public class Perceptron extends Neuron {

    public Perceptron(double[] inputs) {
        super(inputs);
    }

    public Perceptron(SimpleMatrix inputs) {
        super(inputs);
    }

    public double evaluateActivation() {
        if (evaluateSum() >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
