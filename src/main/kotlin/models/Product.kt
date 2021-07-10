package models

enum class Product(val itemName: String, val price: Double) {
    IPD("Super iPad", 549.99),
    MBP("MacBook Pro", 1399.99),
    ATV("Apple TV", 109.50),
    VGA("VGA Adapter", 30.00);
}