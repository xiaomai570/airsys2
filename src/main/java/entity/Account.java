package entity;

public class Account {
         private int id;
         private  String name;
         private double balance;
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
		
		public Account(String name, double balance) {
			super();
			this.name = name;
			this.balance = balance;
		}

		public Account() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
		}
         
         
         
         
         
         
         
         
         
         
         
         
         
         
}
    