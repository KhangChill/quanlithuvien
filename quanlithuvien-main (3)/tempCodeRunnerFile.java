import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HoaDon {
    private String tenNhanVien;
    private String maNhanVien;
    private String tenDocGia;
    private String maDocGia;
    private String tenTaiLieu;
    private String maTaiLieu;
    private int soLuong;

    public HoaDon(String idNhanVien, String idDocGia, String idTaiLieu) {
        maNhanVien = layMaNhanVienTheoId(idNhanVien);
        tenNhanVien = layTenNhanVienTheoId(idNhanVien);
        maDocGia = layMaDocGiaTheoId(idDocGia);
        tenDocGia = layTenDocGiaTheoId(idDocGia);
        tenTaiLieu = layTenTaiLieuTheoId(idTaiLieu);
        maTaiLieu = idTaiLieu;
        soLuong = laySoLuongTaiLieuTheoId(idTaiLieu);
    }

    private String layMaNhanVienTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Employee; ID: " + id)) {
                    return line.split("; ")[1].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenNhanVienTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Employee; ID: " + id)) {
                    return line.split("; ")[2].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layMaDocGiaTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Reader; ID: " + id)) {
                    return line.split("; ")[1].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenDocGiaTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Reader; ID: " + id)) {
                    return line.split("; ")[2].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenTaiLieuTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_TL.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ID: " + id)) {
                    return line.split(", ")[1].split(": ")[1];
                }
            }
        } catch (IOExceptionimport java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HoaDon {
    private String tenNhanVien;
    private String maNhanVien;
    private String tenDocGia;
    private String maDocGia;
    private String tenTaiLieu;
    private String maTaiLieu;
    private int soLuong;

    public HoaDon(String idNhanVien, String idDocGia, String idTaiLieu) {
        maNhanVien = layMaNhanVienTheoId(idNhanVien);
        tenNhanVien = layTenNhanVienTheoId(idNhanVien);
        maDocGia = layMaDocGiaTheoId(idDocGia);
        tenDocGia = layTenDocGiaTheoId(idDocGia);
        tenTaiLieu = layTenTaiLieuTheoId(idTaiLieu);
        maTaiLieu = idTaiLieu;
        soLuong = laySoLuongTaiLieuTheoId(idTaiLieu);
    }

    private String layMaNhanVienTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Employee; ID: " + id)) {
                    return line.split("; ")[1].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenNhanVienTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Employee; ID: " + id)) {
                    return line.split("; ")[2].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layMaDocGiaTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Reader; ID: " + id)) {
                    return line.split("; ")[1].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenDocGiaTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Reader; ID: " + id)) {
                    return line.split("; ")[2].split(": ")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String layTenTaiLieuTheoId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("output_TL.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ID: " + id)) {
                    return line.split(", ")[1].split(": ")[1];
                }
            }
        } catch (IOException