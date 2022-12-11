package com.revature;

import java.util.Objects;

public class Lab {
    private String labName;
    private int numOfTests;
    private int numOfTestsPassed;
    private int numOfTestsFailed;
    private double percentCompleted;


    public Lab() {
    }

    public Lab(String labName, int numOfTests, int numOfTestsPassed, int numOfTestsFailed, double percentCompleted) {
        this.labName = labName;
        this.numOfTests = numOfTests;
        this.numOfTestsPassed = numOfTestsPassed;
        this.numOfTestsFailed = numOfTestsFailed;
        this.percentCompleted = percentCompleted;
    }

    public String getLabName() {
        return this.labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getNumOfTests() {
        return this.numOfTests;
    }

    public void setNumOfTests(int numOfTests) {
        this.numOfTests = numOfTests;
    }

    public int getNumOfTestsPassed() {
        return this.numOfTestsPassed;
    }

    public void setNumOfTestsPassed(int numOfTestsPassed) {
        this.numOfTestsPassed = numOfTestsPassed;
    }

    public int getNumOfTestsFailed() {
        return this.numOfTestsFailed;
    }

    public void setNumOfTestsFailed(int numOfTestsFailed) {
        this.numOfTestsFailed = numOfTestsFailed;
    }

    public double getPercentCompleted() {
        return this.percentCompleted;
    }

    public void setPercentCompleted(double percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    public Lab labName(String labName) {
        setLabName(labName);
        return this;
    }

    public Lab numOfTests(int numOfTests) {
        setNumOfTests(numOfTests);
        return this;
    }

    public Lab numOfTestsPassed(int numOfTestsPassed) {
        setNumOfTestsPassed(numOfTestsPassed);
        return this;
    }

    public Lab numOfTestsFailed(int numOfTestsFailed) {
        setNumOfTestsFailed(numOfTestsFailed);
        return this;
    }

    public Lab percentCompleted(double percentCompleted) {
        setPercentCompleted(percentCompleted);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lab)) {
            return false;
        }
        Lab lab = (Lab) o;
        return Objects.equals(labName, lab.labName) && numOfTests == lab.numOfTests && numOfTestsPassed == lab.numOfTestsPassed && numOfTestsFailed == lab.numOfTestsFailed && percentCompleted == lab.percentCompleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(labName, numOfTests, numOfTestsPassed, numOfTestsFailed, percentCompleted);
    }

    @Override
    public String toString() {
        return "{" +
            " labName='" + getLabName() + "'" +
            ", numOfTests='" + getNumOfTests() + "'" +
            ", numOfTestsPassed='" + getNumOfTestsPassed() + "'" +
            ", numOfTestsFailed='" + getNumOfTestsFailed() + "'" +
            ", percentCompleted='" + getPercentCompleted() + "'" +
            "}";
    }

    
}
