package com.nagarro.controller;

import com.nagarro.models.Image;
import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

import java.util.Collection;

/**
 * Class to do operation to calculate the in total size
 * @author Sanyam Goel created on 4/9/18
 */
public class GetImagesSize {

    private static double totalSize = 0;
    private static LoginImplementation loginImplementation = new LoginImplementation();
    private static User user;
    private static Collection<Image> images;


    public static double getImagesSize(String username) {
        user = loginImplementation.getUserDetails(username);
        images = user.getImages();
        for (Image image : images) {
            totalSize += image.getImageSize();
        }
        return totalSize;
    }
}
