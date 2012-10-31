package com.ece.superkids.entities;

public class User {

  private String name;
  private int score;

  public User() {
    name = "no name user";
    score = 0;
  }

  public User(String name) {
    this.name = name;
    score = 0;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public int getScore() {
    return score;
  }

}
