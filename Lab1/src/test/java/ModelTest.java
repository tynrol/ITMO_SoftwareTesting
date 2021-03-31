import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ModelTest {
    @Test
    public void testLightLevel(){
        Space space = new Space();
        Human human = new Human("Бока", 14, 64, new Location(12,34,11));
        Star star1 = new Star(12, new Location(53, 32, 12));
        space.addStar(star1);
        double shiningLevel = star1.getShiningLevel()/star1.getLocation().getDistance(human.getLocation());

        Assertions.assertEquals(star1,space.getClosestStar(human.getLocation()));
        Assertions.assertEquals(shiningLevel,space.getLightLevel(human.getLocation()));

        Star star2 = new Star(14, new Location(12,34,11));
        shiningLevel += star2.getShiningLevel();
        Assertions.assertFalse(shiningLevel == space.getLightLevel(human.getLocation()));
        space.addStar(star2);
        Assertions.assertTrue(shiningLevel == space.getLightLevel(human.getLocation()));
    }


    @Test
    public void testNoiseLevel(){
        Space space = new Space();
        Human human = new Human("Бока", 14, 64, new Location(12,34,11));
        Engine engine1 = new Engine(true, 132, 123, new Location(14,41,13));
        Engine engine2 = new Engine(false, 132, 150, new Location( 16,40,13));
        Engine engine3 = new Engine(true, 150, 200, new Location( 100, 100, 50));
        Engine engine4 = new Engine(true, 132, 220, new Location(13,42,12));

        space.addSoundSource(engine1);

        Assertions.assertEquals(engine1.getNoiseLevel(),space.getNoiseLevel(human.getLocation()));
        Assertions.assertFalse(engine2.getNoiseLevel() == space.getNoiseLevel(human.getLocation()));
        Assertions.assertFalse(engine3.getNoiseLevel() == space.getNoiseLevel(human.getLocation()));

        space.addSoundSource(engine2);
        Assertions.assertFalse(engine2.getNoiseLevel() == space.getNoiseLevel(human.getLocation()));

        space.addSoundSource(engine3);
        Assertions.assertFalse(engine3.getNoiseLevel() == space.getNoiseLevel(human.getLocation()));

        space.addSoundSource(engine4);
        Assertions.assertEquals(engine4.getNoiseLevel(),space.getNoiseLevel(human.getLocation()));

        space.humanWentFlying(human);
        Assertions.assertEquals(human.getFlying(),true);


    }
}
