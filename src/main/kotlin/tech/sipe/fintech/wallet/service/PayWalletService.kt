package tech.sipe.fintech.wallet.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import tech.sipe.fintech.wallet.domain.PayWallet
import tech.sipe.fintech.wallet.domain.PayWalletRepository
import java.math.BigDecimal

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
		payWalletId: Long,
	) {
		/**
		 * 1. 지갑 조회
		 * 2. amount 만큼 차감
		 * 3. 지갑 저장
		 */
		val payWallet: PayWallet = payWalletRepository.findByPayWalletId(payWalletId)
		payWallet.withdraw(amount)
		payWalletRepository.save(payWallet)
	}

	fun getBalance(payWalletId: Long): BigDecimal {
		/**
		 * 1. 지갑 조회
		 * 2. 잔액 반환
		 */
		val payWallet: PayWallet = payWalletRepository.findByPayWalletId(payWalletId)
		return payWallet.balance
	}
}
