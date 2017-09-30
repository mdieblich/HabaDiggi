package com.dieblich.observability;

/**
 * This is an own implementation of the observer-pattern
 * <p>
 * This interface is compatible with the com.dieblich.observability.Observable-Interface
 */
public interface Observer {

    void update(Observable observable);
}
