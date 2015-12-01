package fr.synapsegaming.statistiques.vo;

/**
 * Created by dimi on 30/11/15.
 */
public class UsersDefaultAvatarVO {

    private String username;

    public UsersDefaultAvatarVO(String username){

        this.username = username;
    }

    public UsersDefaultAvatarVO(){

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
