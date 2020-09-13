package com.raitonbl.fromdocs;

public class FromDocsException extends RuntimeException{

    public FromDocsException() {
    }

    public FromDocsException(String message) {
        super(message);
    }

    public FromDocsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FromDocsException(Throwable cause) {
        super(cause);
    }

}
