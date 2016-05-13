import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Vel'Koz on 5/10/16.
 */
public class SignalGenerator {

    private char[] signal;

    private int signalHeight = 256;

    protected SignalGenerator(){

        System.out.println("Usage: generate <length> (height)");

    }


    protected SignalGenerator(int signalLength){
        this.signal = new char[signalLength];
        generate();
    }

    protected SignalGenerator(int signalLength, int signalHeight){
        this.signalHeight = signalHeight;
        this.signal = new char[signalLength];
        generate();
    }

    private void generate(){
        Random signalGen = new Random(System.nanoTime());
        for (int signalLocation = 0; signalLocation < signal.length; signalLocation++){
            signal[signalLocation] = (char) ((signalGen.nextInt(signalHeight)) + 32);
        }
    }

    public char[] returnGeneratedSignal(){
        return signal;
    }


}
