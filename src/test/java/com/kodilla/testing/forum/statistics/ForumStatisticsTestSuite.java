package com.kodilla.testing.forum.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @Before
    public void beforeTest(){
        statisticsMock = mock(Statistics.class);
        List<String> listMockito = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listMockito.add("User");
        }

        when(statisticsMock.usersNames()).thenReturn(listMockito);
        when(statisticsMock.postsCount()).thenReturn(18);
        when(statisticsMock.commentsCount()).thenReturn(36);
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testCalculateZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsQuantity());
        assertEquals(0, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerPost(), 0.01);
    }

    @Test
    public void testCalculateThousandPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, forumStatistics.getPostsQuantity());
        assertEquals(100, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0.04, forumStatistics.getCommentsAveragePerPost(), 0.01);
    }

    @Test
    public void testCalculateZeroComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getCommentsQuantity());
        assertEquals(0, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerPost(), 0.01);
    }

    @Test
    public void testCalculateLessCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(10);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, forumStatistics.getPostsQuantity());
        assertEquals(2, forumStatistics.getCommentsQuantity());
        assertEquals(1, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAveragePerPost(), 0.01);
    }

    @Test
    public void testCalculateMoreCommentsThanPosts(){
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(18, forumStatistics.getPostsQuantity());
        assertEquals(36, forumStatistics.getCommentsQuantity());
        assertEquals(3.6, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(2, forumStatistics.getCommentsAveragePerPost(), 0.01);
    }

    @Test
    public void testCalculateZeroUsers(){
        //Given
        List<String>listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getUsersQuantity());
        assertEquals(0, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerUser(), 0.01);
    }

    @Test
    public void testCalculateHundredUsers(){
        //Given
        List<String> listMock = new ArrayList<>();
        for(int i=0; i<100; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getUsersQuantity());
        assertEquals(0.18, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0.36, forumStatistics.getCommentsAveragePerUser(), 0.01);
    }




}
