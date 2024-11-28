import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class HoaDonManager {
    private List<HoaDon> danhSachHoaDon = new ArrayList<>();
    private int currentHoaDonId = 1;  // Mã hóa đơn bắt đầu từ 1

    // Phương thức tạo hóa đơn mới
    public void taoHoaDon(Scanner scanner) {
        System.out.print("Nhập tên nhân viên: ");
        String tenNhanVien = scanner.nextLine();
        try(Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(tenNhanVien)){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Tên không tồn tại. Vui lòng nhập lại");
            }
        }
        System.out.print("Nhập mã nhân viên: ");
        String maNhanVien = scanner.nextLine();
        try(Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(maNhanVien)){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Mã không tồn tại. Vui lòng nhập lại");
            }
        }
        System.out.print("Nhập tên độc giả: ");
        String tenDocGia = scanner.nextLine();
        try(Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(tenDocGia)){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Tên không tồn tại. Vui lòng nhập lại");
            }
        }
        System.out.print("Nhập mã độc giả: ");
        String maDocGia = scanner.nextLine();
        try(Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(maDocGia)){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Mã không tồn tại. Vui lòng nhập lại");
            }
        }
        System.out.print("Nhập tài liệu mượn: ");
        String taiLieuMuon = scanner.nextLine();
        try(Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.contains(taiLieuMuon)){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Không tìm thấy kết quả. Vui lòng nhập lại");
            }
        }
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayMuon = null, ngayTra = null;
        System.out.print("Nhập ngày mượn (dd/MM/yyyy): ");
        try {
            ngayMuon = sdf.parse(scanner.nextLine());
        } catch (ParseException e){
            System.out.println("Ngày mượn không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yy");
        }
        System.out.print("Nhập ngày trả (dd/MM/yyyy): ");
        try {
            ngayTra = sdf.parse(scanner.nextLine());
        } catch (ParseException e){
            System.out.println("Ngày trả không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yy");
        }
        
        String maHoaDon = String.format("%03d", currentHoaDonId);  // Tạo mã hóa đơn 001, 002, ...
        HoaDon hoaDon = new HoaDon(maHoaDon, tenNhanVien, maNhanVien, tenDocGia, maDocGia, taiLieuMuon, soLuong, ngayMuon, ngayTra);
        
        danhSachHoaDon.add(hoaDon);
        currentHoaDonId++;
    }

    // Phương thức lưu danh sách hóa đơn vào file
    public void luuHoaDonVaoFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (HoaDon hoaDon : danhSachHoaDon) {
                writer.write(hoaDon.toString());
                writer.newLine();
            }
        }
    }

    // Phương thức hiển thị tất cả hóa đơn
    public void hienThiHoaDon() {
        for (HoaDon hoaDon : danhSachHoaDon) {
            System.out.println(hoaDon);
        }
    }
}
