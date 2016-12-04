package pl.aml.adventure.factory;

import pl.aml.Location;
import pl.aml.adventure.definition.AdventureDefinition;

public class AdventureInstance {
    private final Location location;
    private final Class<? extends AdventureDefinition> definition;
    private final int frequency;

    public AdventureInstance(Location location, Class<? extends AdventureDefinition> definition, int frequency) {
        this.location = location;
        this.definition = definition;
        this.frequency = frequency;
    }

    public Location getLocation() {
        return location;
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
        if (location != that.location) return false;
        return definition != null ? definition.equals(that.definition) : that.definition == null;

    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        result = 31 * result + frequency;
        return result;
    }
}
