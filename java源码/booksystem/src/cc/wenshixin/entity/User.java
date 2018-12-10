package cc.wenshixin.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String usId;
    private String usName;
    private String usPassword;
    // 读者类型
    private RdType rdType;
    private String usSex;
    private String usDepartment;
    private String usPhone;
    private String usEmail;
    private Date usDateRegister;
    private byte[] usPhoto;
    private String usStatus;
    private Integer usBorrowCount;
    // 管理角色
    private AdRole adRole;
    // 借阅记录
    private Set<Borrow> setBorrow = new HashSet<Borrow>();

    public User() {

    }
    public User(String usId, String usName, String usPassword, String usStatus, AdRole adRole) {
        this.usId = usId;
        this.usName = usName;
        this.usPassword = usPassword;
        this.usStatus = usStatus;
        this.adRole = adRole;
    }

    public RdType getRdType() {
        return rdType;
    }

    public void setRdType(RdType rdType) {
        this.rdType = rdType;
    }

    public AdRole getAdRole() {
        return adRole;
    }

    public void setAdRole(AdRole adRole) {
        this.adRole = adRole;
    }

    public String getUsId() {
        return usId;
    }

    public void setUsId(String usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsSex() {
        return usSex;
    }

    public void setUsSex(String usSex) {
        this.usSex = usSex;
    }

    public String getUsDepartment() {
        return usDepartment;
    }

    public void setUsDepartment(String usDepartment) {
        this.usDepartment = usDepartment;
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public Date getUsDateRegister() {
        return usDateRegister;
    }

    public void setUsDateRegister(Date usDateRegister) {
        this.usDateRegister = usDateRegister;
    }

    public byte[] getUsPhoto() {
        return usPhoto;
    }

    public void setUsPhoto(byte[] usPhoto) {
        this.usPhoto = usPhoto;
    }

    public String getUsStatus() {
        return usStatus;
    }

    public void setUsStatus(String usStatus) {
        this.usStatus = usStatus;
    }

    public Integer getUsBorrowCount() {
        return usBorrowCount;
    }

    public void setUsBorrowCount(Integer usBorrowCount) {
        this.usBorrowCount = usBorrowCount;
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
        User user = (User) o;
        return Objects.equals(usId, user.usId) &&
                Objects.equals(usName, user.usName) &&
                Objects.equals(usPassword, user.usPassword) &&
                Objects.equals(usSex, user.usSex) &&
                Objects.equals(usDepartment, user.usDepartment) &&
                Objects.equals(usPhone, user.usPhone) &&
                Objects.equals(usEmail, user.usEmail) &&
                Objects.equals(usDateRegister, user.usDateRegister) &&
                Arrays.equals(usPhoto, user.usPhoto) &&
                Objects.equals(usStatus, user.usStatus) &&
                Objects.equals(usBorrowCount, user.usBorrowCount);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(usId, usName, usPassword, usSex, usDepartment, usPhone, usEmail, usDateRegister, usStatus, usBorrowCount);
        result = 31 * result + Arrays.hashCode(usPhoto);
        return result;
    }
}
