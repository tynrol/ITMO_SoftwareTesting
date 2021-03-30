import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testMyMap(){


        MyMap<String,String> myMap = new MyMap<String, String>();
        Map<String,String> expectedMap = new HashMap<String, String>();


        Assertions.assertEquals(expectedMap.isEmpty(), myMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), myMap.size());

        myMap.add("a", "abcd");
        myMap.add("b", "bcda");
        myMap.add("c", "cdab");
        myMap.add("d", "dabc");

        expectedMap.put("a", "abcd");
        expectedMap.put("b", "bcda");
        expectedMap.put("c", "cdab");
        expectedMap.put("d", "dabc");

        Assertions.assertEquals(expectedMap.isEmpty(), myMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), myMap.size());
        Assertions.assertEquals(expectedMap.get("b"), myMap.get("b"));
        Assertions.assertEquals(expectedMap.remove("c"), myMap.remove("c"));

        myMap.add("e", "eatable");
        myMap.add("e", "enable");
        expectedMap.put("e", "eatable");
        expectedMap.put("e", "enable");
        Assertions.assertEquals(expectedMap.get("e"), myMap.get("e"));
    }
}
