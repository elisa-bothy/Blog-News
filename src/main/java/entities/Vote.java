/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Guillaume Rostagnat
 */
@SuppressWarnings("serial")
public class Vote implements Serializable, Identifiable {

    private Integer id;
    private int score;
    private int id_user;
    private int id_news;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vote{");
        sb.append("id=").append(id);
        sb.append(", score=").append(score);
        sb.append(", id_user=").append(id_user);
        sb.append(", id_news=").append(id_news);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + this.score;
        hash = 19 * hash + this.id_user;
        hash = 19 * hash + this.id_news;
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
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_news != other.id_news) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
