package com.example.demo;

import java.io.Serializable;

public class MovieMessage implements Serializable {
    private String from;
    private String to;
    private Movie Remove;

    public MovieMessage() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Movie getMovie() {
        return Remove;
    }

    public void setMovie(Movie ob) {
        this.Remove = ob;
    }
}
