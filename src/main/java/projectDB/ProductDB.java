package projectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//5. реализовать метод delete, который будет удалять данные опред. id
public class ProductDB {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "root";

    public static List<Product> select() {
        List<Product> products = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)) {
                String sql = "SELECT * FROM products";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    ResultSet res = preparedStatement.executeQuery();
                    while (res.next()) {
                        int id = res.getInt("id");
                        String name = res.getString("name");
                        double price = res.getDouble("price");
                        Product product = new Product(id, name, price);
                        products.add(product);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    //2. реализовать метод selectOne который будет выводить информацию только об конкретном уникальном номере

    public static Product selectOne(int id) {
        Product product = null;
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)) {
                String sql = "SELECT * FROM products WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        int prodId = res.getInt("id");
                        String name = res.getString("name");
                        double price = res.getDouble("price");
                        product = new Product(prodId,name,price);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    //3. реализовать метод insert который будет добавлять новую колонку в БД
    public static int insert(Product product){
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,login,password)){
                String sql = "INSERT INTO products(name,price) Values(?,?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setDouble(2,product.getPrice());

                    return preparedStatement.executeUpdate();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return 0;
    }

    //4. реализовать метод update, который будет обновлять данные конкретного id
    public static int update(Product product){
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,login,password)){
                String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1,product.getName());
                    preparedStatement.setDouble(2,product.getPrice());
                    preparedStatement.setInt(3,product.getId());

                    return preparedStatement.executeUpdate();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    //5. реализовать метод delete, который будет удалять данные опред. id
    public static int delete(int id){
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,login,password)){
                String sql = "DELETE FROM products WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1,id);

                    return preparedStatement.executeUpdate();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

