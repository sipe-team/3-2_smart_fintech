package tech.sipe.fintech.account.infra

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AccountJpaRepository : JpaRepository<AccountEntity, Long> {
	fun findByUserId(userId: Long): Optional<AccountEntity>
}
