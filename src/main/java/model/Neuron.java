package model;

import org.ejml.simple.SimpleMatrix;

import java.util.Random;

public abstract class Neuron {
    private SimpleMatrix inputs;
    private SimpleMatrix weights;

    public Neuron(double[] inputs) {
        this(inputs.length);
        double[][] inputsForSM = new double[1][inputs.length];
        inputsForSM[0] = inputs;
        setInputs(new SimpleMatrix(inputsForSM));
    }

    public Neuron(SimpleMatrix inputs) {
        this(inputs.numCols());
        setInputs(inputs);
    }

    public Neuron(int weightsSize) {
        Random r = new Random();
        double[][] weights = new double[weightsSize][1];
        for (int i = 0; i < weightsSize; i++) {
            weights[i][0] = (r.nextDouble() - 0.5) * 0.01;
        }
        setWeights(new SimpleMatrix(weights));
    }

    public void printSumResult() {
        System.out.println(evaluateSum());
    }

    public double evaluateSum() {
        return inputs.mult(weights).get(0, 0);
    }

    public void printActivationResult() {
        System.out.println(evaluateActivation());
    }

    public SimpleMatrix getInputs() {
        return inputs;
    }

    public void setInputs(SimpleMatrix inputs) {
        this.inputs = inputs;
    }

    public void setInputs(double[] inputs) {
        double[][] temp = new double[1][inputs.length];
        temp[0] = inputs;
        setInputs(new SimpleMatrix(temp));
    }

    public SimpleMatrix getWeights() {
        return weights;
    }

    public void setWeights(SimpleMatrix weights) {
        this.weights = weights;
    }

    public void printInputs() {
        inputs.print();
    }

    public void printWeights() {
        weights.print();
    }

    public abstract double evaluateActivation();

    public abstract double activationDerivative(int num);
}
