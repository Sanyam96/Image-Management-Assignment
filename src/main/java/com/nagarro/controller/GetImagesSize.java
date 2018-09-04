package com.nagarro.controller;

import com.nagarro.models.Image;
import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

import java.util.Collection;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class GetImagesSize {

    public static double getImagesSize(String username) {
        double totalSize = 0;
        LoginImplementation login = new LoginImplementation();
        User user = login.getUserDetails(username);
        Collection<Image> images = user.getImages();
        for (Image image : images) {
            totalSize += image.getImageSize();
        }
        return totalSize;
    }
}
