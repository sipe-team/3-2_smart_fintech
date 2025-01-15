package tech.sipe.fintech.wallet.infra

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import tech.sipe.fintech.common.BaseEntity
import tech.sipe.fintech.wallet.domain.Currency
import tech.sipe.fintech.wallet.domain.WalletStatus
import java.math.BigDecimal

@Entity
@Table(name = "pay_wallet")
class PayWalletEntity(
	val userId: Long,
	val accountId: Long,
	@Enumerated(value = EnumType.STRING)
	val walletStatus: WalletStatus,
	val balance: BigDecimal = BigDecimal.ZERO,
	@Enumerated(value = EnumType.STRING)
	val currency: Currency,
) : BaseEntity()
