package org.ikigaidigital

class TimeDepositStore {
    private data class TimeDepositEntity(
        val id: String,
        val planType: String,
        var balance: Double,
        val days: Int
    )

    private val entities = mutableListOf<TimeDepositEntity>()

    fun save(deposit: TimeDeposit): TimeDeposit {
        val entity = TimeDepositEntity(
            id = deposit.id,
            planType = deposit.planType,
            balance = deposit.balance,
            days = deposit.days
        )
        entities.add(entity)
        return deposit
    }

    fun update(deposit: TimeDeposit): TimeDeposit? {
        val index = entities.indexOfFirst { it.id == deposit.id }
        if (index == -1) return null

        entities[index] = entities[index].copy(
            planType = deposit.planType,
            balance = deposit.balance,
            days = deposit.days
        )
        return deposit
    }

    fun findById(id: String): TimeDeposit? {
        return entities.find { it.id == id }?.let { entity ->
            TimeDeposit(entity.id, entity.planType, entity.balance, entity.days)
        }
    }

    fun findAll(): List<TimeDeposit> {
        return entities.map { entity ->
            TimeDeposit(entity.id, entity.planType, entity.balance, entity.days)
        }
    }

    fun clear() = entities.clear()
}
