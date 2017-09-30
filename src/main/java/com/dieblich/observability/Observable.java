package com.dieblich.observability;

import java.util.*;

/**
 * This is an own implementation of the observable-pattern
 * <p>
 * It can be directly used as an interface and no methods need to be overwritten
 *
 * @author Martin Dieblich
 * @date 30.09.2017
 */
public interface Observable {

    /* TODO: make private with Java9 */
    Map<Integer, List<Observer>> observerForAllObjects = new HashMap<>();

    default void addObserver(Observer observer) {
        int objectIdentity = System.identityHashCode(this);
        if (observerForAllObjects.containsKey(objectIdentity)) {
            observerForAllObjects.get(objectIdentity).add(observer);
        } else {
            List<Observer> observers = new ArrayList<>();
            observers.add(observer);
            observerForAllObjects.put(objectIdentity, observers);
        }
    }

    default List<Observer> getObservers() {
        int objectIdentity = System.identityHashCode(this);
        List<Observer> observers = observerForAllObjects.getOrDefault(objectIdentity, new ArrayList<>());
        return Collections.unmodifiableList(observers);
    }

    default void notifyObservers() {
        int objectIdentity = System.identityHashCode(this);
        for (Observer observer : observerForAllObjects.getOrDefault(objectIdentity, new ArrayList<>())) {
            observer.update(this);
        }
    }
}
