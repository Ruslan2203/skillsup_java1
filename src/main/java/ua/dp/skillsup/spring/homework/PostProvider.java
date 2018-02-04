package ua.dp.skillsup.spring.homework;

import ua.dp.skillsup.spring.homework.service.ServiceApi;

import java.util.List;

public class PostProvider {
    private ServiceApi serviceApi;
    private PostFilter postFilter;
    private String keyWord;

    public void setServiceApi(ServiceApi serviceApi) {
        this.serviceApi=serviceApi;

    }
    public void setPostFilter(PostFilter postFilter){
        this.postFilter=postFilter;

    }
    public void setKeyWord(String keyWord){
        this.keyWord = keyWord;

    }

    public ServiceApi getServiceApi() {
        return serviceApi;
    }

    public PostFilter getPostFilter() {
        return postFilter;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public List<Post> getPosts(){
        return postFilter.filterByKeyword(serviceApi.getPosts(), keyWord);
    }

}
