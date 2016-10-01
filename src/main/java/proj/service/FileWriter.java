package proj.service;
import org.springframework.web.multipart.MultipartFile;



/**
 * Created by SC on 01.10.2016.
 */
public interface FileWriter {

    enum Folder{
        PRODUCT;
    }

    String write(Folder folder, MultipartFile file, int id);
}
