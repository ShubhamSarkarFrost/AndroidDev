package com.onet.myfirstapp

fun calculateTotalPrice(items: List<Double>, taxRate: Double): Double {
    // Calculate the sum of all item prices
    val subtotal = items.sum()

    // Calculate tax amount
    val taxAmount = subtotal * taxRate

    // Calculate total price

    return subtotal + taxAmount  // Return the calculated total price
}

fun main() {
    val items = listOf(100.0, 200.0, 50.0)  // Prices of items in the cart
    val taxRate = 0.07  // 7% tax rate

    val total = calculateTotalPrice(items, taxRate)
    println("Total price (including tax): $$total")
}