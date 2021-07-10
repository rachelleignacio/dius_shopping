package models

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class CheckoutTest {
    private val currentRules = arrayListOf(PricingRule.Rule1, PricingRule.Rule2, PricingRule.Rule3)

    @Test
    fun testTotal() {
        val testItems1 = listOf(Product.ATV, Product.ATV, Product.ATV, Product.VGA)
        val testItems2 = listOf(Product.ATV, Product.IPD, Product.IPD, Product.ATV, Product.IPD, Product.IPD, Product.IPD)
        val testItems3 = listOf(Product.MBP, Product.VGA, Product.IPD)
        mapOf(testItems1 to "$249.00", testItems2 to "$2718.95", testItems3 to "$1949.98")
            .forEach{ (items, expected) ->
                val testCheckout = Checkout(currentRules)
                for (item in items) testCheckout.scan(item)
                assertEquals(expected, testCheckout.total())
            }
    }
}