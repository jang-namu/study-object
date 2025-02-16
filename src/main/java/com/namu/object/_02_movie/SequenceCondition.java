package com.namu.object._02_movie;

public class SequenceCondition implements DiscountCondition {
    public int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
