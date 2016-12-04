package pl.edu.ug.inf.am.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ObjectRandomTest {

    @Mock
    private Random random;
    @InjectMocks
    private ObjectRandom underTest;

    @Test
    public void randIndex() throws Exception {
        when(random.nextInt(10)).thenReturn(5);

        int frequencies[] = {2,4,4};

        int index = underTest.randIndex(frequencies);

        assert index == 1;
    }

    @Test
    public void randFirstIndex() throws Exception {
        when(random.nextInt(10)).thenReturn(0);

        int frequencies[] = {2,4,4};

        int index = underTest.randIndex(frequencies);

        assert index == 0;
    }

    @Test
    public void randLastIndex() throws Exception {
        when(random.nextInt(10)).thenReturn(9);

        int frequencies[] = {2,4,4};

        int index = underTest.randIndex(frequencies);

        assert index == 2;
    }

    @Test
    public void randObject() throws Exception {
        when(random.nextInt(10)).thenReturn(5);

        Integer first = new Integer(2);
        Integer second = new Integer(4);
        Integer third = new Integer(4);

        Integer index = underTest.rand(Arrays.asList(first, second, third), new ObjectRandom.FrequencyGetter<Integer>() {
            @Override
            public int get(Integer object) {
                return object;
            }
        });

        assert index == second;
    }

}