package ir.javacup.traffic.impl;

import ir.javacup.traffic.Transformer;

import java.util.Base64;

public class TrafficInfoTransformer implements Transformer<TrafficInfo, String> {

    @Override
    public TrafficInfo transform(String input) {
        try {
            byte[] bytes = Base64.getDecoder().decode(input);
            String strByte = new String(bytes);
            if (!strByte.contains(",")) {
                throw new IllegalArgumentException();
            }
            TrafficInfo tr = new TrafficInfo();
            String[] str = strByte.split(",");
            tr.setLocationCode(str[0]);
            tr.setTrafficLevel(Integer.parseInt(str[1]));
            return tr;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
