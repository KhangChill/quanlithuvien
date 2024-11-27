import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reader extends Person{
	String email;
	String phone;
	private static Scanner scanner = new Scanner(System.in);
	
	// constructor
	public Reader() {
		super();
		this.email = null;
		this.phone = null;
	}
	public Reader(String id,String name, String address, String gender, String dob, String email, String phone) {
		super(id, name, address, gender, dob);
		this.email = email;
		this.phone = phone;
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
            System.out.print("Nhap ngay sinh cua nhan su (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            try {
                setdob(sdf.parse(input));
                validDate = true; 
            } catch (ParseException e) {
                System.out.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
            }
        }
        System.out.print("Nhap email cua nhan vien: ");
        this.setemail(scanner.nextLine());
        System.out.print("Nhap so dien thoai cua nhan vien: ");
        this.setphone(scanner.nextLine());
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
		System.out.println("email: " + this.getemail());	
		System.out.println("phone: " + this.getphone());	
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
	public String getemail() {
		return this.email;
	}
	public String getphone() {
		return this.phone;
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
	public void setemail(String email) {
		this.email = email;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}	
}