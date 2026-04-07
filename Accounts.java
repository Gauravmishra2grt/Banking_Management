import java.sql.*;
import java.util.Scanner;
public class Accounts {

    private Connection connection;
    private Scanner scanner;
    public Accounts(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;

    }

    public long open_account(String email){
        if(!account_exist(email)) {
            String open_account_query = "INSERT INTO Accounts( full_name, email, balance, security_pin) VALUES( ?, ?, ?, ?)";
            scanner.nextLine();
            System.out.print("Enter Full Name: ");
            String full_name = scanner.nextLine();
            System.out.print("Enter Initial Amount: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Security Pin: ");
            String security_pin = scanner.nextLine();
            try {
                
                PreparedStatement preparedStatement = connection.prepareStatement(open_account_query,Statement.RETURN_GENERATED_KEYS);

                
                preparedStatement.setString(1, full_name);
                preparedStatement.setString(2, email);
                preparedStatement.setDouble(3, balance);
                preparedStatement.setString(4, security_pin);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    ResultSet rs = preparedStatement.getGeneratedKeys();
                    if(rs.next()){
                        return rs.getLong(1);
                    }
                } else {
                    throw new RuntimeException("Account Creation failed!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Account Already Exist");

    }

    public long getAccount_number(String email) {
        String query = "SELECT account_number from Accounts WHERE email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong("account_number");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
    }


    public boolean account_exist(String email){
        String query = "SELECT account_number from Accounts WHERE email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }
}


