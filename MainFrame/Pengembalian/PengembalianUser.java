package MainFrame.Pengembalian;

public class PengembalianUser {
    private String borrowCode;
    private String memberName;
    private String bookName;
    private String borrowDate;
    private String returnDate;
    private String status;

    public PengembalianUser(){

    }

    public PengembalianUser(String borrowCode, String memberName, String bookName, String borrowDate, String returnDate, String status) {
        this.borrowCode = borrowCode;
        this.memberName = memberName;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
