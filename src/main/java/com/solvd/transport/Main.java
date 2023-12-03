package com.solvd.transport;

import com.solvd.transport.enums.Roads;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * This class reads a text file, counts the number of unique words, and logs the result.
 */
public class Main {
    // Setting up Log4j for logging
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    /**
     * Adds words from a line to the unique and repeated sets.
     */
    private static void addWords(Set<String> uniques, Set<String> repeated, String line) {
        // Splitting the line into words using StringUtils
        String[] words = StringUtils.split(line);
        for(String w : words) {
            // Checking if the word is already in unique or repeated sets
            if (!uniques.isEmpty() && (uniques.contains(StringUtils.lowerCase(w)) ||
                    (!repeated.isEmpty() && repeated.contains(StringUtils.lowerCase(w))))) {
                repeated.add(StringUtils.lowerCase(w));
                uniques.remove(StringUtils.lowerCase(w));
            } else {
                uniques.add(StringUtils.lowerCase(w));
            }
        }
    }
    /**
     * Main method that reads lines from a file, processes them, and logs the result.
     */
    public static void main(String[] args) throws IOException, InvalidOperationException {
        String saludo = "Hola maca";
        
        try {
            // Reading lines from the file using FileUtils
            List<String> lines = FileUtils.readLines(new File("practice-8.txt"));
            Set<String> uniques = new HashSet<>();
            Set<String> repeated = new HashSet<>();
            if (lines != null) {
                for (String line : lines) {
                    // Processing each line to count unique and repeated words
                    addWords(uniques, repeated, line);
                    System.out.println(line);
                }
            }
            // Writing the number of unique words to the file
            FileUtils.writeStringToFile(new File("practice-8.txt"),
                    "\nThe number of the unique words in this file is: " +
                            (uniques.isEmpty() ? 0 : uniques.size()), true);
            // Logging the result
            LOGGER.info("The number of the unique words in this file is: " +
                    (uniques.isEmpty() ? 0 : uniques.size()));
        } catch (IOException e){
            // Logging an error if an exception occurs
            LOGGER.error("Error: "+ e.getMessage());
        }
        //-------------------------------------------------------------------------------//
        // Use at least 5 lambda functions from the java.util.function package.
        Bus bus = new Bus("MOD20", 2005, "gasoline", 4,
                List.of(Roads.CRONCRETE, Roads.ASPHALT), 50);
        Consumer<String> c = (x) -> LOGGER.info(StringUtils.upperCase(x));
        String busString = bus.toString();

        Supplier<String> sup = () -> busString;
        c.accept(sup.get());

        Predicate<String> pred = (x) -> busString.startsWith("Bus");

        Function<Integer, String> fun = (x) -> Integer.toString(x);
        LOGGER.info(fun.apply(bus.getYear()));

        Runnable run = () -> LOGGER.info("Bus as String starts with the world 'Bus': " +
                pred.test(sup.get()));
        run.run();

        // Create 3 custom Lambda functions with generics.
        try (Car car = new Car()) {
            car.startUp();
        } catch (NotClosedException e) {
            System.out.println("Exception message: " + e.getMessage());
        }
        bus.embarkPassengers(List.of("Anna", "John"));
        LOGGER.info("The total of the collection of fee is: "+bus.collectFees(30));

        // Use of the complex enum Roads
        LOGGER.info("The road condition of the two road from the bus is: "+ bus.getRoadConditionByNumber(2));


    }





}
