package pl.patrycjamecina.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrycjamecina.model.GithubUser;
import pl.patrycjamecina.service.impl.GithubUserServiceImpl;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class GithubUserController {
    private final GithubUserServiceImpl userApiService;

    @GetMapping("/info")
    public GithubUser getGithubUserInfo() {
        return userApiService.getGithubUserInfo();
    }
}
