package model.neurons;

import model.Neuron;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.ejml.simple.SimpleMatrix;

public class SigmoidNeuron extends Neuron {
    private Sigmoid sigmoid = new Sigmoid();

    public SigmoidNeuron(double[] inputs) {
        super(inputs);
    }

    public SigmoidNeuron(SimpleMatrix inputs) {
        super(inputs);
    }

    @Override
    public double evaluateActivation() {
        return sigmoid.value(evaluateSum());
    }

    @Override
    public double activationDerivative(int num) {
        return 0;
    }
}
