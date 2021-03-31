import Model.ILoveHashCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testMyMap(){

        MyMap<ILoveHashCode,String> myMap = new MyMap<ILoveHashCode, String>();
        Map<ILoveHashCode,String> expectedMap = new HashMap<ILoveHashCode, String>();

        Assertions.assertEquals(expectedMap.isEmpty(), myMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), myMap.size());

        myMap.add(new ILoveHashCode("a"), "abcd");
        myMap.add(new ILoveHashCode("b"), "bcda");
        myMap.add(new ILoveHashCode("c"), "cdab");
        myMap.add(new ILoveHashCode("d"), "dabc");

        expectedMap.put(new ILoveHashCode("a"), "abcd");
        expectedMap.put(new ILoveHashCode("b"), "bcda");
        expectedMap.put(new ILoveHashCode("c"), "cdab");
        expectedMap.put(new ILoveHashCode("d"), "dabc");

        Assertions.assertEquals(expectedMap.isEmpty(), myMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), myMap.size());
        Assertions.assertEquals(expectedMap.get(new ILoveHashCode("b")), myMap.get(new ILoveHashCode("b")));
        Assertions.assertEquals(expectedMap.remove(new ILoveHashCode("c")), myMap.remove(new ILoveHashCode("c")));

        myMap.add(new ILoveHashCode("c"), "eatable");
        myMap.add(new ILoveHashCode("c"), "enable");
        expectedMap.put(new ILoveHashCode("c"), "eatable");
        expectedMap.put(new ILoveHashCode("c"), "enable");
        Assertions.assertEquals(expectedMap.get(new ILoveHashCode("c")), myMap.get(new ILoveHashCode("c")));
        System.out.println(expectedMap);
    }
}
