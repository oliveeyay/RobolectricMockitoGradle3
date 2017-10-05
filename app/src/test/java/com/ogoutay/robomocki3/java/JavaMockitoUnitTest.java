package com.ogoutay.robomocki3.java;

import com.ogoutay.robomocki3.managers.ExampleManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;

/**
 * A simple example of using {@link Mockito} with {@link org.junit.runners.JUnit4}
 */
public class JavaMockitoUnitTest {

    private static final String MOJITO = "Mojito!";

    @Mock
    private ExampleManager exampleManager;

    @Before
    public void setUp() {
        exampleManager = Mockito.mock(ExampleManager.class);
        Mockito.when(exampleManager.getServiceName()).thenReturn(MOJITO);
    }

    @Test
    public void testMockito() {
        assertEquals(MOJITO, exampleManager.getServiceName());
    }

}
