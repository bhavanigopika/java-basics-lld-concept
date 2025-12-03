package datatimedifference;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class DateTimeDifference {
    public static void main(String[] args) {
        //Get the current date and time (i.e) 2025-06-28 and 18:43:45:254771700
        LocalDateTime now = LocalDateTime.now();

        //Get the same date and time last year (i.e) 2024-06-28T18:48:49.036396
        LocalDateTime lastYear = LocalDateTime.now().minusYears(1);

        //Calculate the date part difference (years, months, days)
        //Period period = Period.between(lastYear.toLocalDate(), now.toLocalDate());

        //Calculate time part difference (hours, minutes, seconds)
        Duration duration = Duration.between(lastYear, now); //duration:PT8759H54M56.2183757S

        //Calculate the difference of year
        //Duration duration1 = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusYears(1));

        //calculate the date part difference(years, months, days)
        Period period = Period.between(lastYear.toLocalDate(), now.toLocalDate()); //now:"2025-06-28 and 18:43:45:254771700" lastYear: "2024-06-28T18:48:49.036396" period = "P1Y" years = 1, months = 0, days = 0

        //Period period1 = Period.between(LocalDateTime.now().minusYears(1).toLocalDate(), LocalDateTime.now().toLocalDate());

        long totalSeconds = duration.getSeconds(); //duration: PT8759H54M56.2183757S
        long hours = (totalSeconds % (24 * 3600)) / 3600; //totalSeconds: 31535696 hours:23
        long minutes = (totalSeconds % 3600) / 60; //minutes 54
        long seconds = totalSeconds % 60; //totalSeconds: 31535696 seconds: 56

        System.out.printf("Difference: %d years, %d months, %d days, %d hours, %d minutes, %d seconds\n",
                period.getYears(), period.getMonths(), period.getDays(), hours, minutes, seconds); //period: "P1Y" hours: 23   minutes: 54   seconds: 56
    }
}
