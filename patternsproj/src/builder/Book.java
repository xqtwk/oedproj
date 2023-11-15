package builder;

import decorator.IBook;

public class Book implements IBook {
    private String title;
    private String author;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
    }

    @Override
    public String getDescription() {
        return "Title: " + title + ", Author: " + author;
    }


    // Nested Builder
    public static class Builder {
        private String title;
        private String author;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }


        public Book build() {
            return new Book(this);
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
