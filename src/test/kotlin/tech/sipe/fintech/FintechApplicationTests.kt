package tech.sipe.fintech

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.test.ApplicationModuleTest

@ApplicationModuleTest
class FintechApplicationTests {
	val modules: ApplicationModules = ApplicationModules.of(FintechApplication::class.java)

	@Test
	fun contextLoads() {
		println("modules: $modules")

		modules.verify()
	}
}
