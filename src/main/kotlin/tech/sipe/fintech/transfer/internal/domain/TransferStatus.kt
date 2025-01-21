package tech.sipe.fintech.transfer.internal.domain

enum class TransferStatus {
	REQUESTED,
	SUCCEEDED,
	FAILED,
	CANCELED,
	REFUNDED,
	EXPIRED,
	PENDING,
	PROCESSING,
	REJECTED,
	UNKNOWN,
}
