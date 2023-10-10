package edu.nyu.cs;

import java.util.Scanner;

/**
 * This question is based on Question 1-11 in Liang's Intro to Java textbook.
 * 
 * Complete this program such that it:
 * - calculates and displays the projected population for each of the next five
 * years.
 *
 * The U.S. Census Bureau projects population based on the following
 * assumptions:
 * - Current population: 334,300,850
 * - Each year has 365 days
 * - One birth every 9 seconds
 * - One death every 10 seconds
 * - One new immigrant every 32 seconds
 * 
 * Hint:
 * - There are no fractional people. All population projections must be
 * integers.
 * - In Java, if two integers perform division, the result is an integer - the
 * fractional part is truncated.
 * - To get an accurate result, one of the values in the division must be a
 * number with a decimal place.
 * 
 * Sample output. Your program should format the output exactly like this:
 * Here are the projected population numbers for the next five years:
 * - Year 2024: 335636750
 * - Year 2025: 336972650
 * - Year 2026: 338308550
 * - Year 2027: 339644450
 * - Year 2028: 340980350
 */
public class PopulationProjector {

    /**
     * The main function is automatically called first in a Java program.
     * Complete the assignment within this function.
     * 
     * @param args An array of any command-line arguments. Java requires the main
     *             function include this, even if not used.
     * @throws Exception Allows us to not worry about Exceptions in this function.
     *                   Java requires the main functino include this, even if not
     *                   used.
     */
    public static void main(String[] args) throws Exception {
        double birthrate = 9.0;
        double deathrate = 10.0;
        double immigrant = 32.0;
        int year2023 = 334300850;
        int yearsecond = 365*24*60*60;
        double birthamount = yearsecond/birthrate;
        double deathamount = yearsecond/deathrate;
        double immigrantamount = yearsecond/immigrant;
        double year2024 = year2023 + birthamount - deathamount + immigrantamount;
        double year2025 = year2024 + birthamount - deathamount + immigrantamount;
        double year2026 = year2025 + birthamount - deathamount + immigrantamount;
        double year2027 = year2026 + birthamount - deathamount + immigrantamount;
        double year2028 = year2027 + birthamount - deathamount + immigrantamount;
        System.out.println("Here are the projected population numbers for the next five years:");
        System.out.println("- Year 2024: " + (int)year2024);
        System.out.println("- Year 2025: " + (int)year2025);
        System.out.println("- Year 2026: " + (int)year2026);
        System.out.println("- Year 2027: " + (int)year2027);
        System.out.println("- Year 2028: " + (int)year2028);
        // complete this function to solve the problem
    }

}
