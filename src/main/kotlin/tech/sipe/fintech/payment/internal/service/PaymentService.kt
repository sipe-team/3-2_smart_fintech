package tech.sipe.fintech.payment.internal.service

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentCompletedEvent
import tech.sipe.fintech.payment.internal.domain.PaymentRepository
import tech.sipe.fintech.payment.internal.domain.PaymentStatus
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentRequest
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentResponse
import tech.sipe.fintech.wallet.PayWalletInternalApi

@Service
class PaymentService(
	private val paymentRepository: PaymentRepository,
	private val payWalletInternalApi: PayWalletInternalApi, // 지갑 모듈에 있는 api 연동
	private val eventPublisher: ApplicationEventPublisher,
) {
	@Transactional
	fun processPayment(paymentRequest: PaymentRequest): PaymentResponse {
		// 1. 지갑 잔액 조회 & 지갑 잔액 차감
		payWalletInternalApi.debit(
			userId = paymentRequest.paymentRequestUserId,
			amount = paymentRequest.money.toLong(),
		)

		// 2. 결제 이력 저장
		val payment =
			Payment(
				paymentId = 0L,
				paymentRequestUserId = paymentRequest.paymentRequestUserId,
				paymentResponseUserId = paymentRequest.paymentResponseUserId,
				money = paymentRequest.money,
				currency = paymentRequest.currency,
				paymentMethod = paymentRequest.paymentMethod,
				paymentStatus = PaymentStatus.SUCCESS,
			)

		val savedPayment = paymentRepository.save(payment)

		eventPublisher.publishEvent(PaymentCompletedEvent(paymentId = savedPayment.paymentId, amount = paymentRequest.money))

		return PaymentResponse.from(savedPayment)
	}

	@Transactional
	fun compensatePayment(paymentId: Long) {
		val payment = paymentRepository.findByPaymentId(paymentId)
		payWalletInternalApi.charge(
			userId = payment.paymentRequestUserId,
			amount = payment.money.toLong(),
		)
		payment.failed()
		paymentRepository.save(payment)
	}
}
