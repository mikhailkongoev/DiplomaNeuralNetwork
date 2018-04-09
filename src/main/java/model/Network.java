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
        //TODO: add implementation network.setInputs(double[] inputs)
    }

    public void setInputs(SimpleMatrix inputs) {
        //TODO: add implementation network.setInputs(double[] inputs)
    }

    public double evaluate() {
        //TODO: add implementation network.evaluate(double[] signal)
        return 0;
    }
}
