package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.statistiques.vo.*;

public interface StatistiquesService {

	/**
	 * Liste les 5 classes les plus jouées
	 * @return Liste de classes
	 */
	List<ClazzMostPlayedVO> listFiveClassesMostPlayed();

	List<RacesMostPlayedVO> listFiveRacesMostPlayed();

	List<UsersDefaultAvatarVO> listUsersDefaultAvatar();

	List<SpecsMostPlayedVO> listFiveSpecsMostPlayed();

	List<UsersMostActiveVO> listFiveUsersMostActive();
}
