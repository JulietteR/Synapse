package fr.synapsegaming.statistiques.vo;

/**
 * Created by dimi on 01/12/15.
 */
public class SpecsMostPlayedVO implements Comparable<SpecsMostPlayedVO> {

    private String name;
    private Integer nbUsers;

    public SpecsMostPlayedVO(String name, Integer nbUsers) {

        this.name = name;
        this.nbUsers = nbUsers;

    }

    public SpecsMostPlayedVO() {

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
    public int compareTo(SpecsMostPlayedVO specsMostPlayedVO) {
        return specsMostPlayedVO.getNbUsers()-this.nbUsers;
    }
}