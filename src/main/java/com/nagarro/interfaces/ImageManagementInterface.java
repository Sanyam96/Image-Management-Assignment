package com.nagarro.interfaces;

import com.nagarro.models.Image;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public interface ImageManagementInterface {

    void addImage(Image image);

    Image getImage(String imageid);

    void editImage(Image newImage);

    void deleteImage(String imageid);
}
