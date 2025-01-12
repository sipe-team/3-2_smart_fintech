package tech.sipe.fintech.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null

	@CreationTimestamp
	@Column(updatable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()

	@UpdateTimestamp
	@Column
	var updatedAt: LocalDateTime? = null
		protected set

	@Column
	var deletedAt: LocalDateTime? = null
		protected set

	fun softDelete() {
		this.deletedAt = LocalDateTime.now()
	}
}
