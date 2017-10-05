package com.ogoutay.robomocki3.kotlin

import com.ogoutay.robomocki3.manager.ExampleManager
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by ogoutay on 10/5/17.
 */
class MockitoUnitTest {

    companion object {
        private const val MOJITO = "Mojito!"
    }

    @Mock
    private lateinit var exampleManager: ExampleManager

    @Before
    fun setUp() {
        exampleManager = Mockito.mock(ExampleManager::class.java)
        Mockito.`when`(exampleManager.serviceName).thenReturn(MOJITO)
    }

    @Test
    fun testMockito() {
        assertEquals(MOJITO, exampleManager.serviceName)
    }

}
