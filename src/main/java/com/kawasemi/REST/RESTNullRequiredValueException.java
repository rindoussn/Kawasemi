package com.kawasemi.REST;

/**
 * Created by suzuno on 7/3/17.
 */
public class RESTNullRequiredValueException extends Exception {
    public RESTNullRequiredValueException() {
        super();
    }

    public RESTNullRequiredValueException(String s) {
        super(s);
    }
}
