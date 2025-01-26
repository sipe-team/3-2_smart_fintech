package tech.sipe.fintech.transfer.internal.infra.jpa

import org.springframework.stereotype.Component
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode
import tech.sipe.fintech.transfer.internal.domain.Transfer
import tech.sipe.fintech.transfer.internal.domain.TransferRepository
import tech.sipe.fintech.transfer.internal.infra.TransferMapper

@Component
class TransferRepositoryImpl(
	private val transferJpaRepository: TransferJpaRepository,
) : TransferRepository {
	override fun findById(transferId: Long): Transfer {
		val transferEntity =
			transferJpaRepository
				.findById(transferId)
				.orElseThrow { CustomException(ErrorCode.RESOURCE_NOT_FOUND) }
		return TransferMapper.toDomain(transferEntity)
	}

	override fun save(transferEntity: Transfer): Transfer =
		TransferMapper.toDomain(transferJpaRepository.save(TransferMapper.toEntity(transferEntity)))
}
