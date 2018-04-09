package model;

import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class Layer {
    private List<Neuron> neurons;

    public Layer(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public SimpleMatrix evaluate(SimpleMatrix inputs) {
        double[] res = new double[neurons.size()];
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).setInputs(inputs);
            res[i] = inputs.mult(neurons.get(i).getWeights()).get(0, 0);
        }
        double[][] resArray = new double[1][neurons.size()];
        resArray[0] = res;
        return new SimpleMatrix(resArray);
    }

}
