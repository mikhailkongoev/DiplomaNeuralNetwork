package learning;

import model.IO;
import model.Network;
import model.Neuron;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class Teacher {
    private static final double LOW_LEVEL = 0.01;
    private static final double LERNING_RATE = 0.001;

    public static Network applyBackpropagation(Network network, List<IO> data) {
        //TODO: add implementation of applyBackpropagation(Network network, double[] input)
        return network;
    }


    //TODO: добавить лучший подбор learning rate и выбор критерия останова (к примеру, по величине вектора, а не поэлементно)
    public static Neuron applyGradientMethod(Neuron neuron, List<IO> data) {
        int size = neuron.getWeights().numRows();
        double[][] learningRateArray = new double[size][1];
        for (int i = 0; i < size; i++) {
            learningRateArray[i][0] = LERNING_RATE;
        }
        SimpleMatrix learningRateMatrix = new SimpleMatrix(learningRateArray);

        SimpleMatrix lossFuncGradient = GradientEvaluator.findLossFuncGradient(data, neuron);
        SimpleMatrix weights = neuron.getWeights();
        while (!meetStopCriterion(lossFuncGradient)) {
            weights = weights.plus(lossFuncGradient.negative().elementMult(learningRateMatrix));
            lossFuncGradient = GradientEvaluator.findLossFuncGradient(data, neuron);
        }
        return neuron;
    }

    private static boolean meetStopCriterion(SimpleMatrix lossFuncGradient) {
        for (int i = 0; i < lossFuncGradient.numRows(); i++) {
            if (lossFuncGradient.get(i, 0) > LOW_LEVEL) {
                return false;
            }
        }
        return true;
    }
}
