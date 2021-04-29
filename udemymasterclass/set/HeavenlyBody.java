package udemymasterclass.set;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbinatlPeriod;
    private final Set<HeavenlyBody> satellities;


    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbinatlPeriod = orbitalPeriod;
        this.satellities = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbinatlPeriod() {
        return orbinatlPeriod;
    }


    public boolean addMoon(HeavenlyBody moon){
        return this.satellities.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellities);
    }


}
