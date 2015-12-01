package fr.synapsegaming.statistiques.vo;

/**
 * Created by dimi on 27/11/15.
 */
public class RacesMostPlayedVO implements Comparable<RacesMostPlayedVO> {

    private String name;
    private Integer nbUsers;

    public RacesMostPlayedVO(String name, Integer nbUsers) {
        this.name = name;
        this.nbUsers = nbUsers;
    }

    public RacesMostPlayedVO(String name) {

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
    public int compareTo(RacesMostPlayedVO racesMostPlayedVO) {
        return racesMostPlayedVO.getNbUsers()-this.nbUsers;
    }

}
