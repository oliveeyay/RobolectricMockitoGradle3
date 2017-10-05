package com.ogoutay.robomocki3.kotlin

import com.ogoutay.robomocki3.managers.ExampleManager
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * A simple example of using [Mockito] with [org.junit.runners.JUnit4]
 */
class KotlinMockitoUnitTest {

    companion object {
        private const val MOJITO = "Mojito!"
    }

    @Mock
    private lateinit var exampleManager: ExampleManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(exampleManager.serviceName).thenReturn(MOJITO)
    }

    @Test
    fun testMockito() {
        assertEquals(MOJITO, exampleManager.serviceName)
    }

}
