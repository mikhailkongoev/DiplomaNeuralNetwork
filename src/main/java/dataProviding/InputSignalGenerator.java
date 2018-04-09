package dataProviding;

import org.apache.commons.math3.complex.Complex;
import org.ejml.simple.SimpleMatrix;

public class InputSignalGenerator {

    /**
     * @param amplitudes        Amplitudes of fundamental tone and harmonics in dB
     * @param frameDuration     Size of signal frame in mills
     * @param samplingFrequency Sampling frequency in Hz
     * @return
     */
    public SimpleMatrix generateSignal(Complex[] amplitudes, int frameDuration, int samplingFrequency) {
        if (amplitudes.length != frameDuration * samplingFrequency / 1000) {
            throw new IllegalArgumentException("Размерность массива входного сигнала не соответствует выбранным длине фрейма и частоте дискретизации.");
        }
        double[] signal = new double[amplitudes.length + 1];
        //bias
        signal[0] = 1;

        for (int i = 0; i < signal.length; i++) {
            Complex value = new Complex(0, 0);
            for (int j = 0; j < amplitudes.length; j++) {
                value = value.add(amplitudes[j].multiply(new Complex(0, (2 * Math.PI * i * j) / amplitudes.length).exp()));
            }
            value = value.divide(amplitudes.length);
            signal[i + 1] = value.getReal();
        }

        double[][] signalArray = new double[1][signal.length];
        signalArray[0] = signal;
        return new SimpleMatrix(signalArray);
    }

    public SimpleMatrix generateSignal(Complex[] amplitudes) {
        return generateSignal(amplitudes, 20, 44100);
    }

    public void printSignal(double[] signal) {
        for (int i = 0; i < signal.length; i++) {
            System.out.print(i);
            System.out.print(" ");
            System.out.printf("%f", signal[i]);
            System.out.println();
        }
    }
}
