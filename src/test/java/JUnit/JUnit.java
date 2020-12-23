package JUnit;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class JUnit {

    private ArrayList<String> list;

    @BeforeClass
    public static void m1() {
        System.out.println("Using @BeforeClass , executed before all test cases ");
    }

    @Before
    public void m2() {
        list = new ArrayList<String>();
        System.out.println("Using @Before annotations ,executed before each test cases ");
    }

    @AfterClass
    public static void m3() {
        System.out.println("Using @AfterClass ,executed after all test cases");
    }

    @After
    public void m4() {
        list.clear();
        System.out.println("Using @After ,executed after each test cases");
    }

    @Test
    public void m5() {
        list.add("test");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);

        int array[] = new int[7];
        for (int count = 0; count < 7; count++) {
            array[count] = count + 1;
        }
        for (int count = 0; count < 7; count++) {
            System.out.println("array[" + count + "] = " + array[count]);
        }

        Level myVar = Level.HIGH;
        System.out.println(myVar);

        HashMap<String, String> capitalCities = new HashMap<String, String>();
        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        capitalCities.get("England");
        capitalCities.remove("England");

        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        for (String i : capitalCities.values()) {
            System.out.println(i);
        }

        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

        capitalCities.clear();
        capitalCities.size();

    }

    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    @Ignore
    public void m6() {
        System.out.println("Using @Ignore , this execution is ignored");
    }

    @Test(timeout = 10)
    public void m7() {
        System.out.println("Using @Test(timeout),it can be used to enforce timeout in JUnit4 test case");
    }


    /*
    @Test (expected = NoSuchMethodException.class)
    public void m8() {
        System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");
    }
    */

}
