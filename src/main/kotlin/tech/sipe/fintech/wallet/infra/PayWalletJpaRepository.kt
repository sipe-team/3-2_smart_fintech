package tech.sipe.fintech.wallet.infra

import org.springframework.data.jpa.repository.JpaRepository

interface PayWalletJpaRepository : JpaRepository<PayWalletEntity, Long> {
	fun findByUserId(userId: Long): PayWalletEntity?
}
