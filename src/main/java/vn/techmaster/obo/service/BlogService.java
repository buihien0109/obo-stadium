package vn.techmaster.obo.service;

import vn.techmaster.obo.entity.Post;
import vn.techmaster.obo.entity.User;
import vn.techmaster.obo.model.dto.PageableDto;
import vn.techmaster.obo.model.request.CreatePostReq;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BlogService {
    public Post createPost(CreatePostReq req, User user);

    public void updatePost(CreatePostReq req, User user, long id);

    public void deletePost(long id);

    public Page<Post> getListPost(int page);

    public Post getPostById(long id);

    public List<Post> getLatestPostsNotId(long id);

    public List<Post> getLatestPost();

    public PageableDto adminGetListPost(String title, String status, int page, String order, String direction);
}
