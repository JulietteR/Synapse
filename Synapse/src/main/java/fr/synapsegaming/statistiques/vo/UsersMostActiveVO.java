package fr.synapsegaming.statistiques.vo;

/**
 * Created by dimi on 02/12/15.
 */
public class UsersMostActiveVO implements Comparable<UsersMostActiveVO> {

    private String username;
    private int socialPoint;

    public UsersMostActiveVO(String username, int socialPoint){

        this.username = username;
        this.socialPoint = socialPoint;
    }

    public UsersMostActiveVO(){

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getSocialPoint() {
        return socialPoint;
    }
    public void setSocialPoint(int socialPoint) {
        this.socialPoint = socialPoint;
    }

    @Override
    public int compareTo(UsersMostActiveVO usersMostActiveVO) {
        return usersMostActiveVO.getSocialPoint()-this.socialPoint;
    }


}
