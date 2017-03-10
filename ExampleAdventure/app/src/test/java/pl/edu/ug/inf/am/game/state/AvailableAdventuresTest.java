package pl.edu.ug.inf.am.game.state;

import android.support.annotation.NonNull;
import org.assertj.core.api.ListAssert;
import org.junit.Test;
import pl.aml.adventure.AStage;
import pl.aml.adventure.AdventureDefinition;
import pl.aml.adventure.AdventureInstance;
import pl.aml.impl.location.Place;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Adi on 2017-03-10.
 */
public class AvailableAdventuresTest {

    private AvailableAdventures testObj = new AvailableAdventures();

    private static final Place FIRST_PLACE = Place.values()[0];
    private static final Place SECOND_PLACE = Place.values()[1];

    private static final AdventureInstance INSTANCE =
            new AdventureInstance(FIRST_PLACE, TextAdventure.class, 1);

    private static final AdventureInstance DOUBLE_INSTANCE =
            new AdventureInstance(FIRST_PLACE, TextAdventure.class, 2);

    @Test
    public void isEmpty_WhenCreated() {
        assertThanAdventuresIn(FIRST_PLACE).isEmpty();
        assertThanAdventuresIn(SECOND_PLACE).isEmpty();
    }

    @NonNull
    private ListAssert<AdventureInstance> assertThanAdventuresIn(Place place) {
        return assertThat(testObj.getAdventures(place));
    }

    @Test
    public void addOneInstance(){
        testObj.add(INSTANCE);
        assertThanAdventuresIn(FIRST_PLACE).containsExactly(INSTANCE);
        assertThanAdventuresIn(SECOND_PLACE).isEmpty();
    }

    @Test
    public void addTwoInstances(){
        testObj.add(INSTANCE);
        testObj.add(INSTANCE);
        assertThanAdventuresIn(FIRST_PLACE).containsExactly(DOUBLE_INSTANCE);
        assertThanAdventuresIn(SECOND_PLACE).isEmpty();
    }

    @Test
    public void removeOne_WhenContainTwoInstances() {
        testObj.add(DOUBLE_INSTANCE);

        testObj.remove(INSTANCE);

        assertThanAdventuresIn(FIRST_PLACE).containsExactly(INSTANCE);
        assertThanAdventuresIn(SECOND_PLACE).isEmpty();
    }

    @Test
    public void removeTwo_WhenContainOneInstance() {
        testObj.add(INSTANCE);

        testObj.remove(DOUBLE_INSTANCE);

        assertThanAdventuresIn(FIRST_PLACE).isEmpty();
        assertThanAdventuresIn(SECOND_PLACE).isEmpty();
    }


    private static class TextAdventure implements AdventureDefinition {

        @Override
        public AStage define() {
            return null;
        }
    }
}