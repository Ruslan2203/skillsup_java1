package ua.dp.skillsup.spring.homework.service;

import ua.dp.skillsup.spring.homework.Post;

import java.util.Arrays;
import java.util.List;

public class TwitterApi implements ServiceApi{
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username=username;

    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public List<Post> getPosts() {
        System.out.println("Reading posts from Twitter with following credentials: " + username + "/" + password);
        //some fancy implementation here
        return Arrays.asList(
                new Post("I've just pooped", ""),
                new Post("My dog ate my homework", "http://twitter.com/badboy.jpg"),
                new Post("@realDonaldTrump you're wrong!", "")
        );
    }
}
