import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;


public class HoaDon implements Serializable {
    private String maHoaDon;
    private String tenNhanVien;
    private String maNhanVien;
    private String tenDocGia;
    private String maDocGia;
    private String taiLieuMuon;
    private int soLuong;
    private Date ngayMuon;
    private Date ngayTra;

    // Constructor
    public HoaDon(String maHoaDon, String tenNhanVien, String maNhanVien, 
                  String tenDocGia, String maDocGia, String taiLieuMuon, 
                  int soLuong, Date ngayMuon, Date ngayTra) {
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.maNhanVien = maNhanVien;
        this.tenDocGia = tenDocGia;
        this.maDocGia = maDocGia;
        this.taiLieuMuon = taiLieuMuon;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }
    
   // Getter và Setter cho các thuộc tính
public String getMaHoaDon() {
    return maHoaDon;
}

public void setMaHoaDon(String maHoaDon) {
    this.maHoaDon = maHoaDon;
}

public String getTenNhanVien() {
    return tenNhanVien;
}

public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
}

public String getMaNhanVien() {
    return maNhanVien;
}

public void setMaNhanVien(String maNhanVien) {
    this.maNhanVien = maNhanVien;
}

public String getTenDocGia() {
    return tenDocGia;
}

public void setTenDocGia(String tenDocGia) {
    this.tenDocGia = tenDocGia;
}

public String getMaDocGia() {
    return maDocGia;
}

public void setMaDocGia(String maDocGia) {
    this.maDocGia = maDocGia;
}

public String getTaiLieuMuon() {
    return taiLieuMuon;
}

public void setTaiLieuMuon(String taiLieuMuon) {
    this.taiLieuMuon = taiLieuMuon;
}

public int getSoLuong() {
    return soLuong;
}

public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
}

public Date getNgayMuon() {
    return ngayMuon;
}

public void setNgayMuon(Date ngayMuon) {
    this.ngayMuon = ngayMuon;
}

public Date getNgayTra() {
    return ngayTra;
}

public void setNgayTra(Date ngayTra) {
    this.ngayTra = ngayTra;
}


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Định dạng ngày tháng
        return "Mã Hóa Đơn: " + maHoaDon + "\n" +
               "Tên Nhân Viên: " + tenNhanVien + " - Mã Nhân Viên: " + maNhanVien + "\n" +
               "Tên Độc Giả: " + tenDocGia + " - Mã Độc Giả: " + maDocGia + "\n" +
               "Tài Liệu Mượn: " + taiLieuMuon + "\n" +
               "Số Lượng: " + soLuong + "\n" +
               "Ngày Mượn: " + ngayMuon + "\n" +
               "Ngày Trả: " + ngayTra + "\n";
    }
}
