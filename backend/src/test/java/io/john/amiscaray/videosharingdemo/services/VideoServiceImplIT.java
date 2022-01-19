package io.john.amiscaray.videosharingdemo.services;

import io.john.amiscaray.videosharingdemo.domain.Video;
import io.john.amiscaray.videosharingdemo.repo.VideoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
public class VideoServiceImplIT {
    @Autowired
    VideoService service;

    @Autowired
    VideoRepo repo;

    String testName = "myVid";

    @Test
    void getVideo() {
        Video expected = new Video(testName, null);
        repo.save(expected);
        Video actual = service.getVideo(testName);
        // The result from service.getVideo(testName) should be expected Video instance above
        assertEquals(expected, actual);
    }


    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        service.saveVideo(file, testName);
        // After saving the video using the service, the repository should say that the video exists
        assertTrue(repo.existsByName(testName));
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of(testName);
        repo.save(new Video(testName, null));
        List<String> actual = service.getAllVideoNames();
        // Check the service returns a list of the same contents as the expected list of videos
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
