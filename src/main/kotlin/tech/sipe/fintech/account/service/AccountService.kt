package tech.sipe.fintech.account.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.sipe.fintech.account.domain.Account
import tech.sipe.fintech.account.domain.AccountRepository
import tech.sipe.fintech.account.presentation.request.CreateAccountRequest
import tech.sipe.fintech.account.presentation.response.GetAccountResponse
import java.math.BigDecimal

@Service
class AccountService(
	private val accountRepository: AccountRepository,
) {
	@Transactional
	fun create(createAccountRequest: CreateAccountRequest) {
		val account: Account = Account.initialize(createAccountRequest)
		accountRepository.save(account)
	}

	@Transactional
	fun delete(accountId: Long) {
		/**
		 *  1. 계좌 조회
		 *  2. 계좌 soft delete
		 *  3. update
		 */
		accountRepository.delete(accountId)
	}

	@Transactional(readOnly = true)
	fun getBalance(accountId: Long): BigDecimal {
		/**
		 * 1. 계좌 조회
		 * 2. 잔액 반환
		 */
		val account: Account = accountRepository.findByAccountId(accountId)
		return account.balance
	}

	@Transactional(readOnly = true)
	fun getAccountByUserId(userId: Long): GetAccountResponse {
		val account = accountRepository.findByUserId(userId)
		return GetAccountResponse(account.iban)
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
