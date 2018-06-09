package lab8;

public class SequenceBuilder {

    private static int sequence = 0;

    public static int nextSequence(){
        SequenceBuilder.sequence++;
        return SequenceBuilder.sequence;
    }
}
