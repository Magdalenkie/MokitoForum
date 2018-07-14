package com.kodilla.testing.forum.statistics;
import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> post = new ArrayList<ForumPost>();
    private LinkedList<ForumComment> comment = new LinkedList<ForumComment>();

    public ForumUser(String name, String realName){
        this.name = name;
        this.realName = realName;
    }

    public String getName(){
        return name;
    }

    public String getRealName(){
        return realName;
    }

    public void addPost(String author, String postBody){
        ForumPost thePost = new ForumPost(postBody, author);
    }

    public void addComment(ForumPost forumPost, String commentBody, String author){
        ForumComment theComment = new ForumComment(forumPost, commentBody, author);
    }

    public int getPostsNumber(){
        return post.size();
    }

    public int getCommentsNumber(){
        return comment.size();
    }

    public ForumPost getPost(int postNum){
        ForumPost thePost = null;
        if(postNum >= 0 && postNum < post.size()){
            thePost = post.get(postNum);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNum){
        ForumComment theComment = null;
        if(commentNum >= 0 && commentNum < comment.size()){
            theComment = comment.get(commentNum);
        }
        return theComment;
    }

    public boolean removePost(ForumPost thePost){
        boolean result = false;
        if(post.contains(thePost)){
            post.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment){
        boolean result = false;
        if(comment.contains(theComment)){
            comment.remove(theComment);
            result = true;
        }
        return result;
    }

}
