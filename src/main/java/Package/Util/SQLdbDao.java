package Package.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Properties;

public class SQLdbDao {
    public Humidity getlastHumidity() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `inlämning1-sysintegration`.`humidity` WHERE humidity.Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`humidity`)"))
        {
            while (resultSet.next())
            {
                Humidity humidity = new Humidity(resultSet.getInt("Id"),
                        resultSet.getFloat("Humidity"),
                        resultSet.getDate("Created").toLocalDate());
                System.out.println(humidity.getId()+" "+humidity.getHumidity()+" "+humidity.getDate());
                return humidity;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Humidity();
    }
    public Temperature getlastTemperature() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `inlämning1-sysintegration`.`temperature`WHERE temperature.Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`temperature`)"))
        {
            while (resultSet.next())
            {
                Temperature temperature = new Temperature(resultSet.getInt("Id"),
                        resultSet.getFloat("Temperature"),
                        resultSet.getDate("Created").toLocalDate());
                System.out.println(temperature.getId()+" "+temperature.getTemperature()+" "+temperature.getDate());
                return temperature;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Temperature();
    }
    public Illumination getlastIllumination() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `inlämning1-sysintegration`.`lightning`WHERE lightning.Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`lightning`)"))
        {
            while (resultSet.next())
            {
                Illumination illumination = new Illumination(resultSet.getInt("Id"),
                        resultSet.getInt("Lightning"),
                        resultSet.getDate("Created").toLocalDate());
                System.out.println(illumination.getId()+" "+illumination.getIllumination()+" "+illumination.getDate());
                return illumination;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Illumination();
    }
    public Electricity getlastElectricity() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `inlämning1-sysintegration`.`electricity`WHERE electricity.Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`electricity`)"))
        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            while (resultSet.next())
            {
                Electricity electricity = new Electricity(resultSet.getInt("Id"),
                        resultSet.getInt("Electricity"),
                        resultSet.getDate("Created").toLocalDate());
                System.out.println(electricity.getId()+" "+electricity.getElectricity()+" "+electricity.getDate());
                return electricity;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Electricity();
    }
    public Humidity updateHumidity(int id,float humidity) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\IdeaProjects\\REST\\src\\main\\java\\restdemospring\\util\\Setting.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            PreparedStatement statement = connection.prepareStatement("UPDATE `inlämning1-sysintegration`.humidity SET humidity=? WHERE id=?");)
        {
            statement.setFloat(1,humidity);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(humidity);
        System.out.println(id);
        return new Humidity(id,humidity,LocalDate.now());
    }
    public Temperature updateTemperature(int id,float temperature) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\IdeaProjects\\REST\\src\\main\\java\\restdemospring\\util\\Setting.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            PreparedStatement statement = connection.prepareStatement("UPDATE `inlämning1-sysintegration`.temperature SET Temperature=? WHERE id=?");)
        {
            statement.setFloat(1,temperature);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(temperature);
        System.out.println(id);
        return new Temperature(id,temperature,LocalDate.now());
    }
    public Illumination updateIllumination(int id,int Lightning) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\IdeaProjects\\REST\\src\\main\\java\\restdemospring\\util\\Setting.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            PreparedStatement statement = connection.prepareStatement("UPDATE `inlämning1-sysintegration`.lightning SET Lightning=? WHERE id=?");)
        {
            statement.setInt(1,Lightning);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(Lightning);
        System.out.println(id);
        return new Illumination(id,Lightning,LocalDate.now());
    }

    public Report humiTempIlluReport() throws IOException, ClassNotFoundException {
        float humi = 0,temp = 0; int illu= 0; LocalDate date = LocalDate.now();
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Temperature,Created FROM `inlämning1-sysintegration`.`temperature` WHERE Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`temperature` )"))
        {
            while (resultSet.next())
            {
                temp = resultSet.getFloat("Temperature");
                date = resultSet.getDate("Created").toLocalDate();
                System.out.println("temperature: "+temp+" date: "+date);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Humidity FROM `inlämning1-sysintegration`.`humidity` WHERE Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`humidity` )"))
        {
            while (resultSet.next())
            {
                humi = resultSet.getFloat("Humidity");

                System.out.println("humidity: "+humi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Lightning FROM `inlämning1-sysintegration`.`lightning` WHERE Created= (SELECT MAX(Created) FROM `inlämning1-sysintegration`.`lightning` )"))
        {
            while (resultSet.next())
            {
                illu = resultSet.getInt("Lightning");

                System.out.println("Lightning: "+illu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Report(humi,temp,illu,date);
    }

    public WeeklyReport getWeekHumidity() throws IOException, ClassNotFoundException {
        float humi;
        double avrage = 0;
        LocalDate date ;
        HashMap<LocalDate, Float> map = new HashMap<>();

        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Humidity,Created FROM `inlämning1-sysintegration`.`humidity` where Created>'2020-05-05 10:02:47'")) {
            while (resultSet.next()) {
                humi = resultSet.getFloat("Humidity");
                date = resultSet.getDate("Created").toLocalDate();
                System.out.println("Humidity: " + humi + " date: " + date);
                map.put(date,humi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT AVG(Humidity)  FROM `inlämning1-sysintegration`.`humidity`")) {
            while (resultSet.next()) {
                avrage = resultSet.getFloat("AVG(Humidity)");
                System.out.println("Avrage Humidity: " + avrage);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  new WeeklyReport(map,avrage);
    }
    public WeeklyReport getWeekTemperature() throws IOException, ClassNotFoundException {
        float temp;
        double avrage = 0;
        LocalDate date ;
        HashMap<LocalDate, Float> map = new HashMap<>();

        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Temperature,Created FROM `inlämning1-sysintegration`.temperature where Created>'2020-05-05 10:02:47'")) {
            while (resultSet.next()) {
                temp = resultSet.getFloat("Temperature");
                date = resultSet.getDate("Created").toLocalDate();
                System.out.println("Temperature: " + temp + " date: " + date);
                map.put(date,temp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT AVG(Temperature)  FROM `inlämning1-sysintegration`.temperature")) {
            while (resultSet.next()) {
                avrage = resultSet.getFloat("AVG(Temperature)");
                System.out.println("Avrage Temperature: " + avrage);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  new WeeklyReport(map,avrage);
    }

    public WeeklyReport getWeekIllumination() throws IOException, ClassNotFoundException {
        float illu;
        double avrage = 0;
        LocalDate date ;
        HashMap<LocalDate, Float> map = new HashMap<>();

        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Lightning,Created FROM `inlämning1-sysintegration`.lightning where Created>'2020-05-05 10:02:47'")) {
            while (resultSet.next()) {
                illu = resultSet.getFloat("Lightning");
                date = resultSet.getDate("Created").toLocalDate();
                System.out.println("Temperature: " + illu + " date: " + date);
                map.put(date, illu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"), properties.getProperty("password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT AVG(Lightning)  FROM `inlämning1-sysintegration`.lightning")) {
            while (resultSet.next()) {
                avrage = resultSet.getFloat("AVG(Lightning)");
                System.out.println("Avrage Temperature: " + avrage);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  new WeeklyReport(map,avrage);
    }

    public int getElectricityCost() throws IOException, ClassNotFoundException {
        int electricityConsumption;
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\melko\\Desktop\\WebSocketDemoNoDisconnect-master\\Inämning1-systemintegration\\src\\main\\java\\Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(properties.getProperty("ConnectionString"),
                properties.getProperty("name"),properties.getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(Electricity)FROM `inlämning1-sysintegration`.electricity WHERE Created > '2020-05-05 10:03:13'"))
        {
            while (resultSet.next())
            {
                electricityConsumption = resultSet.getInt("SUM(Electricity)");
                System.out.println("Total electricity consumed:" +electricityConsumption);
                return electricityConsumption;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
