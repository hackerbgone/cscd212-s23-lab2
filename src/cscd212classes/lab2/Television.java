package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private  final String make;
    private final String model;

    private final int resolution;

    private final int screenSize;
    private final boolean smart;


    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if(make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720){throw new java.lang.IllegalArgumentException();}

        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        if(resolution >= 2160){fourK=true;}
        else{fourK = false;}


    }

    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        if(make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720){throw new java.lang.IllegalArgumentException();}

        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        if(resolution >= 2160){fourK=true;}
        else{fourK = false;}

    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }




    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(Television another) {
        if(another == null){throw new java.lang.IllegalArgumentException();}
        if(this.make.compareTo(another.getMake()) == 0){
            if(this.model.compareTo(another.getModel()) == 0){
                return Integer.compare(this.screenSize, another.getScreenSize());
            }
            return this.model.compareTo(another.getModel());
        }
        return this.make.compareTo(another.getMake());


    }
}


