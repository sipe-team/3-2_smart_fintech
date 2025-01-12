package tech.sipe.fintech.config

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DatasourceConfiguration {
	@Bean
	@Primary
	fun dataSource(): DataSource {
		val dotenv: Dotenv = Dotenv.load()

		val dataSource = DriverManagerDataSource()
		dataSource.url = dotenv["SUPABASE_URL"]
		dataSource.username = dotenv["SUPABASE_USERNAME"]
		dataSource.password = dotenv["SUPABASE_PASSWORD"]

		return dataSource
	}
}
