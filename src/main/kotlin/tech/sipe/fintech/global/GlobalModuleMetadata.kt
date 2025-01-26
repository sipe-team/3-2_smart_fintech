package tech.sipe.fintech.global

import org.springframework.modulith.ApplicationModule

/**
 * global 패키지의 ApplicationModule type 이 CLOSED 로 설정되어 있어서 테스트가 실패가 됨
 * ( CLOSED 의 경우해당 모듈 최상위 파일에만 접근 할 수 있어서 하위의 error 패키지는 접근 할 수 없습니다)
 * OPEN 으로 수정하면 테스트가 정상적으로 통과됨
 */
@ApplicationModule(
	type = ApplicationModule.Type.OPEN,
	allowedDependencies = [],
)
class GlobalModuleMetadata
