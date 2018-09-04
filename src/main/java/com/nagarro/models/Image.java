package com.nagarro.models;

import javax.persistence.*;

/**
 * Image Domain class
 * @author Sanyam Goel created on 4/9/18
 */

@Entity
@Table(name = "Image_Details")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_Id")
    private Long imageId;

    @Column(name = "Image_Name")
    private String imageName;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Image", columnDefinition = "mediumblob")
    private byte[] photo;

    @Column(name = "Image_Size")
    private double imageSize;

    @ManyToOne
    @JoinColumn(name = "user_username", nullable = false)
    private User user;

    public Image() {
    }

    public Image(Long imageId, String imageName, byte[] photo, double imageSize, User user) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.photo = photo;
        this.imageSize = imageSize;
        this.user = user;
    }

    public Image(String imageName, Double imageSize, byte[] photo) {
        this.imageName = imageName;
        this.imageSize = imageSize;
        this.photo = photo;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public double getImageSize() {
        return imageSize;
    }

    public void setImageSize(double imageSize) {
        this.imageSize = imageSize;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
