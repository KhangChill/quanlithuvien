import java.util.Scanner;

public class Book extends Document {
    private String bookid;
    private String ngonNgu;

    public Book(){
        super();
        this.bookid = this.ngonNgu = "";
    }
    public Book(String id, String name, String maSoKe, int namxuatban, int soluong, String tacgia, String type,
            String tinhTrangTL, String bookid, String ngonNgu) {
        super(id, name, maSoKe, namxuatban, soluong, tacgia, type, tinhTrangTL);
        this.bookid = bookid;
        this.ngonNgu = ngonNgu;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        this.bookid = sc.nextLine();
        System.out.print("Nhap ngon ngu: ");
        this.ngonNgu = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.print("Ma sach: " + this.bookid+"  ");
        System.out.println("Ngon ngu: " + this.ngonNgu);
    }

    public String getBookid() {
        return bookid;
    }
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    public String getNgonNgu() {
        return ngonNgu;
    }
    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }
    @Override
    public String toString() {
        return super.toString() + "Ma sach: " + getBookid() + ", Ngon ngu:  " + getNgonNgu();
    }

    
}
