package cscd212classes.lab2;

public class Television {
    private final boolean fourK;
    private  final String make;
    private final String model;

    private final int resolution;

    private final int screenSize;
    private final boolean smart;


    public Television(boolean fourK, String make, String model, int resolution, int screenSize, boolean smart) {
        this.fourK = fourK;
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
    }
}


