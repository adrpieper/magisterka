package pl.aml.adventure;

import pl.aml.adventure.definition.ExampleTroll;
import pl.aml.location.Place;
import pl.aml.adventure.definition.AdventureDefinition;

public class AdventureInstance {
    private final Place place;
    private final Class<? extends AdventureDefinition> definition;
    private final int frequency;

    public AdventureInstance(Place place, Class<? extends AdventureDefinition> definition, int frequency) {
        this.place = place;
        this.definition = definition;
        this.frequency = frequency;
    }

    public AdventureInstance(Place place, Class<? extends AdventureDefinition> definition) {
        this(place,definition,1);
    }

    public Place getPlace() {
        return place;
    }

    public Class<? extends AdventureDefinition> getDefinition() {
        return definition;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdventureInstance that = (AdventureInstance) o;

        if (frequency != that.frequency) return false;
        if (place != that.place) return false;
        return definition != null ? definition.equals(that.definition) : that.definition == null;

    }

    @Override
    public int hashCode() {
        int result = place != null ? place.hashCode() : 0;
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        result = 31 * result + frequency;
        return result;
    }
}
