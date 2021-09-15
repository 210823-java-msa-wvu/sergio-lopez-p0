package dev.lopez.repositories;

import dev.lopez.models.Customer;
import dev.lopez.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//This class will be used to define methods that we can use to interact with our Database.
//The methods in this class will be CRUD methods
//C -Create (add or insert into a new record in our database)
//R- Read    (SELECT - retrieve data from the database)
//U - Update
//D - Delete
public class CustomerRepo {

    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    //READ (SELECT- Retrieve data from the database

    public Customer getByUsername (String username){
        //try with resources-- a way to intialize a resource that will then be closed after we are done with it
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from \"CryptoWallet1.1\".customers where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString ("username"),
                        rs.getString ("pass_word"),
                        rs.getInt("balance")
                );

                return c;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Create new customer
    public Customer addCustomer (String username, String password){

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into \"CryptoWallet1.1\".customers values (default, ?, ?, ?) returning *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3,0);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("pass_word"));
                c.setBalance(rs.getInt("balance"));


                return c;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    // Update - Balance
    //Update
    public boolean updateUserBalance(Customer u) {
        try (Connection con = cu.getConnection()) {
            String sql = "update \"CryptoWallet1.1\".customers set balance=? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getBalance());
            ps.setInt(2, u.getId());

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    // Delete
    public void delete(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "delete from \"CryptoWallet1.1\".customers where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Customer> getAllCustomers() {
        //try with resources initialize resource that will be closed after we complete
        try (Connection con = cu.getConnection()) {
            String sql = "select * from \"CryptoWallet1.1\".customers";
            List<Customer> users = new ArrayList<Customer>();

            //to avoid sql injection attacks
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Customer u = new Customer();
                u.setId(result.getInt("id"));
                u.setUsername(result.getString("userName"));
                u.setPassword(result.getString("pass_word"));
                u.setBalance(result.getInt("balance"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    }




