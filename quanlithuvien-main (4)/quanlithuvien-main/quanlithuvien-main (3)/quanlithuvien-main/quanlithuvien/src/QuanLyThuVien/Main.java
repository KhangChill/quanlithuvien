import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static danhSachNhanSu dsns = new danhSachNhanSu();
    private static danhSachTaiLieu dstl = new danhSachTaiLieu(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("----------------------HE THONG QUAN LY THU VIEN----------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== MENU CHINH ===");
            System.out.println("1. Quan ly Nguoi dung");
            System.out.println("2. Quan ly Tai lieu");
            System.out.println("3. Quan ly Hoa don");
            System.out.println("4. Thoat");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quanLyNhanSu();
                    break;

                case 2:
                    quanLyTaiLieu();
                    break;

                case 3:
                	quanLyHoaDon();
                    break;

                case 4:
                    System.out.println("Da thoat khoi chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai!");
                    break;
            }
        }
    }

    private static void quanLyNhanSu() {
        Scanner sc = new Scanner(System.in);
    	int subChoice = 0;
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY NHAN SU ===");
            System.out.println("1. Them nhan su");
            System.out.println("2. Xoa nhan su");
            System.out.println("3. Sua nhan su");
            System.out.println("4. Tim kiem nhan su");
            System.out.println("5. Muon tai lieu");
            System.out.println("6. Hien thi danh sach nhan su");
            System.out.println("7. Hien thi tai lieu da muon");
            System.out.println("8. Ghi danh sach tu file txt");
            System.out.println("9. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            
            try {
                System.out.print("Lua chon cua ban: ");
                if (sc.hasNextInt()) { 
                	subChoice = sc.nextInt();
                	sc.nextLine();
                } else {
                    System.out.println("Lua chon khong hop le, vui long nhap so!");
                    sc.next(); 
                    continue; 
                }
            } catch (Exception e) {
                System.out.println("Da xay ra loi: " + e.getMessage());
                sc.next(); 
            }                   
            
            switch (subChoice) {
                case 1:
                    System.out.println("Nhap loai nhan su (1. Nhan vien, 2. Doc gia, 3. Quay lai): ");
                    int typeChoice = 0;
                    try {
                        System.out.print("Lua chon cua ban: ");
                        if (sc.hasNextInt()) { 
                        	typeChoice = sc.nextInt();
                            sc.nextLine(); 
                        } else {
                            System.out.println("Lua chon khong hop le, vui long nhap so!");
                            sc.next(); 
                            continue; 
                        }
                    } catch (Exception e) {
                        System.out.println("Da xay ra loi: " + e.getMessage());
                        sc.next(); 
                    }

                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Employee nhanVien = new Employee();
                        System.out.print("Nhap ID nhan vien: ");
                        String ID = sc.nextLine();
                        boolean check = true;
                        for (Person p : dsns.getlistofperson()) {
                        	if (p.getid().equals(ID)) {
                        		check = false;
                        		System.out.println("ID nay da duoc dung");
                        		break;
                        	}
                        }
                        if (check == true) {
                            nhanVien.setid(ID);
                            nhanVien.nhap();
                            dsns.them(nhanVien);

                        }
                    } else if(typeChoice == 2){
                    	
                        Reader docGia = new Reader();
                        System.out.print("Nhap ID doc gia: ");
                        String ID = sc.nextLine();
                        boolean check = true;
                        for (Person p : dsns.getlistofperson()) {
                        	if (p.getid().equals(ID)) {
                        		check = false;
                        		System.out.println("ID nay da duoc dung");
                        		break;
                        	}
                        }
                        if (check == true) {
                        	docGia.setid(ID);
                        	docGia.nhap();
                            dsns.them(docGia);
                        }
                        
                        
                    } else {
                    	System.out.println("Lua chon khong hop le!");
                        break;
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID nhan su can xoa: ");
                    dsns.xoa(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhap ID nhan su can sua: ");
                    dsns.sua(sc.nextLine());
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("---------------------------------------------------------------------");
                    int searchChoice = 0;
                    try {
                        System.out.print("Lua chon cua ban: ");
                        if (sc.hasNextInt()) { 
                        	searchChoice = sc.nextInt();
                        	sc.nextLine();
                        } else {
                            System.out.println("Lua chon khong hop le, vui long nhap so!");
                            sc.next(); 
                            continue; 
                        }
                    } catch (Exception e) {
                        System.out.println("Da xay ra loi: " + e.getMessage());
                        sc.next(); 
                    }                   

                    try {
                        switch (searchChoice) {
                            case 1:
                            	 System.out.print("Nhap ten nhan su: ");
                                 String searchName = sc.nextLine();                                 
                                 Person personByName = dsns.searchbyname(searchName);
                                 if (personByName != null) {
                                     System.out.println("Tim thay nhan su voi ID: " + searchName);
                                	 personByName.xuat();
                                 } else {
                                     System.out.println("Khong tim thay nhan su voi ID: " + searchName);
                                 }
                                 break;

                            case 2:
                                System.out.print("Nhap ID nhan su: ");
                                String searchId = sc.nextLine();
                                Person personById = dsns.searchbyid(searchId);
                                if (personById != null) {
                                    personById.xuat();
                                } else {
                                    System.out.println("Khong tim thay nhan su voi ID: " + searchId);
                                }
                                break;

                            default:
                                System.out.println("Lua chon khong hop le! Vui long nhap so tuong ung trong menu.");
                        }
                    } catch (Exception e) {
                        System.out.println("Da xay ra loi khi tim kiem: " + e.getMessage());
                    }
                    break;
                
                case 5:
                	System.out.print("Nhap ID nguoi muon: ");
                    String IDmuon = sc.nextLine();
                    Person reader = dsns.searchbyid(IDmuon);
                    if (reader != null) {
                        System.out.print("Nhap ID cua tai lieu can muon: ");
                        String IDtailieumuon = sc.nextLine();
                        for (Document doc : dstl.getDSTL()) {
                        	if (IDtailieumuon.equals(doc.getId())) {
                        		if (doc != null && doc.getSoluong() > 0) {
                                    reader.muonTaiLieu(doc);
                                    doc.setSoluong(doc.getSoluong() - 1);
                                    System.out.println("Da muon tai lieu " + doc.getName() + " thanh cong!");
                                } else {
                                    System.out.println("Tai lieu khong ton tai hoac da het.");
                                }
                            }
                        }
                    } 
                    break;
                case 6:
                    dsns.xuatDanhSachNhanSu();
                    break;
                
                case 7: 
                    System.out.print("Nhap ID nguoi muon: ");
                    String ID = sc.nextLine();
                    Person personToCheck = dsns.searchbyid(ID);

                    if (personToCheck != null) {
                        Person readerToCheck = personToCheck;
                        readerToCheck.hienThiDanhSachMuon();
                    } else {
                        System.out.println("Khong tim thay nguoi voi ID da nhap.");
                    }
                    break;
                    
                case 8:
    				dsns.ghiVaoFile("output_NS.txt"); 
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 9);
}


    private static void quanLyTaiLieu() {
        Scanner sc = new Scanner(System.in);
        int subChoice;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY TAI LIEU ===");
            System.out.println("1. Them tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Sua tai lieu");
            System.out.println("4. Tim kiem tai lieu");
            System.out.println("5. Hien thi danh sach tai lieu");
            System.out.println("6. Doc danh sach tu file txt");
            System.out.println("7. Ghi danh sach tu file txt");
            System.out.println("8. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban la: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    System.out.println("Nhap loai tai lieu (1. Sach, 2. Tap chi, 3. Dia, 4. Lua chon khac): ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Book book = new Book();
                        book.nhap();
                        dstl.them(book);
                    } else if(typeChoice == 2){
                        Magazine tapChi = new Magazine();
                        tapChi.nhap();
                        dstl.them(tapChi);
                    } else if(typeChoice == 3){
                        Dia dia = new Dia();
                        dia.nhap();
                        dstl.them(dia);
                    } else {
                        Document doc = new Document();
                        doc.nhap();
                        dstl.them(doc);
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID tai lieu can xoa: ");
                    String tenXoa = sc.nextLine();
                    dstl.xoa(tenXoa);
                    break;

                case 3:
                    System.out.print("Nhap ID tai lieu can sua: ");
                    String tenSua = sc.nextLine();
                    dstl.sua(tenSua);
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("3. Tim theo nam xuat ban");
                    System.out.println("4. Tim theo tac gia");
                    System.out.println("5. Tim theo the loai");
                    System.out.println("6. Tim theo ma (Sach)");
                    System.out.println("7. Tim theo so phat hanh(Tap Chi)");
                    System.out.println("8. Tim theo ma (Dia)");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Lua chon cua ban: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Nhap ten tai lieu: ");
                            String searchName = sc.nextLine();
                            dstl.searchbyName(searchName);
                            break;
                        case 2:
                            System.out.print("Nhap ID tai lieu: ");
                            String searchId = sc.nextLine();
                            dstl.searchbyID(searchId);
                            break;
                        case 3:
                            System.out.print("Nhap nam xuat ban: ");
                            int searchYear = sc.nextInt();
                            dstl.searchbyYear(searchYear);
                            break;
                        case 4:
                            System.out.print("Nhap ten tac gia: ");
                            String searchAuthor = sc.nextLine();
                            dstl.searchbyAuthor(searchAuthor);
                            break;
                        case 5:
                            System.out.print("Nhap the loai sach: ");
                            String searchType = sc.nextLine();
                            dstl.searchbyType(searchType);
                            break;
                        case 6:
                            System.out.print("Nhap ma so Sach: ");
                            String searchBookId = sc.nextLine();
                            dstl.searchbyBookId(searchBookId);
                            break;
                        case 7:
                            System.out.print("Nhap so phat hanh Tap Chi: ");
                            int searchSoPhatHanh = sc.nextInt();
                            dstl.searchbySoPhatHanh(searchSoPhatHanh);;
                            break;
                        case 8:
                            System.out.print("Nhap ma so Dia: ");
                            String searchDiaid = sc.nextLine();
                            dstl.searchbyDiaId(searchDiaid);;
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case 5:
                    dstl.xuatDanhSach();
                    break;
                case 6:
                    try {
                        dstl.docTuFile("input_TL.txt");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;
                case 7:
                try {
                    dstl.ghiVaoFile("output_TL.txt");
                } catch (IOException e) {
                    System.out.println("Loi khi ghi file: " + e.getMessage());
                }
                case 8:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 8);
    }

private static void quanLyHoaDon() {
	Scanner scanner = new Scanner(System.in);
    List<String> hoaDonList = new ArrayList<>();

    // Đọc các hóa đơn cũ từ file vào danh sách
    hoaDonList = QuanLyHoaDon.loadHoaDonFromFile("output_HD.txt");

    // Xác định số hóa đơn tiếp theo
    int maHoaDonCounter = hoaDonList.size() > 0 ? Integer.parseInt(hoaDonList.get(hoaDonList.size() - 1).split("\"maHoaDon\": \"")[1].split("\"")[0]) + 1 : 1;

    while (true) {
        System.out.println("\nChon chuc nang:");
        System.out.println("1. Tao hoa don");
        System.out.println("2. Xoa tat ca hoa don");
        System.out.println("3. Hien thi tat ca hoa don");
        System.out.println("4. Tim hoa don theo ma hoa don");
        System.out.println("5. Thoat");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Đọc ký tự Enter còn sót lại

        if (choice == 1) {
            // Nhập dữ liệu cho các hóa đơn mới
            boolean tiepTucNhapHoaDon = true;
            while (tiepTucNhapHoaDon) {
                System.out.println("\nNhap thong tin hoa don:");

                // Định dạng mã hóa đơn từ 001 đến 999
                String maHoaDon = String.format("%03d", maHoaDonCounter);
                System.out.println("Ma hoa don: " + maHoaDon);  // Hiển thị mã hóa đơn tự động

                // Kiểm tra mã độc giả và tên độc giả
                String tenDocGia = "";
                String maDocGia = "";
                boolean isValidDocGia = false;

                while (!isValidDocGia) {
                    System.out.print("Ten doc gia: ");
                    tenDocGia = scanner.nextLine();

                    System.out.print("Ma doc gia: ");
                    maDocGia = scanner.nextLine();

                    // Kiểm tra mã độc giả và tên độc giả từ file output_NS.txt
                    if (!QuanLyHoaDon.checkDocGiaExists(maDocGia, tenDocGia)) {
                        System.out.println("Ten doc gia hoac ma doc gia khong khop. Vui long nhap lai!");
                    } else {
                        isValidDocGia = true;
                    }
                }

                // Kiểm tra mã tài liệu
                String maTaiLieu = "";
                boolean isValidTaiLieu = false;

                while (!isValidTaiLieu) {
                    System.out.print("Ma tai lieu: ");
                    maTaiLieu = scanner.nextLine();

                    // Kiểm tra mã tài liệu từ file output_TL.txt
                    if (!QuanLyHoaDon.checkMaTaiLieuExists(maTaiLieu)) {
                        System.out.println("Sai ma tai lieu! Vui long nhap lai ma tai lieu: ");
                    } else {
                        isValidTaiLieu = true;
                    }
                }

                System.out.print("Tien coc: ");
                double tienCoc = scanner.nextDouble();
                scanner.nextLine();  // Đọc ký tự Enter còn sót lại

                // Lấy ngày mượn hiện tại
                String ngayMuon = QuanLyHoaDon.getCurrentDate();

                // Nhập ngày trả và kiểm tra tính hợp lệ
                String ngayTra = "";
                boolean validNgayTra = false;
                while (!validNgayTra) {
                    System.out.print("Ngay tra (dd/MM/yyyy): ");
                    ngayTra = scanner.nextLine();

                    if (!QuanLyHoaDon.isValidDate(ngayMuon) || !QuanLyHoaDon.isValidDate(ngayTra)) {
                        System.out.println("Ngay khong hop le. Vui long nhap lai: ");
                    } else {
                        // So sánh ngày mượn và ngày trả
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date dateNgayMuon = sdf.parse(ngayMuon);
                            Date dateNgayTra = sdf.parse(ngayTra);
                            if (dateNgayTra.before(dateNgayMuon)) {
                                System.out.println("Ngay tra khong the nho hon ngay muon. Vui long nhap lai: ");
                            } else {
                                validNgayTra = true;  // Ngày trả hợp lệ
                            }
                        } catch (ParseException e) {
                            System.out.println("Ngay khong hop le. Vui long nhap lai: ");
                        }
                    }
                }

                // Tạo chuỗi hóa đơn và thêm vào danh sách
                String hoaDon = String.format("{\"maHoaDon\": \"%s\", \"tenDocGia\": \"%s\", \"maDocGia\": \"%s\", \"maTaiLieu\": \"%s\", \"tienCoc\": %.2f, \"ngayMuon\": \"%s\", \"ngayTra\": \"%s\"}",
                                              maHoaDon, tenDocGia, maDocGia, maTaiLieu, tienCoc, ngayMuon, ngayTra);
                hoaDonList.add(hoaDon);

                // Tăng số thứ tự mã hóa đơn
                maHoaDonCounter++;

                // Hỏi người dùng có muốn tiếp tục nhập hóa đơn mới hay không
                System.out.print("Ban co muon nhap them hoa don khong? (y/n): ");
                String tiepTuc = scanner.nextLine();
                if (tiepTuc.toLowerCase().equals("n")) {
                    tiepTucNhapHoaDon = false;  // Nếu chọn 'n', thoát khỏi vòng lặp nhập hóa đơn
                }

                // Nếu số thứ tự đạt đến 999, quay lại 001
                if (maHoaDonCounter > 999) {
                    maHoaDonCounter = 1;
                }
            }

        } else if (choice == 2) {
            // Chức năng xóa tất cả hóa đơn
            System.out.print("Ban co chac muon xoa tat ca hoa don khong? (y/n): ");
            String xacNhan = scanner.nextLine();

            if (xacNhan.toLowerCase().equals("y")) {
                hoaDonList.clear(); // Xóa tất cả hóa đơn trong danh sách
                maHoaDonCounter = 1; // Đánh lại mã hóa đơn từ 001
                System.out.println("Tat ca hoa don da duoc xoa!");
            }

        } else if (choice == 3) {
            // Xuất tất cả hóa đơn
        	QuanLyHoaDon.displayHoaDon(hoaDonList);

        } else if (choice == 4) {
            // Xuất hóa đơn theo mã
            System.out.print("Nhap ma hoa don muon xuat: ");
            String maHoaDon = scanner.nextLine();
            QuanLyHoaDon.displayHoaDonByMa(hoaDonList, maHoaDon);

        } else if (choice == 5) {
            break;  // Thoát khỏi chương trình
        } else {
            System.out.println("Lua chon khong hop le");
        }

        // Lưu tất cả hóa đơn vào file sau khi có thay đổi
        QuanLyHoaDon.saveHoaDonToFile(hoaDonList, "output_HD.txt");
    }

    System.out.println("Tat ca hoa don da duoc luu vao file output_HD.txt !");

}
	
}
