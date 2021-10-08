package ir.javacup.traffic.impl;

import ir.javacup.traffic.Observable;
import ir.javacup.traffic.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class TrafficObservable implements Observable {
    Object obj;
    List<Subscriber> subscriberList = new ArrayList<>();


    @Override
    public void push(Object obj) {
        this.obj = obj;
        for (Subscriber s : subscriberList) {
            s.onNext(obj);
        }
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
}
