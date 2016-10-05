//: interfaces/filters/BandPass.java
package interfaces.filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCutoff, double highCutoff) {
        lowCutoff = lowCutoff;
        highCutoff = highCutoff;
    }
    public Waveform process(Waveform input) {
        return input;
    }
}
