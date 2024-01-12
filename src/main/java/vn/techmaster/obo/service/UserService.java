package vn.techmaster.obo.service;

import vn.techmaster.obo.entity.User;
import vn.techmaster.obo.model.request.ChangePasswordReq;
import vn.techmaster.obo.model.request.CreateUserReq;
import vn.techmaster.obo.model.request.UpdateProfileReq;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User createUser(CreateUserReq req);

    public void changePassword(User user, ChangePasswordReq req);

    public User updateProfile(User user, UpdateProfileReq req);
}
