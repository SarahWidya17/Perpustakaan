package MainFrame.Peminjaman;

public class User {

    private String borrowCode;
    private String memberName;
    private String bookCode;
    private String bookName;
    private String borrowDate;

    public User(){

    }

    public User(String borrowCode, String memberName, String bookCode, String bookName, String borrowDate){
        this.borrowCode = borrowCode;
        this.memberName = memberName;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
    }

    public String getBorrowCode(){
        return borrowCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

}
