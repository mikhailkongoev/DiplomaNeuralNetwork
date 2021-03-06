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

    public Perceptron(int weightsSize) { super(weightsSize); }

    @Override
    public double evaluateActivation() {
        if (evaluateSum() >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public double activationDerivative(int num) {
        return 0;
    }
}
