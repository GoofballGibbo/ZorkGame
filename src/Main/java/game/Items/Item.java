package game.Items;


import java.io.Serializable;


public class Item implements Serializable {
    private String description;
    private String name;
    private String location;
    private String imagePath;
    private int id;
    private boolean isVisible;
    private static final long serialVersionUID = 1L;


    public Item(String name, String description, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.isVisible = true;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item() {

    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }


}