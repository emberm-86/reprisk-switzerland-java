import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        List<RentalTime> rentalTimes1 = rentalTimes.stream().sorted(Comparator.comparing(RentalTime::getStart)).toList();
        return IntStream.range(0, rentalTimes1.size() - 1)
                .noneMatch(i -> {
                    RentalTime actual = rentalTimes1.get(i);
                    RentalTime next = rentalTimes1.get(i + 1);
                    return actual.getEnd().after(next.getStart()) || actual.getEnd().equals(next.getStart());
                });
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:00"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 21:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private final Date start;
    private final Date end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}