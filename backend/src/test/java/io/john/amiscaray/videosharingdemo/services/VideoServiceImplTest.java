package io.john.amiscaray.videosharingdemo.services;

import io.john.amiscaray.videosharingdemo.domain.Video;
import io.john.amiscaray.videosharingdemo.repo.VideoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

/*
    Import all the static methods in the Mockito class so we can use them as though they are methods in this class.
    These include methods such as mock, when, etc. Same with the JUnit assertions.
 */
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VideoServiceImplTest {
    VideoRepo repo = mock(VideoRepo.class);
    VideoService service = new VideoServiceImpl(repo);
    String testName = "myVid";

    @Test
    void getVideo() {
        Video expected = new Video(testName, null);
        // When our VideoService object calls repo.findByName(testName), return expected
        when(repo.findByName(testName))
                .thenReturn(expected);
        // When our VideoService object calls repo.existsByName(testName), return true
        when(repo.existsByName(testName))
                .thenReturn(true);
        Video actual = service.getVideo(testName);
        assertEquals(expected, actual);
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).findByName(testName);
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of("myVid", "otherVid");
        when(repo.getAllEntryNames())
                .thenReturn(expected);
        List<String> actual = service.getAllVideoNames();
        assertEquals(expected, actual);
        verify(repo, times(1)).getAllEntryNames();
    }

    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        Video testVid = new Video(testName, file.getBytes());
        service.saveVideo(file, testName);
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).save(testVid);
    }
}