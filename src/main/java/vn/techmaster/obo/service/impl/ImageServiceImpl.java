package vn.techmaster.obo.service.impl;

import vn.techmaster.obo.entity.Image;
import vn.techmaster.obo.exception.BadRequestException;
import vn.techmaster.obo.exception.InternalServerException;
import vn.techmaster.obo.repository.ImageRepository;
import vn.techmaster.obo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Component
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void save(Image img) {
        imageRepository.save(img);
    }

    @Override
    public List<String> getListImageOfUser(long userId) {
        List<String> images = imageRepository.getListImageOfUser(userId);

        return images;
    }

    @Override
    @Transactional(rollbackFor = InternalServerException.class)
    public void deleteImage(String uploadDir, String filename) {
        String link = "/media/static/" + filename;
        Image img = imageRepository.findByLink(link);
        if (img == null) {
            throw new BadRequestException("File không tồn tại");
        }

        Integer inUse = imageRepository.checkImgInUse(link);
        if (inUse != null) {
            throw new BadRequestException("Ảnh đã được sử dụng không thể xóa");
        }

        imageRepository.delete(img);

        File file = new File(uploadDir + "/" + filename);
        if (file.exists()) {
            if (!file.delete()) {
                throw new InternalServerException("Lỗi khi xóa ảnh");
            }
        }
    }
}
