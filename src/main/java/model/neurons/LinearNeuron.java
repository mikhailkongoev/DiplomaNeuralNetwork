package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;

public class LinearNeuron extends Neuron {

    public LinearNeuron(double[] inputs) {
        super(inputs);
    }

    public LinearNeuron(SimpleMatrix inputs) {
        super(inputs);
    }

    @Override
    public double evaluateActivation() {
        return evaluateSum();
    }

    @Override
    public double activationDerivative(int num) {
        return getInputs().get(0, num);
    }
}
