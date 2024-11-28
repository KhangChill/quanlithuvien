import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Person implements NhapXuat {
	private String id;
	private String name;
	private String address;
	private String gender;
	private Date dob;
    private ArrayList<Document> danhSachTaiLieuMuon = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	// constructor
	public Person() {
		this.id =  "";
		this.name = "";
		this.address = "";
		this.gender = "";
		this.dob = null;
	}
	public Person(String id, String name, String address, String gender, String dob) {
		this.id =  id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.dob = sdf.parse(dob);
		} catch (ParseException e) {
            System.out.println("\nĐịnh dạng ngày không hợp lệ!");
		}
	}
	
	// implemented methods
	public void nhap() {
        System.out.print("Nhap ten nhan su: ");
        this.name = scanner.nextLine();
        System.out.print("Nhap dia chi cua nhan su: ");
        this.address = scanner.nextLine();
        System.out.print("Nhap gioi tinh cua nhan su: ");
        this.gender = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); 
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Nhap ngay sinh cua nhan su (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            try {
                dob = sdf.parse(input);
                validDate = true; 
            } catch (ParseException e) {
                System.out.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
            }
        }
    }
	public void xuat() {
		System.out.print("ID: " + this.id + "; ");
		System.out.print("Ten: %s; " + this.name + "; ");
		System.out.print("Dia chi: " + this.address + "; ");
		System.out.print("Gioi tinh: " + this.gender + "; ");
        if (dob != null) {
            SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdfOutput.format(dob);
            System.out.println("Ngay sinh: " + formattedDate);
        } else {
            System.out.println("Ngay sinh khong xac dinh do loi nhap lieu!");
        }
	}
	
	// getter and setter
	public String getid() {
		return this.id;
	}
	public String getname() {
		return this.name;
	}
	public String getaddress() {
		return this.address;
	}
	public String getgender() {
		return this.gender;
	}
	public Date getdob() {
		return this.dob;
	}
	public void setid(String id) {
		this.id = id;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public void setdob(Date dob) {
		this.dob = dob;
	}
	
	public void muonTaiLieu(Document document) {
        danhSachTaiLieuMuon.add(document);
        System.out.println("Da muon tai lieu: " + document.getName());
    }

    public void hienThiDanhSachMuon() {
        if (danhSachTaiLieuMuon.isEmpty()) {
            System.out.println("Chua muon tai lieu nao!");
        } else {
            System.out.println("Danh sach tai lieu da muon:");
            for (Document doc : danhSachTaiLieuMuon) {
                doc.xuat();
                System.out.println();
            }
        }
    }

    public ArrayList<Document> getDanhSachTaiLieuMuon() {
        return this.danhSachTaiLieuMuon;
    }
	
}
