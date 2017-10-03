package com.netflix.mediaclient.kotlinx

import org.joor.Reflect
import java.lang.reflect.Field
import java.lang.reflect.Modifier

/**
 * Kotlin extension for [Reflect] in order to replace final static variables.
 */
@Throws(Exception::class)
fun Reflect.setFinalStatic(name: String, newValue: Any) {
    val field = this.get<Class<*>>().getField(name)

    field.isAccessible = true
    val modifiersField = Field::class.java.getDeclaredField("modifiers")
    modifiersField.isAccessible = true
    modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())

    field.set(null, newValue)
}