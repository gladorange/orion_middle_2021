package animals;

import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class ZooConfiguration {

    @Bean
    @SneakyThrows
    public DataSource getDataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        String jdbcUrl = "jdbc:postgresql://localhost:5432/zoo";
        ds.setUrl(jdbcUrl);
        ds.setUser("postgres");
        ds.setPassword("example");

        return ds;
    }
}
