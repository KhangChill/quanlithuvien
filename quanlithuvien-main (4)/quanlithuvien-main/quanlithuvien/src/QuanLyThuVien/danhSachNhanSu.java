import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class danhSachNhanSu {
	public ArrayList<Person> listofperson;
	
	// constructor
	public danhSachNhanSu() {
		listofperson = new ArrayList<>();
	}
	
	public ArrayList<Person> getlistofperson() {
		return this.listofperson;
	}
	
	public void them(Person p) {
		listofperson.add(p);
	}
	
	public void xoa(String id) {
	    boolean found = false;
	    for (int i = 0; i < listofperson.size(); i++) {
	        if (listofperson.get(i).getid().equals(id)) {
	            found = true;
	            listofperson.remove(i);
	            System.out.println("Da xoa thanh cong ID " + id);
	            break;
	        }
	    }
	    if (!found) {
	        System.out.printf("Khong tim thay id %s\n", id);
	    }
	}	
	public void sua(String id) {
        boolean found = false;
        for (Person p : listofperson) {
            if (p.getid().equalsIgnoreCase(id)) {
                System.out.print("Thong tin hien tai:");
                p.xuat();
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Nhap thong tin moi:");
                p.nhap();
                found = true;
                System.out.println("Da sua thanh cong id " + id);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay id " + id);
        }
    }
	
	public Person searchbyid(String id) {
		for(Person p : listofperson) {
			if (p.getid().equals(id)) {
				return p;
			}
		}
		System.out.printf("Khong tim thay id %s\n", id);
		return null;
	}
	
	public Person searchbyname(String key) {
	    boolean found = false;
	    for(Person p : listofperson) {
	        if(p.getname().toLowerCase().contains(key.toLowerCase())) {
	            found = true;
	            return p;
	        }
	    }
	    if (found) {
	        System.out.printf("\nTim thay ket qua voi ten %s\n", key);
	    } else {
	        System.out.printf("Khong tim thay nguoi voi ten %s\n", key);
	    }
		return null;
	}
	
	
	public void xuatDanhSachNhanSu() {
		if (listofperson.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        ArrayList<Person> reader = new ArrayList<>();
        ArrayList<Person> employee = new ArrayList<>();
    
        for (Person p : listofperson) {
            if (p instanceof Reader) {
                reader.add(p);
            } else if (p instanceof Employee) {
                employee.add(p);
            }
        }
        System.out.println("=== Danh sach doc gia ===");
        for (Person p : reader) {
            p.xuat();
        }
    
        System.out.println("=== Danh sach nhan vien ===");
        for (Person p : employee) {
            p.xuat();
        }
    }    
	
	public void ghiVaoFile(String fileName) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
	        for (Person p : this.listofperson) {
	            StringBuilder line = new StringBuilder();
	            if (p instanceof Employee) {
	                Employee nhanVien = (Employee) p;
	                line.append("Employee; ID: ").append(nhanVien.getid())
	                    .append("; Ten: ").append(nhanVien.getname())
	                    .append("; Dia chi: ").append(nhanVien.getaddress())
	                    .append("; Gioi tinh: ").append(nhanVien.getgender())
	                    .append("; Ngay sinh: ").append(sdf.format(nhanVien.getdob()))
	                    .append("; Vi tri: ").append(nhanVien.getrole())
	                    .append("; Ca lam: ").append(nhanVien.getshift());
	            } else if (p instanceof Reader) {
	                Reader docGia = (Reader) p;
	                line.append("Reader; ID: ").append(docGia.getid())
	                    .append("; Ten: ").append(docGia.getname())
	                    .append("; Dia chi: ").append(docGia.getaddress())
	                    .append("; Gioi tinh: ").append(docGia.getgender())
	                    .append("; Ngay sinh: ").append(sdf.format(docGia.getdob()));
	            }
	            bw.write(line.toString());
	            bw.newLine();
	        }
	        System.out.println("Da ghi du lieu vao file " + fileName);
	    } catch (IOException e) {
	        System.out.println("Loi khi ghi file " + e.getMessage());
	    }
	}
}
