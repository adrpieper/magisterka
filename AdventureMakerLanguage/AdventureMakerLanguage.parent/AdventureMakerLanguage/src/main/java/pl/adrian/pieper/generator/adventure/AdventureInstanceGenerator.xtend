package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.aML.AdventureInstance

/**
 * Created by Adi on 2016-12-19.
 */
class AdventureInstanceGenerator {

    extension AdventureClassNameGenerator classNameGenerator = new AdventureClassNameGenerator

    def String generate(AdventureInstance instance) {
        return '''«instance.location.name.toUpperCase»,«instance.adventure.generateClassName».class«generateFreqency(instance.freqency)»'''
    }

    def String generateFreqency(int freq) {
        if (freq == 0) {
            return ""
        }
        return "," + freq;
    }
}