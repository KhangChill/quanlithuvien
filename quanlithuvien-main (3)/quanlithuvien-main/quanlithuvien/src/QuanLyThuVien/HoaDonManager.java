import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HoaDonManager {
    private List<HoaDon> danhSachHoaDon = new ArrayList<>();
    private int currentHoaDonId = 1;  // Mã hóa đơn bắt đầu từ 1

    // Phương thức tạo hóa đơn mới
    public void taoHoaDon(Scanner scanner) {
        System.out.print("Nhập tên nhân viên: ");
        String tenNhanVien = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String maNhanVien = scanner.nextLine();
        System.out.print("Nhập tên độc giả: ");
        String tenDocGia = scanner.nextLine();
        System.out.print("Nhập mã độc giả: ");
        String maDocGia = scanner.nextLine();
        System.out.print("Nhập tài liệu mượn: ");
        String taiLieuMuon = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Nhập ngày mượn (dd/MM/yyyy): ");
        Date ngayMuon = new Date(scanner.nextLine());  // Chú ý kiểm tra lại cách chuyển đổi
        System.out.print("Nhập ngày trả (dd/MM/yyyy): ");
        Date ngayTra = new Date(scanner.nextLine());  // Chú ý kiểm tra lại cách chuyển đổi

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
