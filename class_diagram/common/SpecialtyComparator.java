package common;

import java.util.Comparator;
import education.Specialty;

public class SpecialtyComparator implements Comparator<Specialty> {

    @Override
    public int compare(Specialty specialty1, Specialty specialty2) {
        return specialty1.getSpecialtyId().compareTo(specialty2.getSpecialtyId());
    }
}
