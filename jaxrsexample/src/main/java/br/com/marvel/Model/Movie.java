package br.com.marvel.Model;

import java.time.LocalDate;

public class Movie {

    private String title;
    private String type;
    private int days_until;
    private String overview;
    private String poster_url;
    private LocalDate release_date;
    private FollowingProduction following_production;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDaysUntil() {
        return days_until;
    }

    public void setDaysUntil(int days_until) {
        this.days_until = days_until;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterURL() {
        return poster_url;
    }

    public void setPosterURL(String poster_url) {
        this.poster_url = poster_url;
    }

    public LocalDate getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public FollowingProduction getFollowingProduction() {
        return following_production;
    }

    public void setFollowingProduction(FollowingProduction following_production) {
        this.following_production = following_production;
    }
}
