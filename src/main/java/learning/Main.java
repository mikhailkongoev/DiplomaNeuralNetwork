package learning;

import dataProviding.InputSignalGenerator;
import model.Layer;
import model.Network;
import model.Neuron;
import model.neurons.LinearNeuron;
import model.neurons.SigmoidNeuron;
import org.apache.commons.math3.complex.Complex;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Network network = createNetwork();
    }

    private static void demo() {
        InputSignalGenerator inputSignalGenerator = new InputSignalGenerator();
        Complex[] inputs = new Complex[883];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new Complex(0, 0);
        }
        inputs[3] = new Complex(10000, 0);
        SimpleMatrix data = inputSignalGenerator.generateSignal(inputs);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            Neuron neuron = new LinearNeuron(data);
            neuron.printSumResult();
            neuron.printActivationResult();
            System.out.println();
        }
        System.out.println(count);
    }

    private static Network createNetwork() {
        List<Neuron> firstLayerNeurons = new ArrayList<Neuron>(100);
        List<Neuron> secondLayerNeurons = new ArrayList<Neuron>(10);
        List<Neuron> lastLayerNeurons = new ArrayList<Neuron>(1);

        for (int i = 0; i < 100; i++) {
            firstLayerNeurons.add(new SigmoidNeuron(883));
        }

        for (int i = 0; i < 10; i++) {
            secondLayerNeurons.add(new SigmoidNeuron(firstLayerNeurons.size()));
        }

        lastLayerNeurons.add(new SigmoidNeuron(secondLayerNeurons.size()));

        Layer firstLayer = new Layer(firstLayerNeurons);
        Layer secondLayer = new Layer(secondLayerNeurons);
        Layer lastLayer = new Layer(lastLayerNeurons);
        List<Layer> layers = new ArrayList<Layer>(Arrays.asList(firstLayer, secondLayer, lastLayer));

        return new Network(layers);
    }
}
