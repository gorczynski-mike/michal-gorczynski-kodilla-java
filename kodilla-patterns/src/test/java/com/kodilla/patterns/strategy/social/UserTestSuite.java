package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User userMillenial = new Millenials("millenials");
        User userYGeneration = new YGeneration("ygeneration");
        User userZGeneration = new ZGeneration("zgeneration");

        //When
        String millenialReturn = userMillenial.share();
        String yGenerationReturn = userYGeneration.share();
        String zGenerationReturn = userZGeneration.share();

        //Then
        Assert.assertEquals("New post shared on Facebook.", millenialReturn);
        Assert.assertEquals("New post shared on Twitter.", yGenerationReturn);
        Assert.assertEquals("New post shared on Snapchat.", zGenerationReturn);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User userMillenial = new Millenials("millenials");
        String millenialOriginal = userMillenial.share();

        //When
        userMillenial.setSocialPublisher(() -> "New post shared on Reddit.");
        String millenialNew = userMillenial.share();

        //Then
        Assert.assertEquals("New post shared on Facebook.", millenialOriginal);
        Assert.assertEquals("New post shared on Reddit.", millenialNew);
    }

}
