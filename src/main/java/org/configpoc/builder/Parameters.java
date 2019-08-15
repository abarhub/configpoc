package org.configpoc.builder;

public class Parameters {

    private boolean exceptionOnMissingProperty;

    public Parameters() {
    }

    public Parameters(Parameters parameters) {
        this.exceptionOnMissingProperty=parameters.exceptionOnMissingProperty;
    }

    public boolean isExceptionOnMissingProperty() {
        return exceptionOnMissingProperty;
    }

    public void setExceptionOnMissingProperty(boolean exceptionOnMissingProperty) {
        this.exceptionOnMissingProperty = exceptionOnMissingProperty;
    }
}
