package ir.javacup.traffic;

import ir.javacup.traffic.impl.TrafficObservable;

import java.util.List;

public class Context<T, I> {

    Observable observable;
    Transformer transformer;


    public Context observable(Observable observable) {
        this.observable = observable;
        return this;
    }

    public Context transformer(Transformer transformer) {
        this.transformer = transformer;
        return this;
    }

    public Context subscriber(Subscriber subscriber) {
        observable.subscribe(subscriber);
        return this;
    }

    public void run(List<I> list) {
        for (I i : list) {
            observable.push(transformer.transform(i));
        }
    }
}
