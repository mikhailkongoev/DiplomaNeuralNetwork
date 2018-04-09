package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;

public class SoftPlus extends Neuron {

    public SoftPlus(double[] inputs) {
        super(inputs);
    }

    public SoftPlus(SimpleMatrix inputs) {
        super(inputs);
    }

    @Override
    public double evaluateActivation() {
        return Math.log(1 + Math.exp(evaluateSum()));
    }

    @Override
    public double activationDerivative(int num) {
        return 0;
    }
}
