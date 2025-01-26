package tech.sipe.fintech.payment.internal.domain

enum class PaymentStatus {
	/**
	 * 요청 (REQUESTED)
	 * 취소 (CANCELED)
	 * 실패 (FAILED)
	 * 성공 (SUCCESS)
	 */
	REQUESTED,
	CANCELED,
	FAILED,
	SUCCESS,
}
