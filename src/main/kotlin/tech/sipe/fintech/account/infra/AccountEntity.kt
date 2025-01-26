package tech.sipe.fintech.account.infra

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import tech.sipe.fintech.account.domain.BankName
import tech.sipe.fintech.common.BaseEntity
import tech.sipe.fintech.common.Currency
import java.math.BigDecimal

@Entity
@Table(name = "account")
class AccountEntity(
	val userId: Long,
	@Enumerated(value = EnumType.STRING)
	val bankName: BankName,
	val iban: Long,
	val accountHolderName: String,
	@Enumerated(value = EnumType.STRING)
	val currency: Currency,
	val balance: BigDecimal = BigDecimal.ZERO,
) : BaseEntity()
