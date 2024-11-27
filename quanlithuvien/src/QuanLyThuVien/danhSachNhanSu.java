import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
		for(Person p : listofperson) {
			if (p.getid().equals(id)) {
				found = true;
				listofperson.remove(p);
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
	
	public void searchbyname(String key) {
	    boolean found = false;
	    for(Person p : listofperson) {
	        if(p.getname().toLowerCase().contains(key.toLowerCase())) {
	            found = true;
	            p.xuat(); 
	        }
	    }
	    if (found) {
	        System.out.printf("\nTim thay ket qua voi ten %s\n", key);
	    } else {
	        System.out.printf("Khong tim thay nguoi voi ten %s\n", key);
	    }
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
        System.out.println("=== Danh sach nguoi doc ===");
        for (Person p : reader) {
            p.xuat();
            System.out.println("-------------------");
        }
    
        System.out.println("=== Danh sach nhan vien ===");
        for (Person p : employee) {
            p.xuat();
            System.out.println("-------------------");
        }
    }    
	
	public void ghiVaoFile(String filenhanvien, String filedocgia) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    try (BufferedWriter bwEmployee = new BufferedWriter(new FileWriter(filenhanvien))) {
	        for (Person p : this.listofperson) {
	            if (p instanceof Employee) {
	                Employee nhanVien = (Employee) p;
	                StringBuilder line = new StringBuilder();
	                line.append("Employee; ID: ").append(nhanVien.getid()).append("; Ten: ").append(nhanVien.getname()).append("; Dia chi: ").append(nhanVien.getaddress()).append("; Gioi tinh: ").append(nhanVien.getgender()).append("; Ngay sinh: ").append(sdf.format(nhanVien.getdob())).append("; Vi tri: ").append(nhanVien.getrole()).append("; Ca lam: ").append(nhanVien.getshift());
	                bwEmployee.write(line.toString());
	                bwEmployee.newLine();
	            }
	        }
	        System.out.println("Da ghi du lieu nhan vien vao file: " + filenhanvien);
	    } catch (IOException e) {
	        System.out.println("Loi khi ghi file nhan vien: " + e.getMessage());
	    }
	    try (BufferedWriter bwReader = new BufferedWriter(new FileWriter(filedocgia))) {
	        for (Person p : this.listofperson) {
	            if (p instanceof Reader) {
	                Reader docGia = (Reader) p;
	                StringBuilder line = new StringBuilder();
	                line.append("Reader; ID: ").append(docGia.getid()).append("; Ten: ").append(docGia.getname()).append("; Dia chi: ").append(docGia.getaddress()).append("; Gioi tinh: ").append(docGia.getgender()).append("; Ngay sinh: ").append(sdf.format(docGia.getdob())).append("; Email: ").append(docGia.getemail()).append("; So dien thoai: ").append(docGia.getphone());
	                bwReader.write(line.toString());
	                bwReader.newLine();
	            }
	        }
	        System.out.println("Da ghi du lieu doc gia vao file: " + filedocgia);
	    } catch (IOException e) {
	        System.out.println("Loi khi ghi file doc gia: " + e.getMessage());
	    }
	}
	
	public void docTuFile(String fileName) throws IOException {	    
	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] arr = line.split("; ");
	            if (arr.length < 2) {
	                System.out.println("Du lieu khong hop le: " + line);
	                continue;
	            }

	            String loaiNguoiDung = arr[0].trim();
	            String id = "", ten = "", diaChi = "", gioiTinh = "", ngaySinh = "", email = "", soDienThoai = "", viTri = "", caLam = "";

	            for (String pair : arr) {
	                String[] keyValue = pair.split(": ");
	                if (keyValue.length == 2) {
	                    switch (keyValue[0].trim()) {
	                        case "ID":
	                            id = keyValue[1].trim();
	                            break;
	                        case "Ten":
	                            ten = keyValue[1].trim();
	                            break;
	                        case "Dia chi":
	                            diaChi = keyValue[1].trim();
	                            break;
	                        case "Gioi tinh":
	                            gioiTinh = keyValue[1].trim();
	                            break;
	                        case "Ngay sinh":
	                            ngaySinh = keyValue[1].trim();
	                            break;
	                        case "Email":
	                            email = keyValue[1].trim();
	                            break;
	                        case "So dien thoai":
	                            soDienThoai = keyValue[1].trim();
	                            break;
	                        case "Vi tri":
	                            viTri = keyValue[1].trim();
	                            break;
	                        case "Ca lam":
	                            caLam = keyValue[1].trim();
	                            break;
	                        default:
	                            System.out.println("Khong nhan dien duoc khoa: " + keyValue[0].trim());
	                    }
	                }
	            }

	            switch (loaiNguoiDung) {
				    case "Employee":
				        if (!id.isEmpty() && !ten.isEmpty() && !diaChi.isEmpty() && !gioiTinh.isEmpty() && !ngaySinh.isEmpty() && !viTri.isEmpty() && !caLam.isEmpty()) {
				            Employee employee = new Employee(id, ten, diaChi, gioiTinh, ngaySinh, viTri, caLam);
				            listofperson.add(employee);
				        } else {
				            System.out.println("Du lieu khong hop le: " + line);
				        }
				        break;
				    case "Reader":
				        if (!id.isEmpty() && !ten.isEmpty() && !diaChi.isEmpty() && !gioiTinh.isEmpty() && !ngaySinh.isEmpty() && !email.isEmpty() && !soDienThoai.isEmpty()) {
				            Reader reader = new Reader(id, ten, diaChi, gioiTinh, ngaySinh, email, soDienThoai);
				            listofperson.add(reader);
				        } else {
				            System.out.println("Du lieu khong hop le: " + line);
				        }
				        break;
				    default:
				        System.out.println("Loai nhan su khong hop le: " + loaiNguoiDung);
				}
	        }
	        System.out.println("Da doc thanh cong du lieu tu file: " + fileName);
	    } catch (IOException e) {
	        System.out.println("Loi khi doc file: " + e.getMessage());
	    }
	}
}