package models

sealed class PricingRule {
    // takes in the total list of scanned items, and returns the amount to discount from the total
    abstract fun apply(items: Map<Product, Int>): Double

    object Rule1: PricingRule() {
        //3 for 2 deal on Apple TVs. For example, if you buy 3 Apple TVs, you will pay the price of 2 only
        override fun apply(items: Map<Product, Int>): Double {
            val numAppleTvs = items.getOrDefault(Product.ATV, 0)

            // if less than 3, exit early
            if (numAppleTvs < 3) return 0.0

            // for every 3 Apple TVs, discount the price of 1
            val multiplesOf3 = numAppleTvs/3.0
            return multiplesOf3 * Product.ATV.price
        }
    }

    object Rule2: PricingRule() {
        //Super iPad will have a bulk discounted applied, where the price will drop to $499.99 each, if someone buys more than 4
        override fun apply(items: Map<Product, Int>): Double {
            val numSuperIpads = items.getOrDefault(Product.IPD, 0)
            return if (numSuperIpads > 4) (Product.IPD.price - 499.99) * numSuperIpads else 0.0
        }
    }

    object Rule3: PricingRule() {
        //bundle in a free VGA adapter free of charge with every MacBook Pro sold
        override fun apply(items: Map<Product, Int>): Double {
            val numMacbooks = items.getOrDefault(Product.MBP, 0)
            val numVgas = items.getOrDefault(Product.VGA, 0)

            // if no MBPs, no discount. return early
            if (numMacbooks < 1) return 0.0

            return if (numVgas <= numMacbooks) {
                // discount all of VGAs
                numVgas * Product.VGA.price
            } else {
                // discount VGAs for the amount of MBPs
                numMacbooks * Product.VGA.price
            }
        }
    }
}
