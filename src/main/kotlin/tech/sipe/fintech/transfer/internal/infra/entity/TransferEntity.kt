package tech.sipe.fintech.transfer.internal.infra.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import tech.sipe.fintech.common.BaseEntity
import tech.sipe.fintech.common.Currency
import tech.sipe.fintech.transfer.internal.domain.TransferStatus
import tech.sipe.fintech.transfer.internal.domain.TransferType
import java.math.BigDecimal

@Entity
@Table(name = "transfer")
class TransferEntity(
	// 송금하는 계좌 혹은 지갑에 대한 ID 정보
	// 송금 요청자
	val departureId: Long,
	// 송금 수신자
	val destinationId: Long,
	// 송금 금액
	val amount: BigDecimal? = BigDecimal.ZERO,
	// 송금 화폐
	val currency: Currency,
	// 송금 유형
	@Enumerated(value = EnumType.STRING)
	val transferType: TransferType,
	// 송금 상태
	@Enumerated(value = EnumType.STRING)
	val status: TransferStatus = TransferStatus.REQUESTED,
	// 송금 메세지
	val message: String? = null,
) : BaseEntity()
