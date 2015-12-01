package fr.synapsegaming.statistiques.vo;

public class ForumMostActiveUsersVO {


    private String name;
    private Integer nbUsers;

    public ForumMostActiveUsersVO(String name, Integer nbUsers) {
        this.name = name;
        this.nbUsers = nbUsers;
    }

    public ForumMostActiveUsersVO(String name) {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNbUsers() {
        return nbUsers;
    }
    public void setNbUsers(Integer nbUsers) {
        this.nbUsers = nbUsers;
    }
    

    @Override
    public int compareTo(ForumMostActiveUsersVO forumMostActiveUsersVO) {
        return forumMostActiveUsersVO.getNbUsers()-this.nbUsers;
    }


}
