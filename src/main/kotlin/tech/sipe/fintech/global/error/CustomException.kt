package tech.sipe.fintech.global.error

class CustomException(
	val errorCode: ErrorCode,
) : RuntimeException(errorCode.message)
