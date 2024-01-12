package vn.techmaster.obo.service.impl;

import vn.techmaster.obo.entity.User;
import vn.techmaster.obo.exception.BadRequestException;
import vn.techmaster.obo.exception.DuplicateRecordException;
import vn.techmaster.obo.model.mapper.UserMapper;
import vn.techmaster.obo.model.request.ChangePasswordReq;
import vn.techmaster.obo.model.request.CreateUserReq;
import vn.techmaster.obo.model.request.UpdateProfileReq;
import vn.techmaster.obo.repository.UserRepository;
import vn.techmaster.obo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(CreateUserReq req) {
        // Check email exist
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateRecordException("Email đã tồn tại trong hệ thống. Vui lòng sử dụng email khác.");
        }

        user = UserMapper.toUser(req);
        userRepository.save(user);

        return user;
    }

    @Override
    public void changePassword(User user, ChangePasswordReq req) {
        // Validate password
        if (!BCrypt.checkpw(req.getOldPassword(), user.getPassword())) {
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }

        String hash = BCrypt.hashpw(req.getNewPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        userRepository.save(user);
    }

    @Override
    public User updateProfile(User user, UpdateProfileReq req) {
        user.setAddress(req.getAddress());
        user.setPhone(req.getPhone());
        user.setFullName(req.getFullName());

        return userRepository.save(user);
    }
}
