package com.solvd.transport;

import com.solvd.transport.enums.*;
import com.solvd.transport.threads.MyThreadExtended;
import com.solvd.transport.threads.MyThreadImplemented;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.lang.reflect.*;

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
    public static void main(String[] args) throws IOException, InvalidOperationException, InterruptedException {
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
        Bus bus = new Bus("MOD20", 2005, Propulsion.GASOLINE, 4,
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
            car.setCarBrand(CarBrand.HONDA);
        } catch (NotClosedException e) {
            System.out.println("Exception message: " + e.getMessage());
        }
        bus.embarkPassengers(List.of("Anna", "John", "Sean", "Jacob", "Tiffany"));
        LOGGER.info("The total of the collection of fee is: "+bus.collectFees(30));

        // Use of the complex enum Roads
        LOGGER.info("The road condition of the two road from the bus is: "+ bus.getRoadConditionByNumber(2));

        // Add 7 collection streaming in the hierarchy with terminal and non-terminal operations
        bus.setBusBrand(BusBrand.MERCEDES);
        Lorry lorry = new Lorry();
        lorry.setLorryBrand(LorryBrand.SCANIA);
        Bus bus1 = new Bus();
        bus1.setBusBrand(BusBrand.VOLVO);

        LOGGER.info("The number of passengers inside the bus that the name start with 'J' is: "+ bus.getCountPassengers("J"));

        bus.setPropulsion(Propulsion.DIESEL);
        LOGGER.info("The number of liquid fuel is: "+ bus.getKindOfPropulsion("Liquid"));

        bus.setSuitableTerrain(List.of(Roads.GRAVEL, Roads.MURRUM));

        // list of Roads with durability greater than or equal to 5.
        List<Roads> roadsList = new ArrayList<>();
        roadsList = bus.getAllMaxDurability(5);
        LOGGER.info("List of Roads with durability greater than or equal to 5 in the bus: "+roadsList);

        // list of roads with poor condition.
        roadsList = bus.getAllRoadsByCondition(Roads.RoadCondition.POOR);
        LOGGER.info("List of Roads with poor condition in the bus: "+roadsList);

        // list of roads name with good condition.
        List<String> roadsNameList = new ArrayList<>();
        roadsNameList = bus.getAllRoadsNameByCondition(Roads.RoadCondition.GOOD);
        LOGGER.info("List of roads name with good condition in the bus: "+roadsNameList);

        bus.setPropulsion(Propulsion.NATURAL_GAS);

        // List of propulsion types that start with the specific string.
        List<String> propNameList = new ArrayList<>();
        propNameList = bus.getAllByPropulsionName("Gas");
        LOGGER.info("List of propulsion that start with 'gas' in the Bus: "+ propNameList);

        // ----------------------------------------------------------------------------//
        // Using reflection extract information
        try {
            Class anyClass = Class.forName(args[0]);
            Constructor c1;
            // Fields
            Field[] fields = anyClass.getDeclaredFields();
            for (Field field : fields) {
                LOGGER.info("Field: " + field.getName() + ", Type: " + field.getType() + ", Modifiers: " + Modifier.toString(field.getModifiers()));
            }
            // Methods
            Method[] methods = anyClass.getDeclaredMethods();
            for (Method method : methods) {
                LOGGER.info("Method: " + method.getName() + ", Return Type: " + method.getReturnType() + ", Modifiers: " + Modifier.toString(method.getModifiers()));
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    LOGGER.info("    Parameter: " + parameter.getName() + ", Type: " + parameter.getType());
                }
            }
            // Constructors
            Constructor[] constructors = anyClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                LOGGER.info("Constructor: " + constructor.getName() + ", Modifiers: " + Modifier.toString(constructor.getModifiers()));
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter : parameters) {
                    LOGGER.info("    Parameter: " + parameter.getName() + ", Type: " + parameter.getType());
                }
            }
            // Create object
            if (constructors != null) {
                c1 = constructors[0];
                // if the constructor is private
                c1.setAccessible(true);
                Object anyObject = c1.newInstance();
                Method method = anyClass.getDeclaredMethod("startUp");
                //call the method 'startUp' of the instance
                method.invoke(anyObject);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class not found: " + e.getMessage());
        } catch (Throwable e) {
            LOGGER.error("An error occurred: " + e.getMessage());
        }

        //--------------------------------------------------------------------------------//
        // Thread section - Create a Connection pool that is thread safe and lazy initialized.

        MyThreadExtended threadExtended = new MyThreadExtended();
        Thread threadImplemented = new Thread(new MyThreadImplemented());


        // Initialize pool with 5 sizes.
        MyThreadExtended thread3 = new MyThreadExtended();
        Thread thread4 = new Thread(new MyThreadImplemented());
        MyThreadExtended thread5 = new MyThreadExtended();
        Thread thread6 = new Thread(new MyThreadImplemented());
        MyThreadExtended thread7 = new MyThreadExtended();
/*
        threadExtended.start();
        threadExtended.setName("Thread1");
        threadImplemented.start();
        threadImplemented.setName("Thread2");
        thread3.start();
        thread3.setName("Thread3");
        thread4.start();
        thread4.setName("Thread4");
        thread5.start();
        thread5.setName("Thread5");
        thread6.start();
        thread6.setName("Thread6");
        thread7.start();
        thread7.setName("Thread7");

        // it ensures that the program waits for these threads.
        threadExtended.join();
        threadImplemented.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
*/
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(
                CompletableFuture.runAsync(threadExtended),
                CompletableFuture.runAsync(threadImplemented),
                CompletableFuture.runAsync(thread3),
                CompletableFuture.runAsync(thread4),
                CompletableFuture.runAsync(thread5),
                CompletableFuture.runAsync(thread6),
                CompletableFuture.runAsync(thread7)
        );

        // it ensures that the program waits for these threads.
        completableFuture.join();

    }





}