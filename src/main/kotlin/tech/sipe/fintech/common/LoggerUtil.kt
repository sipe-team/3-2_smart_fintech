package tech.sipe.fintech.common

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
fun Any.logInfo(message: String) {
	val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)
	logger.info(message)
}

fun Any.logError(message: String? = null, e: Exception) {
	val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)
	logger.error(message ?: e.message ?: e.localizedMessage, e)
}

