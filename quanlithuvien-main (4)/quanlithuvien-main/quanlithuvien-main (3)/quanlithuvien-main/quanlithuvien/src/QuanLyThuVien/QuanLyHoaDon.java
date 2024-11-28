import java.io.*;
import java.text.*;
import java.util.*;

public class QuanLyHoaDon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> hoaDonList = new ArrayList<>();

        // Đọc các hóa đơn cũ từ file vào danh sách
        hoaDonList = loadHoaDonFromFile("output_HD.txt");

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
                        if (!checkDocGiaExists(maDocGia, tenDocGia)) {
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
                        if (!checkMaTaiLieuExists(maTaiLieu)) {
                            System.out.println("Sai ma tai lieu! Vui long nhap lai ma tai lieu: ");
                        } else {
                            isValidTaiLieu = true;
                        }
                    }

                    System.out.print("Tien coc: ");
                    double tienCoc = scanner.nextDouble();
                    scanner.nextLine();  // Đọc ký tự Enter còn sót lại

                    // Lấy ngày mượn hiện tại
                    String ngayMuon = getCurrentDate();

                    // Nhập ngày trả và kiểm tra tính hợp lệ
                    String ngayTra = "";
                    boolean validNgayTra = false;
                    while (!validNgayTra) {
                        System.out.print("Ngay tra (dd/MM/yyyy): ");
                        ngayTra = scanner.nextLine();

                        if (!isValidDate(ngayMuon) || !isValidDate(ngayTra)) {
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
                displayHoaDon(hoaDonList);

            } else if (choice == 4) {
                // Xuất hóa đơn theo mã
                System.out.print("Nhap ma hoa don muon xuat: ");
                String maHoaDon = scanner.nextLine();
                displayHoaDonByMa(hoaDonList, maHoaDon);

            } else if (choice == 5) {
                break;  // Thoát khỏi chương trình
            } else {
                System.out.println("Lua chon khong hop le");
            }

            // Lưu tất cả hóa đơn vào file sau khi có thay đổi
            saveHoaDonToFile(hoaDonList, "output_HD.txt");
        }

        System.out.println("Tat ca hoa don da duoc luu vao file output_HD.txt !");
    }

    // Phương thức lấy ngày hiện tại theo định dạng dd/MM/yyyy
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }

    // Phương thức kiểm tra mã độc giả có tồn tại trong file output_NS.txt
    public static boolean checkDocGiaExists(String maDocGia, String tenDocGia) {
        // Giả sử kiểm tra có file output_NS.txt chứa danh sách độc giả
        try (BufferedReader br = new BufferedReader(new FileReader("output_NS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(maDocGia) && line.contains(tenDocGia)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file output_NS.txt: " + e.getMessage());
        }
        return false;
    }

    // Phương thức kiểm tra mã tài liệu có tồn tại trong file output_TL.txt
    public static boolean checkMaTaiLieuExists(String maTaiLieu) {
        // Giả sử kiểm tra có file output_TL.txt chứa danh sách tài liệu
        try (BufferedReader br = new BufferedReader(new FileReader("output_TL.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(maTaiLieu)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file tai lieu: " + e.getMessage());
        }
        return false;
    }

    // Phương thức kiểm tra tính hợp lệ của ngày
    public static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Không cho phép ngày sai format
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Phương thức hiển thị tất cả hóa đơn
    public static void displayHoaDon(List<String> hoaDonList) {
        if (hoaDonList.isEmpty()) {
            System.out.println("Khong co hoa don nao!");
        } else {
            System.out.println("\nDanh sach hoa don:");
            for (String hoaDon : hoaDonList) {
                System.out.println(hoaDon);
            }
        }
    }

    // Phương thức hiển thị hóa đơn theo mã
    public static void displayHoaDonByMa(List<String> hoaDonList, String maHoaDon) {
        boolean found = false;
        for (String hoaDon : hoaDonList) {
            if (hoaDon.contains(maHoaDon)) {
                System.out.println("\nHoa don tim thay:");
                System.out.println(hoaDon);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don voi ma: " + maHoaDon);
        }
    }

    // Phương thức lưu danh sách hóa đơn vào file
    public static void saveHoaDonToFile(List<String> hoaDonList, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String hoaDon : hoaDonList) {
                bw.write(hoaDon);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Phương thức đọc danh sách hóa đơn từ file
    public static List<String> loadHoaDonFromFile(String fileName) {
        List<String> hoaDonList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                hoaDonList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
        return hoaDonList;
    }
}
