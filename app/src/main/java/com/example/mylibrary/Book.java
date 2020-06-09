package com.example.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private int id;

    private String name;
    private String author;

    private String imageUrl;

    private boolean isExpanded;

    public Book(int id, String name, String author, String imageUrl) {
        this.id = id;
        this.name = name;

        this.imageUrl = imageUrl;
        this.author = author;
        isExpanded = false;
    }

    protected Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
        author = in.readString();
        imageUrl = in.readString();
        isExpanded = in.readByte() != 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public static boolean getId(int i) {
        return true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +

                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(imageUrl);
        dest.writeByte((byte) (isExpanded ? 1 : 0));
    }
}