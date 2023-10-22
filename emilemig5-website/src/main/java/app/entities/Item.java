package app.entities;

public class Item {

    public int id;
    public String title;
    public String bio;
    public String url;


    public Item(int id, String title, String bio, String url){
        this.id = id;
        this.title = title;
        this.bio = bio;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBio() {
        return bio;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bio='" + bio + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
