package br.com.marvel.Model;

import java.time.LocalDate;

public class FollowingProduction {
    
    private LocalDate release_date;
	private String title;

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

    
}
