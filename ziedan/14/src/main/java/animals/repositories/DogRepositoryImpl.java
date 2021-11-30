package animals.repositories;

import animals.models.Cat;
import animals.models.Dog;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DogRepositoryImpl implements DogRepository, InitializingBean {
    private DataSource ds;

    @Override
    @SneakyThrows
    public List<Dog> findAll() {
        List<Dog> dogs = new ArrayList<>();
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select d.name, d.volume from dog d");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Dog dog = new Dog();
            dog.setName(resultSet.getString("name"));
            dog.setVolume(resultSet.getInt("volume"));
            dogs.add(dog);
        }

        return dogs;
    }

    @Override
    @SneakyThrows
    public Optional<Dog> findByName(String name) {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select d.name, d.volume from dog d where name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Dog dog = new Dog();
            dog.setName(rs.getString("name"));
            dog.setVolume(rs.getInt("volume"));
            return Optional.of(dog);
        }
        return Optional.empty();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS dog (" +
                "name varchar(255) primary key ," +
                "volume integer" +
                ")");
        preparedStatement.execute();

        ResultSet rs = connection.prepareStatement("select count(1) from dog").executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        if (count > 0) {
            return;
        }

        connection.prepareStatement("insert into dog(name, volume) values" +
                "('MILO', 7)," +
                "('BENTLEY', 12)," +
                "('OLLIE', 11)," +
                "('BUDDY', 15)").execute();
    }
}
