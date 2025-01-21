package tech.sipe.fintech.account.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import tech.sipe.fintech.account.domain.Account
import tech.sipe.fintech.account.domain.AccountRepository
import java.math.BigDecimal

@Service
class AccountService(
	private val accountRepository: AccountRepository,
) {
	@Transactional
	fun link() {
		/**
		 *  1. 지갑 조회
		 *  2. 계좌 생성
		 *  3. 계좌에 지갑 정보 저장
		 *  4. 계좌 저장
		 */
	}

	@Transactional
	fun unlink(accountId: Long) {
		/**
		 *  1. 계좌 조회
		 *  2. 계좌 soft delete
		 *  3. update
		 */
		accountRepository.delete(accountId)
	}

	@Transactional
	fun getBalance(accountId: Long): BigDecimal {
		/**
		 * 1. 계좌 조회
		 * 2. 잔액 반환
		 */
		val account: Account = accountRepository.findByAccountId(accountId)
		return account.balance
	}

	@Transactional
	fun deposit(
		accountId: Long,
		amount: Long,
	) {
		/**
		 * 1. 계좌 조회
		 * 2. amount 입금
		 * 3. 계좌 업데이트
		 */
		val account: Account = accountRepository.findByAccountId(accountId)
		account.deposit(amount)
		accountRepository.save(account)
	}

	@Transactional
	fun withdraw(
		accountId: Long,
		amount: Long,
	) {
		/**
		 * 1. 계좌 조회
		 * 2. amount 만큼 차감
		 * 3. 계좌 업데이트
		 */
		val account: Account = accountRepository.findByAccountId(accountId)
		account.withdraw(amount)
		accountRepository.save(account)
	}
}
