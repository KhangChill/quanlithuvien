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
	}
	public Reader(String id,String name, String address, String gender, String dob, String email, String phone) {
		super(id, name, address, gender, dob);
		this.email = email;
		this.phone = phone;
	}
	
	// implemented methods
	public void nhap() {
        System.out.print("Nhap ten doc gia: ");
        this.setname(scanner.nextLine());
        System.out.print("Nhap dia chi cua doc gia: ");
        this.setaddress(scanner.nextLine());
        System.out.print("Nhap gioi tinh cua doc gia: ");
        this.setgender(scanner.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); 
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Nhap ngay sinh cua doc gia (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            try {
                setdob(sdf.parse(input));
                validDate = true; 
            } catch (ParseException e) {
                System.out.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
            }
        }
    }
	public void xuat() {
		System.out.print("ID: " + this.getid() + "; ");
		System.out.print("Ten: " + this.getname() + "; ");
		System.out.print("Dia chi: " + this.getaddress() + "; ");
		System.out.print("Gioi tinh: " + this.getgender() + "; ");
        if (getdob() != null) {
            SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdfOutput.format(getdob());
            System.out.println("Ngay sinh: " + formattedDate);
        } else {
            System.out.println("Ngay sinh khong xac dinh do loi nhap lieu!");
        }
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
}
