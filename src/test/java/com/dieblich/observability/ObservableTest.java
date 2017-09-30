package com.dieblich.observability;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservableTest {

    @Test
    void observerIsAdded() {
        TestObservable observableObject = new TestObservable();
        TestObserver observer = new TestObserver();

        observableObject.addObserver(observer);
        assertTrue(observableObject.getObservers().contains(observer));
    }

    @Test
    void observerIsNotifiedOnChange() {
        TestObservable observableObject = new TestObservable();
        TestObserver observer = new TestObserver();

        observableObject.addObserver(observer);
        observableObject.changeAttribute();

        assertTrue(observer.updatedObject.isPresent(), "nothing was updated");
        assertEquals(observableObject, observer.updatedObject.get(), "wrong object updated: " + observer.updatedObject.get());
    }

    @Test
    void allObserversAreNotifiedOnChange() {
        TestObservable observableObject = new TestObservable();
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();

        observableObject.addObserver(observer1);
        observableObject.addObserver(observer2);
        observableObject.changeAttribute();

        assertTrue(observer1.updatedObject.isPresent(), "nothing was updated for observer 1");
        assertEquals(observableObject, observer1.updatedObject.get(), "wrong object updated for observer 1: " + observer1.updatedObject.get());
        assertTrue(observer2.updatedObject.isPresent(), "nothing was updated for observer 2");
        assertEquals(observableObject, observer2.updatedObject.get(), "wrong object updated for observer 2: " + observer2.updatedObject.get());
    }

    class TestObservable implements Observable {
        void changeAttribute() {
            notifyObservers();
        }
    }

    class TestObserver implements Observer {
        @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
        Optional<Observable> updatedObject = Optional.empty();

        @Override
        public void update(Observable o) {
            updatedObject = Optional.of(o);
        }
    }

}