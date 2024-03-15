package com.qanbari.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileStorageService {

    void store(MultipartFile file) throws IOException;

    Resource loadFile(String filename) throws IOException;
}
