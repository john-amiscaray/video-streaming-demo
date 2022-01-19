package io.john.amiscaray.videosharingdemo.controllers;

import io.john.amiscaray.videosharingdemo.services.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.*;

@SpringBootTest
class VideoControllerIT {

    @Autowired
    VideoController controller;
    @Autowired
    VideoService service;
    MultipartFile file = mock(MultipartFile.class);

    @Test
    void saveVideo(){

        

    }

}