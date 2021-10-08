package ir.javacup.traffic.impl;

import ir.javacup.traffic.Observable;
import ir.javacup.traffic.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class TrafficObservable implements Observable {
    Object object;
    List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void push(Object obj) {
        object = obj;
        for (Subscriber sub : subscriberList) {
            sub.onNext(obj);
        }

    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
}
