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
    private int TienDatCoc;

    // Constructor
    public HoaDon(String maHoaDon, String tenNhanVien, String maNhanVien, 
                  String tenDocGia, String maDocGia, String taiLieuMuon, 
                  int soLuong, Date ngayMuon, Date ngayTra, int TienDatCoc) {
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.maNhanVien = maNhanVien;
        this.tenDocGia = tenDocGia;
        this.maDocGia = maDocGia;
        this.taiLieuMuon = taiLieuMuon;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.TienDatCoc = TienDatCoc;
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

public int getTienDatCoc(){
    return TienDatCoc = soLuong * 100000;
}

public void setTienDatCoc(int TienDatCoc){
    this.TienDatCoc = TienDatCoc;
}


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Định dạng ngày tháng
        return "Ma hoa don: " + maHoaDon + "\n" +
               "Ten nhan vien: " + tenNhanVien + " - Ma nhan vien: " + maNhanVien + "\n" +
               "Ten doc gia: " + tenDocGia + " - Ma doc gia: " + maDocGia + "\n" +
               "Tai lieu muon: " + taiLieuMuon + "\n" +
               "So luong: " + soLuong + "\n" +
               "Ngay muon: " + ngayMuon + "\n" +
               "Ngay tra: " + ngayTra + "\n" +
               "Tổng số tiền trả: " + TienDatCoc + "VND" + "\n";
    }
}
