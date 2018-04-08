package learning;

import dataProviding.InputSignalGenerator;
import model.Neuron;
import model.neurons.LinearNeuron;
import org.apache.commons.math3.complex.Complex;

public class Main {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        InputSignalGenerator inputSignalGenerator = new InputSignalGenerator();
        Complex[] inputs = new Complex[882];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new Complex(0, 0);
        }
        inputs[2] = new Complex(10000, 0);
        double data[] = inputSignalGenerator.generateSignal(inputs);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            Neuron neuron = new LinearNeuron(data);
            neuron.printSumResult();
            neuron.printActivationResult();
            System.out.println();
        }
        System.out.println(count);
    }
}
