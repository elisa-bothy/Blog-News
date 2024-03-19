/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Guillaume Rostagnat
 */
public class Vote {
    private Integer id;
    private int score;
    private Person Author;
    private int id_news;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vote{");
        sb.append("id=").append(id);
        sb.append(", score=").append(score);
        sb.append(", Author=").append(Author);
        sb.append(", id_news=").append(id_news);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + this.score;
        hash = 17 * hash + Objects.hashCode(this.Author);
        hash = 17 * hash + this.id_news;
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
        final Vote other = (Vote) obj;
        if (this.score != other.score) {
            return false;
        }
        if (this.id_news != other.id_news) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.Author, other.Author);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Person getAuthor() {
        return Author;
    }

    public void setAuthor(Person Author) {
        this.Author = Author;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }
    
    
}
