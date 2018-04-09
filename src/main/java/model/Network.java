package model;

import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class Network {
    //Слой входных активаций здесь не представлен.
    private List<Layer> layers;
    private SimpleMatrix inputs;

    public Network(List<Layer> layers) {
        this.layers = layers;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public void setInputs(double[] inputs) {
        double[][] inputsArray = new double[1][inputs.length];
        inputsArray[0] = inputs;
        this.inputs = new SimpleMatrix(inputsArray);
    }

    public void setInputs(SimpleMatrix inputs) {
        this.inputs = inputs;
    }

    public SimpleMatrix evaluate() {
        for (Layer layer: layers) {
            inputs = layer.evaluate(inputs);
        }
        return inputs;
    }
}
