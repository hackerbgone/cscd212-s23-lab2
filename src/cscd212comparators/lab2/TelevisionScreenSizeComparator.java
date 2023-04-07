package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {

    @Override //just compares based on screen size
    public int compare(Television t1, Television t2) {

        if(t1 == null || t2 == null) { //null check for televesion 1 and 2
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        }

        return t1.getScreenSize() - t2.getScreenSize();
    }
}
