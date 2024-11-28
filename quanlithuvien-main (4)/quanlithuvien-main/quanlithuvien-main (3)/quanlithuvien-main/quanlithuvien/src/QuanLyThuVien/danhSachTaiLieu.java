import java.io.*;
import java.util.ArrayList;

public class danhSachTaiLieu {
    private ArrayList<Document> DSTL;

    public danhSachTaiLieu() {
        DSTL = new ArrayList<>();
    }
    
    public ArrayList<Document> getDSTL() {
    	return this.DSTL;
    }

    public void them(Document tailieu) {
        DSTL.add(tailieu);
        System.out.println("Da them tai lieu: " + tailieu.getName());
    }

    public void xoa(String id) {
        boolean removed = false;
        for (int i = 0; i < DSTL.size(); i++) {
            if (DSTL.get(i).getId().equalsIgnoreCase(id)) {
                DSTL.remove(i);
                removed = true;
                System.out.println("Da xoa tai lieu: " + id);
                break;
            }
        }
        if (!removed) {
            System.out.println("Khong tim thay tai lieu de xoa: " + id);
        }
    }

    public void sua(String id) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getId().equalsIgnoreCase(id)) {
                System.out.println("Thong tin hien tai cua tai lieu:");
                tl.xuat();
                System.out.println("Nhap thong tin moi:");
                tl.nhap();
                found = true;
                System.out.println("Da sua tai lieu: " + id);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu de sua: " + id);
        }
    }

    public void searchbyName(String ten) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getName().equalsIgnoreCase(ten)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi ten: " + ten);
        }
    }

    public void searchbyID(String ma) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getId().equalsIgnoreCase(ma)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi ID: " + ma);
        }
    }

    public void searchbyYear(int year) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getNamxuatban() == year) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi nam xuat ban: " + year);
        }
    }
    
    public void searchbyType(String type) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getType().equalsIgnoreCase(type)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi the loai: " + type);
        }
    }

    public void searchbyAuthor(String tacgia) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getTacgia().equalsIgnoreCase(tacgia)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi tac gia: " + tacgia);
        }
    }

    public void searchbyBookId(String bookID) {
        boolean found = false;
        for (Document doc : DSTL) { 
            if (doc instanceof Book) { 
                Book book = (Book) doc;
                if (book.getBookid().equalsIgnoreCase(bookID)) { 
                    book.xuat();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với Book ID: " + bookID);
        }
    }
    public void searchbySoPhatHanh(int key) {
        boolean found = false;
        for (Document doc : DSTL) { 
            if (doc instanceof Magazine) { 
                Magazine tc = (Magazine) doc;
                if (tc.getSoPhatHanh() == key) { 
                    tc.xuat();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với Book ID: " + key);
        }
    }
    public void searchbyDiaId(String diaID) {
        boolean found = false;
        for (Document doc : DSTL) { 
            if (doc instanceof Dia) { 
                Dia dia = (Dia) doc;
                if (dia.getDiaId().equalsIgnoreCase(diaID)) { 
                    dia.xuat();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với Book ID: " + diaID);
        }
    }

    
    public void xuatDanhSach() {
        if (DSTL.isEmpty()) {
            System.out.println("Danh sach tai lieu trong!");
            return;
        }
    
        // Tách danh sách theo loại tài liệu
        ArrayList<Document> books = new ArrayList<>();
        ArrayList<Document> magazines = new ArrayList<>();
        ArrayList<Document> dias = new ArrayList<>();
    
        for (Document doc : DSTL) {
            if (doc instanceof Book) {
                books.add(doc);
            } else if (doc instanceof Magazine) {
                magazines.add(doc);
            } else if (doc instanceof Dia) {
                dias.add(doc);
            }
        }
    
        // Xuất danh sách theo thứ tự: Book -> Magazine -> Dia
        System.out.println("=== Danh sach Sach ===");
        for (Document book : books) {
            book.xuat();
            System.out.println("-------------------");
        }
    
        System.out.println("=== Danh sach Tap chi ===");
        for (Document magazine : magazines) {
            magazine.xuat();
            System.out.println("-------------------");
        }
    
        System.out.println("=== Danh sach Dia ===");
        for (Document dia : dias) {
            dia.xuat();
            System.out.println("-------------------");
        }
    }
    

public void ghiVaoFile(String tenTep) throws IOException{
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenTep))) {
        if (DSTL.isEmpty()) {
            bw.write("Danh sách tài liệu trống!");
            return;
        }

        // Tách danh sách theo loại tài liệu
        ArrayList<Book> sachList = new ArrayList<>();
        ArrayList<Magazine> tapChiList = new ArrayList<>();
        ArrayList<Dia> diaList = new ArrayList<>();

        for (Document doc : DSTL) {
            if (doc instanceof Book) {
                sachList.add((Book) doc);
            } else if (doc instanceof Magazine) {
                tapChiList.add((Magazine) doc);
            } else if (doc instanceof Dia) {
                diaList.add((Dia) doc);
            }
        }

        // Ghi danh sách sách
        bw.write("=== Danh sach Sach ===");
        bw.newLine();
        for (Book sach : sachList) {
            bw.write(sach.toString());
            bw.newLine();
            bw.write("-------------------");
            bw.newLine();
        }

        // Ghi danh sách tạp chí
        bw.write("=== Danh sach Tap Chi ===");
        bw.newLine();
        for (Magazine tapChi : tapChiList) {
            bw.write(tapChi.toString()); // Giả sử bạn đã override phương thức toString()
            bw.newLine();
            bw.write("-------------------");
            bw.newLine();
        }

        // Ghi danh sách đĩa
        bw.write("=== Danh sach Dia ===");
        bw.newLine();
        for (Dia dia : diaList) {
            bw.write(dia.toString()); // Giả sử bạn đã override phương thức toString()
            bw.newLine();
            bw.write("-------------------");
            bw.newLine();
        }
        bw.close();

        System.out.println("Da ghi du lieu vao file: " + tenTep);
    } catch (IOException e) {
        System.out.println("Loi khi ghi file: " + e.getMessage());
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

            String loaiTaiLieu = arr[0];
            String ten = "", id = "", maSoKe = "", nam = "", soLuong = "", tacGia = "", theLoai = "", tinhTrang = "", maSach = "", ngonNgu = "";
            String soPhatHanh = "", thangPhatHanh = "",bookId = "" , dungLuong = "", loaiDia = "";

            for (String pair : arr) {
                String[] keyValue = pair.split(": ");
                if (keyValue.length == 2) {
                    switch (keyValue[0].trim()) {
                        case "Ten":
                            ten = keyValue[1].trim();
                            break;
                        case "ID":
                            id = keyValue[1].trim();
                            break;
                        case "Ma so ke":
                            maSoKe = keyValue[1].trim();
                            break;
                        case "Nam xuat ban":
                            nam = keyValue[1].trim();
                            break;
                        case "So luong":
                            soLuong = keyValue[1].trim();
                            break;
                        case "Tac gia":
                            tacGia = keyValue[1].trim();
                            break;
                        case "The loai":
                            theLoai = keyValue[1].trim();
                            break;
                        case "Tinh trang":
                            tinhTrang = keyValue[1].trim();
                            break;
                        case "Ma sach":
                            maSach = keyValue[1].trim();
                            break;
                        case "Ngon ngu":
                            ngonNgu = keyValue[1].trim();
                            break;
                        case "So phat hanh":
                            soPhatHanh = keyValue[1].trim();
                            break;
                        case "Thang phat hanh":
                            thangPhatHanh = keyValue[1].trim();
                            break;
                        case"Ma so Dia":
                            bookId = keyValue[1].trim();
                            break;
                        case"Dung luong":
                            dungLuong = keyValue[1].trim();
                            break;
                        case"Loai dia":
                            loaiDia = keyValue[1].trim();
                            break;
                        default:
                            System.out.println("Khong nhan dien duoc khoa: " + keyValue[0].trim());
                    }
                }
            }

            try {
                switch (loaiTaiLieu) {
                    case "Book":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !maSach.isEmpty() && !ngonNgu.isEmpty()) {
                            DSTL.add(new Book(
                                id, ten, maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, maSach, ngonNgu
                            ));
                        } else {
                            System.out.println("Du lieu sach khong hop le: " + line);
                        }
                        break;
                    case "Magazine":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !soPhatHanh.isEmpty() &&
                            !thangPhatHanh.isEmpty() && !ngonNgu.isEmpty()) {
                            DSTL.add(new Magazine(
                                id, ten, maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, Integer.parseInt(soPhatHanh),
                                Integer.parseInt(thangPhatHanh), ngonNgu
                            ));
                        } else {
                            System.out.println("Du lieu tap chi khong hop le: " + line);
                        }
                        break;
                    case "Dia":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !bookId.isEmpty()&&!dungLuong.isEmpty() &&
                            !loaiDia.isEmpty()) {
                            DSTL.add(new Dia(
                                id, ten , maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, bookId, Double.parseDouble(dungLuong), loaiDia
                            ));
                        } else {
                            System.out.println("Du lieu dia khong hop le: " + line);
                        }
                        break;
                    default:
                        System.out.println("Loai tai lieu khong hop le: " + loaiTaiLieu);
                }
            } catch (NumberFormatException e) {
                System.out.println("Du lieu khong hop le trong file (sai dinh dang so): " + e.getMessage());
            }
        }
        System.out.println("Da doc du lieu tu file: " + fileName);
    } catch (IOException e) {
        System.out.println("Loi khi doc file: " + e.getMessage());
    }
}
}



