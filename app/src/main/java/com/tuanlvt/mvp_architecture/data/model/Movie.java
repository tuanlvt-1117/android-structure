package com.tuanlvt.mvp_architecture.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class Movie implements Parcelable {
    @Expose
    @SerializedName("vote_average")
    private double mVote;
    @Expose
    @SerializedName("title")
    private String mTitle;
    @Expose
    @SerializedName("poster_path")
    private String mUrlImage;
    @Expose
    @SerializedName("original_title")
    private String mOriginalTitle;

    private Movie(Parcel in) {
        mVote = in.readDouble();
        mTitle = in.readString();
        mUrlImage = in.readString();
        mOriginalTitle = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public double getVote() {
        return mVote;
    }

    public void setVote(int vote) {
        mVote = vote;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mVote);
        dest.writeString(mTitle);
        dest.writeString(mUrlImage);
        dest.writeString(mOriginalTitle);
    }
}
