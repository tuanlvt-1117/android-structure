package com.tuanlvt.mvp_architecture.data.model;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 22/08/2018.
 * tantuan127@gmail.com
 */
public class Movie {
    private int mVote;
    private String mTitile;
    private String mUrlImage;
    private String mOriginalTitle;

    public Movie(MovieBuilder movieBuilder) {
        mVote = movieBuilder.mVote;
        mTitile = movieBuilder.mTitle;
        mUrlImage = movieBuilder.mUrlImage;
        mOriginalTitle = movieBuilder.mOriginalTitle;
    }

    public Movie() {
    }

    public int getVote() {
        return mVote;
    }

    public void setVote(int vote) {
        mVote = vote;
    }

    public String getTitile() {
        return mTitile;
    }

    public void setTitile(String titile) {
        mTitile = titile;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String urlImage) {
        mUrlImage = urlImage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public static class MovieBuilder {
        private int mVote;
        private String mTitle;
        private String mUrlImage;
        private String mOriginalTitle;

        public MovieBuilder(int vote, String title, String urlImage, String originalTitle) {
            mVote = vote;
            mTitle = title;
            mUrlImage = urlImage;
            mOriginalTitle = originalTitle;
        }

        public MovieBuilder() {
        }

        public MovieBuilder vote(int vote) {
            mVote = vote;
            return this;
        }

        public MovieBuilder title(String title) {
            mTitle = title;
            return this;
        }

        public MovieBuilder urlImage(String urlImage) {
            mUrlImage = urlImage;
            return this;
        }

        public MovieBuilder originalTitle(String originalTitle) {
            mOriginalTitle = originalTitle;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public final class MovieEntry {
        public static final String MOVIE = "results";
        public static final String VOTE = "vote_average";
        public static final String TITLE = "title";
        public static final String URL_IMAGE = "poster_path";
        public static final String ORIGINAL_TITLE = "original_title";
    }
}
