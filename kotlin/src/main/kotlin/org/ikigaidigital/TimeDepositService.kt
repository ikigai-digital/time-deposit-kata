package org.ikigaidigital

class TimeDepositService(
    private val store: TimeDepositStore,
    private val calculator: TimeDepositCalculator
) {
    fun update(timeDeposit: TimeDeposit): TimeDeposit? {
        return store.update(timeDeposit)
    }

    fun get(id: String): TimeDeposit? {
        return store.findById(id)
    }

    fun calculateInterestForAll() {
        val deposits = store.findAll()
        calculator.calculateInterest(deposits)
        deposits.forEach { store.update(it) }
    }
}
