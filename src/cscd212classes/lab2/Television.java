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
    public String toString() {

        String information = this.getMake() + "-" + this.getModel() + ", " + getScreenSize() + " inch ";

        if(this.smart){information += "smart ";}
        information += "tv with ";

        if(this.fourK){information += "4k resolution";}
        else{information += this.getResolution() + "resolution";}


        return information;
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

        //cannot check if the device is smart as a getter is not defined in the documentation
        //however it can be checked to see if the other device is 4k

        if(
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


