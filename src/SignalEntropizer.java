/**
 * Created by Vel'Koz.
 */
public class SignalEntropizer {
    private double entropy = 0;
    private double totalEntropy = 0;
    private double percentEntropy = 0;

    protected SignalEntropizer() {

    }


    protected SignalEntropizer(String signal) {
        detectEntropyInByte(signal.getBytes());
    }

    protected SignalEntropizer(byte[] signal) {
        detectEntropyInByte(signal);

    }

    private void detectEntropyInByte(byte[] signal) {

        int[] signalCounts = new int[256];
        for (int signalLocation = 0; signalLocation < signal.length; signalLocation++){
            signalCounts[signal[signalLocation]]++;
        }

        for (int signalStrength = 0; signalStrength < 256; signalStrength++){
            if (signalCounts[signalStrength] != 0){
                Double signalFrequency = (double) signalCounts[signalStrength] / (double) signal.length;
                entropy -= signalFrequency * Math.log(signalFrequency) / Math.log(2.0);
            }
        }

        System.out.println(entropy);
        percentEntropy = 100 * entropy / 8;
        totalEntropy = entropy * signal.length;

    }


    public double getAverageSignalEntropy() {
        return entropy;
    }

    public double getTotalSignalEntropy() {
        return totalEntropy;
    }

    public double getPercentSignalEntropy() {
        return percentEntropy;
    }


}
