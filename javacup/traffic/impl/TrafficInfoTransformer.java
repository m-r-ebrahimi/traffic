package ir.javacup.traffic.impl;

import ir.javacup.traffic.Transformer;

import java.util.Base64;

public class TrafficInfoTransformer<T, I > implements Transformer<T, I> {

    @Override
    public T transform(I input) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode((String) input);
            String str=new String(decodedBytes);
            return (T) str;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
