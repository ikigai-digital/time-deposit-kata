package org.ikigaidigital

data class TimeDeposit(
    val id: String,
    val planType: String,
    var balance: Double,
    val days: Int
)