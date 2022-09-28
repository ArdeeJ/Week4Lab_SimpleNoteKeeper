package models;

import java.io.Serializable;

/**
 *
 * @author ardee
 */
public class Note implements Serializable {
    private String title;
    private String contents;
    
    public Note() {
        title = "";
        contents = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}

