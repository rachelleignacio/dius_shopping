import models.Checkout
import models.PricingRule
import models.Product

fun main(args: Array<String>) {
    // include all 3 rules for now, but this allows for flexibility around which rules are applied
    val currentRules = arrayListOf(PricingRule.Rule1, PricingRule.Rule2, PricingRule.Rule3)

    val checkout = Checkout(currentRules)
    checkout.scan(Product.MBP)
    checkout.scan(Product.VGA)
    checkout.scan(Product.IPD)
//    checkout.scan(Product.ATV)
//    checkout.scan(Product.IPD)
//    checkout.scan(Product.IPD)
//    checkout.scan(Product.IPD)
    checkout.total()
}