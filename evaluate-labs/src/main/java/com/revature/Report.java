package com.revature;

import java.util.List;
import java.util.Objects;

public class Report {
    private String username;
    private double progressPercentage;
    private List<Lab> labs;


    public Report() {
    }

    public Report(String username, double progressPercentage, List<Lab> labs) {
        this.username = username;
        this.progressPercentage = progressPercentage;
        this.labs = labs;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getProgressPercentage() {
        return this.progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public List<Lab> getLabs() {
        return this.labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }

    public Report username(String username) {
        setUsername(username);
        return this;
    }

    public Report progressPercentage(double progressPercentage) {
        setProgressPercentage(progressPercentage);
        return this;
    }

    public Report labs(List<Lab> labs) {
        setLabs(labs);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Report)) {
            return false;
        }
        Report report = (Report) o;
        return Objects.equals(username, report.username) && progressPercentage == report.progressPercentage && Objects.equals(labs, report.labs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, progressPercentage, labs);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", progressPercentage='" + getProgressPercentage() + "'" +
            ", labs='" + getLabs() + "'" +
            "}";
    }

}
