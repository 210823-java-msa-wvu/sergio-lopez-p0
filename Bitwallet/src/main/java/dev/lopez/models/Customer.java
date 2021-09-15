package dev.lopez.models;

public class Customer {

    //instance variables (same as our database columns) variable number: 7
    private Integer id;
    private String username;
    private String password;
    private Integer balance;



    //constructors




   public Customer (String username, String pass_word){
       this.username = username;
       this.password = pass_word;
   }


    public Customer(Integer id, String username, String pass_word){
        this.id = id;
        this.username = username;
        this.password = pass_word;


    }

    public Customer() {
    }


    public Customer(Integer id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;



    }

    public Customer(Integer id,  String username, String password, Integer balance, boolean isAdmin ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;



    }

    public Customer(Integer id, String firstname, String lastname, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;

    }
    //getters and setters




    public Integer getId() {
       return id;
    }

    public void setId(Integer id) {

       this.id = id;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +

                ", username='" + username + '\'' +
                ", pass_word='" + password + '\'' +
                ", balance=" + balance +

                '}';
    }
}
