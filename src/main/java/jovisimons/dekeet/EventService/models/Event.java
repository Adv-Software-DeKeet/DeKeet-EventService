package jovisimons.dekeet.EventService.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jovisimons.dekeet.EventService.LocalDateDeserializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;

@Document
public class Event {
    @Id
    private String id;
    private String title;
    @JsonDeserialize(using= LocalDateDeserializer.class)
    private LocalDate datum;
    private String theme;
    private String picture;
    private User host;
    private ArrayList<User> users = new ArrayList<>();

    public Event(){

    }

    public Event(String title, LocalDate datum, String theme, String picture){
        this.title = title;
        this.datum = datum;
        this.theme = theme;
        this.picture = picture;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getDate(){
        return datum;
    }
    public void setDate(LocalDate date){
        this.datum = date;
    }

    public String getTheme(){
        return theme;
    }
    public void setTheme(String theme){
        this.theme = theme;
    }

    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    public User getHost(){
        return host;
    }
    public void setHost(User host){
        this.host = host;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
    public void setUser(User user){
        this.users.add(user);
    }

}
