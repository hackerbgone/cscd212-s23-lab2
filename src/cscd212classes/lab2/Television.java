package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private  final String make;
    private final String model;

    private final int resolution;

    private final int screenSize;
    private final boolean smart;


    public Television(String make, String model, boolean smart, int screenSize, int resolution) {//EVC for Television
        if(make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720){throw new java.lang.IllegalArgumentException("Invalid parameter in constructor");}

        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;

        if(resolution >= 2160){fourK=true;}
        else{fourK = false;}

    }

    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        //Call's the other EVC upon formatting difference
        this(make, model, smart, screenSize, resolution);

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
    public String toString() {//formats the information of the television into a string for printing

        String information = this.getMake() + "-" + this.getModel() + ", " + getScreenSize() + " inch ";

        if(this.smart){information += "smart ";}
        information += "tv with ";

        if(this.fourK){information += "4K resolution";}
        else{information += this.getResolution() + " resolution";}


        return information;
        //Had some issues with the testToString() check for tests, the issue at hand was with the capitalization "K" in 4K
    }

    @Override
    public boolean equals(Object o) {

        //check if obj to this
        if (this == o) return true;
        //check if obj is null
        if (o == null) return false;

        //check if obj is not an instance of Television
        if (!(o instanceof Television)){return false;}

        //check that all class variables are equal to the variables of o
        Television other = (Television) o;


        if(//using formatting concept as shown in class
           this.make.equals(other.getMake()) &&
           this.model.equals(other.getModel()) &&
           this.resolution == other.getResolution() &&
           this.screenSize == other.getScreenSize() &&
           this.smart == other.smart &&
           this.fourK == other.fourK
        ){return true;}

        return false;
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(Television another) {
        if(another == null){throw new java.lang.IllegalArgumentException("null parameter in the compareTo method");}

        if(this.make.compareTo(another.getMake()) == 0){

            if(this.model.compareTo(another.getModel()) == 0){

                return this.screenSize - another.getScreenSize();
            }

            return this.model.compareTo(another.getModel());
        }

        return this.make.compareTo(another.getMake());
    }
}


