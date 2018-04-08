package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;
import org.apache.commons.math3.analysis.function.Sigmoid;

public class SigmoidNeuron extends Neuron {
    Sigmoid sigmoid = new Sigmoid();

    public SigmoidNeuron(double[] inputs) {
        super(inputs);
    }

    public SigmoidNeuron(SimpleMatrix inputs) {
        super(inputs);
    }

    public double evaluateActivation() {
        return sigmoid.value(evaluateSum());
    }
}
