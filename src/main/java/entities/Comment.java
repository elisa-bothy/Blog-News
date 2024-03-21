/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Guillaume Rostagnat
 */
public class Comment implements Identifiable {

    private Integer id;
    private String content;
    private Timestamp created;
    private int state;
    private Person author;
    private int id_news;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.content);
        hash = 53 * hash + Objects.hashCode(this.created);
        hash = 53 * hash + this.state;
        hash = 53 * hash + Objects.hashCode(this.author);
        hash = 53 * hash + this.id_news;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.state != other.state) {
            return false;
        }
        if (this.id_news != other.id_news) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.created, other.created)) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment{");
        sb.append("id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", created=").append(created);
        sb.append(", state=").append(state);
        sb.append(", author=").append(author);
        sb.append(", id_news=").append(id_news);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

}
