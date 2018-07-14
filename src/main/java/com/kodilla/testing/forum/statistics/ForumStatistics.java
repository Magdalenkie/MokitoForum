package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double postsAveragePerUser;
    private double commentsAveragePerUser;
    private double commentsAveragePerPost;

    public int getUsersQuantity(){
        return usersQuantity;
    }

    public int getPostsQuantity(){
        return postsQuantity;
    }

    public int getCommentsQuantity(){
        return commentsQuantity;
    }

    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPost() {
        return commentsAveragePerPost;
    }

    public void calculateAdvStatistics(Statistics statistics){
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        postsAveragePerUser = calculatePostsAvgPerUser();
        commentsAveragePerPost = calculateCommentsAveragePerPost();
        commentsAveragePerUser = calculateCommentsAveragePerUser();
    }

    public double calculatePostsAvgPerUser(){
        if(usersQuantity > 0) {
            return (double) postsQuantity / usersQuantity;
        }else {
            return 0;
        }
    }

    public double calculateCommentsAveragePerUser(){
        if(usersQuantity > 0) {
            return (double) commentsQuantity / usersQuantity;
        }else {
            return 0;
        }
    }

    public double calculateCommentsAveragePerPost(){
        if(postsQuantity > 0){
            return (double) commentsQuantity / postsQuantity;
        }else{
            return 0;
        }
    }



}
