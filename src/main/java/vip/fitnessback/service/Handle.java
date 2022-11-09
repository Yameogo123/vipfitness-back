package vip.fitnessback.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Handle {

    public static String principalDirectory= System.getProperty("user.dir") + "/src/main/resources/static";
    public static String profilDirectory= principalDirectory +"/profil";
    public static String coverDirectory= principalDirectory +"/cover";
    public static String videoDirectory= principalDirectory +"/video";
    public static String songDirectory= principalDirectory + "/song";


    public Handle(){
        new File(profilDirectory).mkdir();
        new File(coverDirectory).mkdir();
        new File(videoDirectory).mkdir();
        new File(songDirectory).mkdir();
    }

    public static String handleFile(MultipartFile file, String directory) throws IOException {
        String fileName= RandomString.make(10)+
                file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path path=Paths.get(principalDirectory, fileName);
        switch (directory){
            case "cover":
                path= Paths.get(coverDirectory, fileName);
                break;
            case "profil":
                path= Paths.get(profilDirectory,fileName);
                break;
            case "song":
                path= Paths.get(songDirectory, fileName);
                break;
            default:
                break;
        }
        Files.write(path, file.getBytes());
        return fileName;
    }
}
