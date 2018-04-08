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

    public double evaluateActivation() {
        return Math.tanh(evaluateSum());
    }
}
