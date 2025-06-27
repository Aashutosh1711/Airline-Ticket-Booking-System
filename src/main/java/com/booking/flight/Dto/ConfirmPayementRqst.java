package com.booking.flight.Dto;

public class ConfirmPayementRqst {
    private Long transactionId;

    ConfirmPayementRqst(){

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
