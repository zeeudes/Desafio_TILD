package com.tild.desafio.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Preconditions;

import javax.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String twitter;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
        super();
    }

    public User(String name, String twitter) {
		super();
		this.name = name;
		this.twitter = twitter;
	}

	public User(String name, String twitter, List<Post> posts) {
		super();
		this.name = name;
		this.twitter = twitter;
		this.posts = posts;
	}

	public User(Long id, String name, String twitter, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.twitter = twitter;
		this.posts = posts;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getTwitterUrl() {
        return String.format("https://twitter.com/%s", this.getTwitter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(twitter, user.twitter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, twitter);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
    
    public boolean isValid() {
        boolean valid = false;

        try {
            Arrays.asList(this.getId(), this.getName(), this.getTwitter())
                    .forEach(Preconditions::checkNotNull);

            Arrays.asList(this.getName(), this.getTwitter())
                    .forEach(txt -> {
                        Preconditions.checkArgument(!txt.isEmpty());
                    });

            valid = true;
        } catch (Exception e){
            valid = false;
        }

        return valid;
    }
}
