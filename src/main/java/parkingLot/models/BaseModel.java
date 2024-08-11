package parkingLot.models;

import java.util.Date;

public class BaseModel {
    //instead of primitive data type - long, we can use object Long so object is converted into series of bytes (i.e) serializable
    //so, use wrapper class(Long, Byte, Integer) instead of primitive data type(long, byte, int)
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
