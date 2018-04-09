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

    public ReLU(int weightsSize) { super(weightsSize); }


    @Override
    public double evaluateActivation() {
        if (evaluateSum() >= 0) {
            return evaluateSum();
        }
        return 0;
    }

    @Override
    public double activationDerivative(int num) {
        return 0;
    }
}
