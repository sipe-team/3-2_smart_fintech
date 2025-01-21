package tech.sipe.fintech.account

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	type = ApplicationModule.Type.CLOSED,
	allowedDependencies = ["wallet"],
)
class AccountModuleMetadata
