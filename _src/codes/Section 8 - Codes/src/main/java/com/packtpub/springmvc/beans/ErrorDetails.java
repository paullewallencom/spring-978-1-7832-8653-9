package com.packtpub.springmvc.beans;

public class ErrorDetails {
    public final String url;
    public final String ex;

    public ErrorDetails(String url, Exception e) {
        this.url = url;
        this.ex = e.getLocalizedMessage();
    }
}