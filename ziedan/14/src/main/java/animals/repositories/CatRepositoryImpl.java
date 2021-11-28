package animals.repositories;

import animals.models.Cat;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CatRepositoryImpl implements CatRepository, InitializingBean {
    private DataSource ds;

    @SneakyThrows
    public void afterPropertiesSet() {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS cat (" +
                "name varchar(255) primary key ," +
                "volume integer" +
                ")");
        preparedStatement.execute();

        ResultSet rs = connection.prepareStatement("select count(1) from cat").executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        if (count > 0) {
            return;
        }

        connection.prepareStatement("insert into cat(name, volume) values" +
                "('Tom', 3)," +
                "('Bella', 4)," +
                "('Kitty', 2)," +
                "('Lucy', 6)").execute();
    }

    @Override
    @SneakyThrows
    public List<Cat> findAll() {
        List<Cat> cats = new ArrayList<>();
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select c.name, c.volume from cat c");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Cat cat = new Cat();
            cat.setName(resultSet.getString("name"));
            cat.setVolume(resultSet.getInt("volume"));
            cats.add(cat);
        }

        return cats;
    }

    @Override
    @SneakyThrows
    public Optional<Cat> findByName(String name) {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select c.name, c.volume from cat c where name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cat cat = new Cat();
            cat.setName(rs.getString("name"));
            cat.setVolume(rs.getInt("volume"));
            return Optional.of(cat);
        }
        return Optional.empty();
    }
}
