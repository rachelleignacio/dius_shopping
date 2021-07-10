package models

class Checkout(private val rules: ArrayList<PricingRule>) {
    private val items: MutableMap<Product, Int> = mutableMapOf()

    fun scan(item: Product) {
        val itemCount = items.getOrDefault(item, 0)
        items[item] = itemCount + 1
    }

    fun total(): String {
        // calculate normal total, and then determine discounts based on rules applied
        var discountAmount = 0.0
        for (rule in rules) {
            discountAmount+= rule.apply(items)
        }
        return String.format("$%.2f", undiscountedTotal() - discountAmount)
    }

    private fun undiscountedTotal(): Double {
        return items
            .asSequence()
            .fold(0.0) { total, item -> total + item.value * item.key.price }
    }
}