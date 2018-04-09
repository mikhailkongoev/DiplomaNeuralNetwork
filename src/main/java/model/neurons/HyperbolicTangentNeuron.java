package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;

public class HyperbolicTangentNeuron extends Neuron {

    public HyperbolicTangentNeuron(double[] inputs) {
        super(inputs);
    }

    public HyperbolicTangentNeuron(SimpleMatrix inputs) {
        super(inputs);
    }

    @Override
    public double evaluateActivation() {
        return Math.tanh(evaluateSum());
    }

    @Override
    public double activationDerivative(int num) {
        return 0;
    }
}
