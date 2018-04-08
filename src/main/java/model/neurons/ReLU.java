package model.neurons;

import model.Neuron;
import org.ejml.simple.SimpleMatrix;

public class ReLU extends Neuron {

    public ReLU(double[] inputs) {
        super(inputs);
    }

    public ReLU(SimpleMatrix inputs) {
        super(inputs);
    }

    public double evaluateActivation() {
        if (evaluateSum() >= 0) {
            return evaluateSum();
        }
        return 0;
    }
}
