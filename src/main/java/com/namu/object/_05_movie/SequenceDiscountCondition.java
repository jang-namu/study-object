package com.namu.object._05_movie;


public class SequenceDiscountCondition implements DiscountCondition {
    private int sequence;

    public SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    private boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }

}
