import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee extends Person{
	String role;
	String shift;
	private static Scanner scanner = new Scanner(System.in);
	
	// constructor	
	public Employee() {
		super();
		this.role = null;
		this.shift = null;
	}
	public Employee(String id, String name, String address, String gender, String dob, String role, String shift) {
		super(id, name, address, gender, dob);
		this.role = role;
		this.shift = shift;
	}
	
	// implemented methods
		public void nhap() {
	        System.out.print("Nhap ten nhan vien: ");
	        this.setname(scanner.nextLine());
	        System.out.print("Nhap dia chi cua nhan vien: ");
	        this.setaddress(scanner.nextLine());
	        System.out.print("Nhap gioi tinh cua nhan vien: ");
	        this.setgender(scanner.nextLine());
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        sdf.setLenient(false); 
	        boolean validDate = false;
	        while (!validDate) {
	            System.out.print("Nhap ngay sinh cua nhan vien (dd/MM/yyyy): ");
	            String input = scanner.nextLine();
	            try {
	                setdob(sdf.parse(input));
	                validDate = true; 
	            } catch (ParseException e) {
	                System.out.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
	            }
	        }
	        System.out.print("Nhap vi tri cua nhan vien: ");
	        this.setrole(scanner.nextLine());
	        System.out.print("Nhap ca lam cua nhan vien: ");
	        this.setshift(scanner.nextLine());
	    }
		public void xuat() {
			System.out.printf("id: %s\n", this.getid());
			System.out.println("name: " + this.getname());
			System.out.println("address: " + this.getaddress());
			System.out.println("gender: " + this.getgender());
	        if (getdob() != null) {
	            SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
	            String formattedDate = sdfOutput.format(getdob());
	            System.out.println("Ngày sinh của bạn: " + formattedDate);
	        } else {
	            System.out.println("date of birth: khong xac dinh do loi nhap lieu");
	        }
			System.out.println("role: " + this.getrole());	
			System.out.println("shift: " + this.getshift());	
		}

	
	// getter and setter
	public String getid() {
		return super.getid();
	}
	public String getname() {
		return super.getname();
	}
	public String getaddress() {
		return super.getaddress();
	}
	public String getgender() {
		return super.getgender();
	}		
	public Date getdob() {
		return super.getdob();
	}
	public String getrole() {
		return this.role;
	}
	public String getshift() {
		return this.shift;
	}
	public void setname(String name) {
		super.setname(name);
	}
	public void setaddress(String address) {
		super.setaddress(address);
	}
	public void setgender(String gender) {
		super.setgender(gender);
	}
	public void setdob(Date dob) {
		super.setdob(dob);
	}
	public void setrole(String role) {
		this.role = role;
	}
	public void setshift(String shift) {
		this.shift = shift;
	}
}
