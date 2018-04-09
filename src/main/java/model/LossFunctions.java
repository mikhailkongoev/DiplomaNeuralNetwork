package model;

import java.util.List;

public enum LossFunctions {
    RMS;

    public static double findLosses(Network network, List<IO> data) {
        return findLosses(network, data, LossFunctions.RMS);
    }

    public static double findLosses(Network network, List<IO> data, LossFunctions lossFunctions) {
        double res = 0;
        switch (lossFunctions) {
            case RMS:
                for (IO io : data) {
                    network.setInputs(io.getInput());
                    res += Math.pow(network.evaluate() - io.getOutput(), 2);
                }
                res /= (2 * data.size());
        }
        return res;
    }
}
