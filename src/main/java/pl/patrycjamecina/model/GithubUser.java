package pl.patrycjamecina.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class GithubUser {
    private Long id;
    private String login;
    private String name;
    private String type;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty(value = "created_at")
    private Date createdAt;
    private final double calculations = (6.0 / 2.0 * (2.0 + 1.0));
}
