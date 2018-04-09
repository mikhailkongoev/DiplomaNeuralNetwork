package learning;

import model.IO;
import model.LossFunctions;
import model.Neuron;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class GradientEvaluator {
    /**
     * @param data
     * @param neuron
     * @param lossFunctions
     * @return Вектор градиента функции потерь (столбец)
     */
    public static SimpleMatrix findLossFuncGradient(List<IO> data, Neuron neuron, LossFunctions lossFunctions) {
        //TODO: добавить поддержку других функций ошибки.
        if (!lossFunctions.equals(LossFunctions.RMS)) {
            throw new IllegalArgumentException("На данный момент реализована поддержка только среднеквадратичной функции ошибки.");
        } if (data.isEmpty()) {
            throw new IllegalArgumentException("Массив входных данных пуст.");
        }
        //TODO: подумать над применением матричных вычислений, вынесение деления на n за знак суммы)
        double[] res = new double[data.get(0).getInput().length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < data.size(); j++) {
                IO currentIO = data.get(j);
                neuron.setInputs(currentIO.getInput());
                double lossFuncThisDerivative = neuron.evaluateActivation() - currentIO.getOutput();
                double neuronDerivative = neuron.activationDerivative(i);
                res[i] += lossFuncThisDerivative * neuronDerivative;
            }
            res[i] /= data.size();
        }
        double[][] resArray = new double[1][res.length];
        resArray[0] = res;
        SimpleMatrix resMatrix = new SimpleMatrix(resArray).transpose();
        return resMatrix;
    }

    public static SimpleMatrix findLossFuncGradient(List<IO> data, Neuron neuron) {
        return findLossFuncGradient(data, neuron, LossFunctions.RMS);
    }
}
