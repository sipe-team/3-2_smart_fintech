package tech.sipe.fintech.wallet.service

import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import tech.sipe.fintech.account.Account
import tech.sipe.fintech.external.ExternalTransferApi
import tech.sipe.fintech.wallet.domain.*
import tech.sipe.fintech.wallet.presentation.request.CreateWalletRequest
import tech.sipe.fintech.wallet.presentation.response.GetBalanceResponse

@Service
class PayWalletService(
	private val payWalletRepository: PayWalletRepository,
	private val externalTransferApi: ExternalTransferApi,
	private val eventPublisher: ApplicationEventPublisher,
) {
	@Transactional
	fun create(createWalletRequest: CreateWalletRequest) {
		/**
		 * 1. 지갑 생성
		 * 2. 지갑 저장
		 */
		val payWallet: PayWallet = PayWallet.initialize(createWalletRequest.userId)
		payWalletRepository.save(payWallet)
	}

	/*
	 * TODO
	 * pay 메소드도 이체하는 동작이 필요한가?
	 * 그럼 결제 모듈의 역할은?
	 */
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

	fun getBalance(payWalletId: Long): GetBalanceResponse {
		/**
		 * 1. 지갑 조회
		 * 2. 잔액 반환
		 */
		val payWallet: PayWallet = payWalletRepository.findByPayWalletId(payWalletId)
		return GetBalanceResponse(payWallet.balance)
	}

	@Transactional
	fun charge(
		amount: Long,
		userId: Long,
	) {
		val payWallet: PayWallet = payWalletRepository.findByUserId(userId)
		payWallet.charge(amount)
		payWalletRepository.save(payWallet)

		// FIXME 계좌 조회 mocking -> 계좌 API 로 조회 필요
		val userAccount = Account() // findByUserId
		val corpAccount = Account()
		externalTransferApi.transfer(
			sourceAccountNumber = userAccount.accountNo,
			destinationAccountNumber = corpAccount.accountNo,
			amount = amount,
		)

		eventPublisher.publishEvent(PayWalletChargedEvent())
	}

	@Transactional
	fun withdraw(
		amount: Long,
		userId: Long,
	) {
		val payWallet: PayWallet = payWalletRepository.findByUserId(userId)
		payWallet.withdraw(amount)
		payWalletRepository.save(payWallet)

		// FIXME 계좌 조회 mocking -> 계좌 API 로 조회 필요
		val userAccount = Account() // findByUserId
		val corpAccount = Account()
		externalTransferApi.transfer(
			sourceAccountNumber = corpAccount.accountNo,
			destinationAccountNumber = userAccount.accountNo,
			amount = amount,
		)

		eventPublisher.publishEvent(PayWalletWithdrawnEvent())
	}

	@Transactional
	fun transfer(
		sourceUserId: Long,
		destinationUserId: Long,
		amount: Long,
	) {
		val sourcePayWallet: PayWallet = payWalletRepository.findByUserId(sourceUserId)
		val destinationPayWallet: PayWallet = payWalletRepository.findByUserId(destinationUserId)

		sourcePayWallet.withdraw(amount)
		destinationPayWallet.charge(amount)

		payWalletRepository.save(sourcePayWallet)
		payWalletRepository.save(destinationPayWallet)

		// transfer 이력 저장
		externalTransferApi.transfer(
			sourceAccountNumber = sourcePayWallet.accountId.toString(),
			destinationAccountNumber = destinationPayWallet.accountId.toString(),
			amount = amount,
		)

		eventPublisher.publishEvent(PayWalletTransferredEvent())
	}
}
