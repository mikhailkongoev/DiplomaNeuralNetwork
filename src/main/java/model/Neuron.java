package model;

import org.ejml.simple.SimpleMatrix;

import java.util.Random;

public abstract class Neuron {
    SimpleMatrix inputs;
    SimpleMatrix weights;
    double realResult;

    public Neuron(double[] inputs) {
        Random r = new Random();
        double[][] inputsForSM = new double[1][inputs.length];
        System.arraycopy(inputs, 0, inputsForSM[0], 0, inputs.length);
        setInputs(new SimpleMatrix(inputsForSM));
        double[][] weights = new double[inputs.length][1];
        for (int i = 0; i < inputs.length; i++) {
            weights[i][0] = (r.nextDouble() - 0.5) * 0.01;
        }
        setWeights(new SimpleMatrix(weights));
    }

    public Neuron(SimpleMatrix inputs) {
        setInputs(inputs);
        Random r = new Random();
        double[][] weights = new double[inputs.numCols()][1];
        for (int i = 0; i < inputs.numCols(); i++) {
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

    public SimpleMatrix getWeights() {
        return weights;
    }

    public void setWeights(SimpleMatrix weights) {
        this.weights = weights;
    }

    public double getRealResult() {
        return realResult;
    }

    public void setRealResult(double realResult) {
        this.realResult = realResult;
    }

    public void printInputs() {
        inputs.print();
    }

    public void printWeights() {
        weights.print();
    }

    public abstract double evaluateActivation();
}
