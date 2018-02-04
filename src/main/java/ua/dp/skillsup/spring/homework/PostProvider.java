package ua.dp.skillsup.spring.homework;

import ua.dp.skillsup.spring.homework.service.ServiceApi;

import java.util.List;

public class PostProvider {
    private ServiceApi serviceApi;
    private PostFilter postFilter;
    private String keyWord;

    public void setServiceApi(ServiceApi serviceApi) {

    }
    public void setPostFilter(PostFilter postFilter){

    }
    public void setKeyWord(String keyWord){

    }


    public List<Post> getPosts(){
        return postFilter.filterByKeyword(serviceApi.getPosts(), keyWord);
    }

}
