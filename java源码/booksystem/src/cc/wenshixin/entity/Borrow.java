package cc.wenshixin.entity;

import java.sql.Date;
import java.util.Objects;

public class Borrow {
    private String brId;
    // 用户记录
    private User  user;
    // 图书记录
    private Book book;
    private Byte continueTime;
    private Date dateOut;
    private Date dateReturnPlan;
    private Date dateReturnFact;
    private Integer overDay;
    private Float overMoneyPlan;
    private Float overMoneyFact;
    private String hasReturn;
    private String operatorLend;
    private String operatorReturn;

    public String getBrId() {
        return brId;
    }

    public void setBrId(String brId) {
        this.brId = brId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Byte getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(Byte continueTime) {
        this.continueTime = continueTime;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateReturnPlan() {
        return dateReturnPlan;
    }

    public void setDateReturnPlan(Date dateReturnPlan) {
        this.dateReturnPlan = dateReturnPlan;
    }

    public Date getDateReturnFact() {
        return dateReturnFact;
    }

    public void setDateReturnFact(Date dateReturnFact) {
        this.dateReturnFact = dateReturnFact;
    }

    public Integer getOverDay() {
        return overDay;
    }

    public void setOverDay(Integer overDay) {
        this.overDay = overDay;
    }

    public Float getOverMoneyPlan() {
        return overMoneyPlan;
    }

    public void setOverMoneyPlan(Float overMoneyPlan) {
        this.overMoneyPlan = overMoneyPlan;
    }

    public Float getOverMoneyFact() {
        return overMoneyFact;
    }

    public void setOverMoneyFact(Float overMoneyFact) {
        this.overMoneyFact = overMoneyFact;
    }

    public String getHasReturn() {
        return hasReturn;
    }

    public void setHasReturn(String hasReturn) {
        this.hasReturn = hasReturn;
    }

    public String getOperatorLend() {
        return operatorLend;
    }

    public void setOperatorLend(String operatorLend) {
        this.operatorLend = operatorLend;
    }

    public String getOperatorReturn() {
        return operatorReturn;
    }

    public void setOperatorReturn(String operatorReturn) {
        this.operatorReturn = operatorReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(brId, borrow.brId) &&
                Objects.equals(continueTime, borrow.continueTime) &&
                Objects.equals(dateOut, borrow.dateOut) &&
                Objects.equals(dateReturnPlan, borrow.dateReturnPlan) &&
                Objects.equals(dateReturnFact, borrow.dateReturnFact) &&
                Objects.equals(overDay, borrow.overDay) &&
                Objects.equals(overMoneyPlan, borrow.overMoneyPlan) &&
                Objects.equals(overMoneyFact, borrow.overMoneyFact) &&
                Objects.equals(hasReturn, borrow.hasReturn) &&
                Objects.equals(operatorLend, borrow.operatorLend) &&
                Objects.equals(operatorReturn, borrow.operatorReturn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brId, continueTime, dateOut, dateReturnPlan, dateReturnFact, overDay, overMoneyPlan, overMoneyFact, hasReturn, operatorLend, operatorReturn);
    }
}
