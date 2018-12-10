package cc.wenshixin.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {
    private Integer bkId;
    private String bkCode;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private Date bkDatePress;
    private String bkIsbn;
    private String bkCatalog;
    private Byte bkLanguage;
    private Integer bkPages;
    private Float bkPrice;
    private Date bkDateIn;
    private String bkBrief;
    private byte[] bkCover;
    private String bkStatus;
    // 借阅记录
    private Set<Borrow> setBorrow = new HashSet<Borrow>();

    public Integer getBkId() {
        return bkId;
    }

    public void setBkId(Integer bkId) {
        this.bkId = bkId;
    }

    public String getBkCode() {
        return bkCode;
    }

    public void setBkCode(String bkCode) {
        this.bkCode = bkCode;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public Date getBkDatePress() {
        return bkDatePress;
    }

    public void setBkDatePress(Date bkDatePress) {
        this.bkDatePress = bkDatePress;
    }

    public String getBkIsbn() {
        return bkIsbn;
    }

    public void setBkIsbn(String bkIsbn) {
        this.bkIsbn = bkIsbn;
    }

    public String getBkCatalog() {
        return bkCatalog;
    }

    public void setBkCatalog(String bkCatalog) {
        this.bkCatalog = bkCatalog;
    }

    public Byte getBkLanguage() {
        return bkLanguage;
    }

    public void setBkLanguage(Byte bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public Integer getBkPages() {
        return bkPages;
    }

    public void setBkPages(Integer bkPages) {
        this.bkPages = bkPages;
    }

    public Float getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(Float bkPrice) {
        this.bkPrice = bkPrice;
    }

    public Date getBkDateIn() {
        return bkDateIn;
    }

    public void setBkDateIn(Date bkDateIn) {
        this.bkDateIn = bkDateIn;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public byte[] getBkCover() {
        return bkCover;
    }

    public void setBkCover(byte[] bkCover) {
        this.bkCover = bkCover;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
    }

    public Set<Borrow> getSetBorrow() {
        return setBorrow;
    }

    public void setSetBorrow(Set<Borrow> setBorrow) {
        this.setBorrow = setBorrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bkId, book.bkId) &&
                Objects.equals(bkCode, book.bkCode) &&
                Objects.equals(bkName, book.bkName) &&
                Objects.equals(bkAuthor, book.bkAuthor) &&
                Objects.equals(bkPress, book.bkPress) &&
                Objects.equals(bkDatePress, book.bkDatePress) &&
                Objects.equals(bkIsbn, book.bkIsbn) &&
                Objects.equals(bkCatalog, book.bkCatalog) &&
                Objects.equals(bkLanguage, book.bkLanguage) &&
                Objects.equals(bkPages, book.bkPages) &&
                Objects.equals(bkPrice, book.bkPrice) &&
                Objects.equals(bkDateIn, book.bkDateIn) &&
                Objects.equals(bkBrief, book.bkBrief) &&
                Arrays.equals(bkCover, book.bkCover) &&
                Objects.equals(bkStatus, book.bkStatus);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(bkId, bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkIsbn, bkCatalog, bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkStatus);
        result = 31 * result + Arrays.hashCode(bkCover);
        return result;
    }
}
