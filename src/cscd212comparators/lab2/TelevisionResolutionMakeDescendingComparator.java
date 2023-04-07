package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {


    @Override //first compares based on resolution and if they are equal it instead compares on resolution
    public int compare(Television t1, Television t2) {
        if(t1 == null || t2 == null) { //null check set accordingly to the tests
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }

        if(Integer.compare(t1.getResolution(), t2.getResolution()) == 0){
            return t2.getMake().compareTo(t1.getMake());
        }

        return t2.getResolution() - t1.getResolution(); //originally kept using Integer.compare but it was not needed and incorrect in terms of standards

    }
}
