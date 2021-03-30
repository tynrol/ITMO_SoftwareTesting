package Model;

import java.io.*;
import java.util.*;

public class Space {
    Collection<Star> stars = new LinkedList<Star>();
    Collection<SoundSource> soundSources = new LinkedList<SoundSource>();

    public Space() {
    }

    public Star getClosestStar(Location location){
        int minDistance = Integer.MAX_VALUE;
        Star closestStar = null;
        for (Star star: stars) {
            if (star.getLocation().getDistance(location) < minDistance)
                closestStar = star;
        }
        return closestStar;
    }

    public SoundSource getClosestSoundSource(Location location){
        int minDistance = Integer.MAX_VALUE;
        SoundSource closestSoundSource = null;
        for (SoundSource soundSource: soundSources) {
            if (soundSource.getLocation().getDistance(location) < minDistance)
                 closestSoundSource = soundSource;
        }
        return closestSoundSource;
    }

    public int getNoiseLevel(Location location){
        if (getClosestSoundSource(location).getLocation().getDistance(location) > 100){
            //noise is not spreading in space
            return 0;
        } else {
            //but actually we can hear the engine
            int loudestSound = 0;
            for (SoundSource soundSource: soundSources) {
                if( (soundSource.getNoiseLevel() > loudestSound) && (soundSource instanceof Engine) && (( (Engine) soundSource).isWorking()))
                    loudestSound = soundSource.getNoiseLevel();
            }
            return loudestSound;
        }
    }

    public double getLightLevel(Location location){
        //although light can travel in space
        double shiningLevel = 0;
        for (Star star: stars) {
            int distance = star.getLocation().getDistance(location);
            if (distance<1) distance = 1;
            shiningLevel += star.getShiningLevel()/distance;
        }
        return shiningLevel;
    }

    public void addStar(Star star){
        stars.add(star);
    }

    public void addSoundSource(SoundSource soundSource){
        soundSources.add(soundSource);
    }

    public int removeStar(Star star){
        if (stars.contains(star)){
            stars.remove(star);
            return 0;
        }
        return 1;

    }

    public int removeSoundSource(SoundSource soundSource){
        if (soundSources.contains(soundSource)) {
            soundSources.remove(soundSource);
            return 0;
        }
        return 1;
    }
}
