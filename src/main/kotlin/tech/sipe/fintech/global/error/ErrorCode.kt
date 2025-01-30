package tech.sipe.fintech.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
	val status: HttpStatus,
	val message: String,
) {
	SAMPLE_ERROR(HttpStatus.BAD_REQUEST, "Sample Error Message"),

	// Common
	METHOD_ARGUMENT_TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "요청 한 값 타입이 잘못되어 binding에 실패하였습니다."),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP method 입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류, 관리자에게 문의하세요"),

	// Account
	ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Account를 찾을 수 없습니다."),
	ACCOUNT_ENTITY_ID_NULL(HttpStatus.UNPROCESSABLE_ENTITY, message = "Account ID가 존재하지 않아 처리할 수 없습니다."),

	// Balance Out of range
	INSUFFICIENT_BALANCE(HttpStatus.BAD_REQUEST, message = "잔액이 부족합니다."),
}
