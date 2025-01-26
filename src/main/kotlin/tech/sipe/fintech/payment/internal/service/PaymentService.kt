package tech.sipe.fintech.payment.internal.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentRepository
import tech.sipe.fintech.payment.internal.domain.PaymentStatus
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentRequest
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentResponse
import tech.sipe.fintech.wallet.PayWalletInternalApi

@Service
class PaymentService(
	private val paymentRepository: PaymentRepository,
	private val payWalletInternalApi: PayWalletInternalApi, // 해당 클래스가 있다고 가정
) {
	@Transactional
	fun processPayment(paymentRequest: PaymentRequest): PaymentResponse {
		// 1. 지갑 잔액 조회 & 지갑 잔액 차감
		payWalletInternalApi.pay(
			paymentRequest.paymentRequestUserId,
			paymentRequest.money.toLong(),
		)

		// 2. 결제 처리
		val payment =
			Payment(
				id = 0L,
				paymentRequestUserId = paymentRequest.paymentRequestUserId,
				paymentResponseUserId = paymentRequest.paymentResponseUserId,
				money = paymentRequest.money,
				currency = paymentRequest.currency,
				paymentMethod = paymentRequest.paymentMethod,
				paymentStatus = PaymentStatus.SUCCESS,
			)

		val savedPayment = paymentRepository.save(payment)
		return PaymentResponse.from(savedPayment)
	}
}
