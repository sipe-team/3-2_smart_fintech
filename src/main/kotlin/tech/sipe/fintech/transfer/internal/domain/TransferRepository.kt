package tech.sipe.fintech.transfer.internal.domain

interface TransferRepository {
	fun findById(transferId: Long): Transfer

	fun save(transferEntity: Transfer): Transfer
}
