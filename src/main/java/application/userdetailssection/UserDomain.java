package application.userdetailssection;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mj on 9/6/16.
 */


@Entity
@Table(name = "userdetails")
public class UserDomain {

    @Id
    @GeneratedValue
    private int userId;
    private String username;
    private String password;
    private String authToken;
    private String roles;

    @Transient
    public static final String DATE_CREATED = "creationTime";
    @Transient
    public static final String LAST_UPDATED = "lastModificationTime";

    @CreatedDate
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @Column(nullable = true, updatable = true)
    private Long lastModifiedBy;

    @Column(nullable = false, updatable = true)
    private Integer status;

    @Column(nullable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificationTime;

    @Column(nullable = false)
    @Version
    private Long version;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
