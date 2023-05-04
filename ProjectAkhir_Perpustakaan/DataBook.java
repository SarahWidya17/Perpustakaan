package ProjectAkhir_Perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class DataBook {
    private String bookCodee;
    private String bookName;
    public DataBook(){

    }

    public String getBookCodee() {
        return bookCodee;
    }

    public void setBookCodee(String bookCodee) {
        this.bookCodee = bookCodee;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public void setDataaa(List<String> dataaa) {
        this.dataaa = dataaa;
    }

    private List<String> dataaa;

    public DataBook(String bookCodee, String bookName) {
        this.bookCodee = bookCodee;
        this.bookName = bookName;
        dataaa = new ArrayList<>();
    }
}

