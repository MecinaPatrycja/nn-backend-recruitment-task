package pl.patrycjamecina.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.patrycjamecina.model.GithubUser;
import pl.patrycjamecina.service.GithubUserService;
@Service
@RequiredArgsConstructor
public class GithubUserServiceImpl implements GithubUserService {
    private final RestTemplate restTemplateConfig;
    @Value("${USER_URL}")
    private String coreURL;

    @Override
    public GithubUser getGithubUserInfo() {
        GithubUser result;
        ResponseEntity<GithubUser> exchange = restTemplateConfig.getForEntity(coreURL, GithubUser.class);
        result = exchange.getBody();
        return result;
    }
}
