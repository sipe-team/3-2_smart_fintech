package tech.sipe.fintech.transfer.internal.infra

import org.springframework.dao.DataIntegrityViolationException
import tech.sipe.fintech.transfer.internal.domain.Transfer
import tech.sipe.fintech.transfer.internal.infra.entity.TransferEntity

class TransferMapper {
	companion object {
		fun toDomain(transferEntity: TransferEntity): Transfer =
			Transfer(
				transferId = transferEntity.id ?: throw DataIntegrityViolationException("Id is null"),
				departureId = transferEntity.departureId,
				destinationId = transferEntity.destinationId,
				amount = transferEntity.amount!!,
				currency = transferEntity.currency,
				transferType = transferEntity.transferType,
				status = transferEntity.status,
				message = transferEntity.message,
			)

		fun toEntity(transfer: Transfer): TransferEntity =
			TransferEntity(
				departureId = transfer.departureId,
				destinationId = transfer.destinationId,
				amount = transfer.amount,
				currency = transfer.currency,
				transferType = transfer.transferType,
				status = transfer.status,
				message = transfer.message,
			)
	}
}
