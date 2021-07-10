package models

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class PricingRuleTest {
    @Test
    fun testRule1Apply() {
        val testRule1 = PricingRule.Rule1
        val testMap1 = mutableMapOf(Product.ATV to 2)
        val testMap2 = mutableMapOf(Product.ATV to 3)
        val testMap3 = mutableMapOf(Product.ATV to 7)
        mapOf(testMap1 to 0.0, testMap2 to 109.50, testMap3 to 219.0)
            .forEach{ (map, expected) ->
                assertEquals(expected, testRule1.apply(map))
            }
    }
}