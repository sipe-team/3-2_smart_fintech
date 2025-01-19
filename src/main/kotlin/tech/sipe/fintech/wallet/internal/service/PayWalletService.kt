package tech.sipe.fintech.wallet.internal.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import tech.sipe.fintech.wallet.internal.domain.PayWallet
import tech.sipe.fintech.wallet.internal.domain.PayWalletRepository

@Service
class PayWalletService(
	private val payWalletRepository: PayWalletRepository,
) {
	@Transactional
	fun charge(
		amount: Long,
		userId: Long,
	) {
		/**
		 * 1. 지갑 조회
		 * 2. amount 만큼 충전
		 * 3. 지갑 저장
		 */
		val payWallet: PayWallet = payWalletRepository.findByUserId(userId)
		payWallet.charge(amount)
		payWalletRepository.save(payWallet)
	}

	@Transactional
	fun pay(
		amount: Long,
		userId: Long,
	) {
		/**
		 * 1. 지갑 조회
		 * 2. amount 만큼 차감
		 * 3. 지갑 저장
		 */
	}

	fun getBalance(userId: Long): Long {
		/**
		 * 1. 지갑 조회
		 * 2. 잔액 반환
		 */
		return 0
	}
}
