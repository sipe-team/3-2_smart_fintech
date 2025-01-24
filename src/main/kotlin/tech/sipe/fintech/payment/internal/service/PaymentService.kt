package tech.sipe.fintech.payment.internal.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode
import tech.sipe.fintech.payment.WalletServiceClient
import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentRepository
import tech.sipe.fintech.payment.internal.domain.PaymentStatus
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentRequest
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentResponse

@Service
class PaymentService(
	private val paymentRepository: PaymentRepository,
	private val walletServiceClient: WalletServiceClient, // 해당 클래스가 있다고 가정
) {
	@Transactional
	fun processPayment(paymentRequest: PaymentRequest): PaymentResponse {
		// 1. 지갑 잔액 조회
		val walletBalance = walletServiceClient.getWalletBalance(paymentRequest.paymentRequestUserId)
		if (walletBalance < paymentRequest.money.toLong()) {
			throw CustomException(ErrorCode.WALLET_BALANCE_IS_EMPTY)
		}

		// 2. 지갑 잔액 차감
		walletServiceClient.deductWalletBalance(
			paymentRequest.paymentRequestUserId,
			paymentRequest.money,
		)

		// 3. 결제 처리
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
