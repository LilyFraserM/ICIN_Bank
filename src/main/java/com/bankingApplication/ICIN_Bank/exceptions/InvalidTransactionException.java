package com.bankingApplication.ICIN_Bank.exceptions;

/**
 * Exception thrown when the bank transactio is invalid
 *
 */
public class InvalidTransactionException extends RuntimeException {

    public InvalidTransactionException(String message) {
        super(message);
    }
}
