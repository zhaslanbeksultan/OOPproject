package education;

import java.io.Serializable;

public class AttestationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private int firstHalf;
    private int secondHalf;

    public AttestationResult(int i, int j) {
        //for serialization 
    }

    public int getFirstHalf() {
        return firstHalf;
    }

    public void setFirstHalf(int firstHalf) {
        this.firstHalf = firstHalf;
    }

    public int getSecondHalf() {
        return secondHalf;
    }

    public void setSecondHalf(int secondHalf) {
        this.secondHalf = secondHalf;
    }
}
