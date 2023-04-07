package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {


    @Override //reminder: compare based on model and then screen size IF AND ONLY IF model is the same
    public int compare(Television t1, Television t2) {
        if(t1 == null || t2 == null){
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");
        }

        if(t1.getModel().compareTo(t2.getModel()) == 0){
            return t1.getScreenSize() - t2.getScreenSize();
        }

        return t1.getModel().compareTo(t2.getModel()); //test cases were a little odd in terms of compareTo, had to swap the order a few times to meet expectations
    }
}