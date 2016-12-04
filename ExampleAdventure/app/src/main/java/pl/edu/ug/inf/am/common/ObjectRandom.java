package pl.edu.ug.inf.am.common;

import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@PerGame
public class ObjectRandom {

    private final Random random;

    @Inject
    public ObjectRandom() {
        this(new Random());
    }

    public ObjectRandom(Random random) {
        this.random = random;
    }

    public <T> T rand(List<T> list, FrequencyGetter<T> frequencyGetter){
        int[] frequencies = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            frequencies[i] = frequencyGetter.get(list.get(i));
        }
        return list.get(randIndex(frequencies));
    }

    public int randIndex(int[] probs) {
        int sum = 0;
        for (int prob : probs) {
            sum += prob;
        }
        int rand = random.nextInt(sum);

        int sum2 = 0;
        for (int i = 0; i < probs.length; i++) {
            sum2 += probs[i];
            if (sum2 > rand)
                return i;
        }
        throw new RuntimeException();
    }


    public interface FrequencyGetter<T> {
        int get(T object);
    }
}
