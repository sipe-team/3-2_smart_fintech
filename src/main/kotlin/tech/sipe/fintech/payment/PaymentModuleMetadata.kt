package tech.sipe.fintech.payment

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	type = ApplicationModule.Type.CLOSED,
	allowedDependencies = ["common", "wallet", "account"],
)
class PaymentModuleMetadata
