package hello.supinternet.com.githubtp.request;

import java.util.List;

import hello.supinternet.com.githubtp.model.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 02/02/2018.
 */

public interface GithubService {
    @GET("/users/{username}/repos")
    Call<List<Repository>> repositoryList(@Path("username") String username);
}
