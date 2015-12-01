package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.statistiques.service.StatistiquesService;

import fr.synapsegaming.statistiques.vo.ClazzMostPlayedVO;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.entity.Clazz;

import fr.synapsegaming.statistiques.vo.RacesMostPlayedVO;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.entity.Race;

import fr.synapsegaming.statistiques.vo.UsersDefaultAvatarVO;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.User;


@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService{

	@Autowired
	ClazzDao clazzDao;

	@Autowired
	RaceDao raceDao;

	@Autowired
	UserDao userDao;


	@Override
	public List<ClazzMostPlayedVO> listFiveClassesMostPlayed() {
		List<Clazz> classes = clazzDao.list(Clazz.class);
		List<ClazzMostPlayedVO> classesMostPlayed = new ArrayList<ClazzMostPlayedVO>();
 		
		for(Clazz clazz:classes){
			classesMostPlayed.add(new ClazzMostPlayedVO(clazz.getName(),clazz.getUsers().size()));
		}

		Collections.sort(classesMostPlayed);
		return classesMostPlayed.subList(0, 5);
	}

	@Override
	public List<RacesMostPlayedVO> listFiveRacesMostPlayed() {
		List<Race> races = raceDao.list(Race.class);
		List<RacesMostPlayedVO> racesMostPlayed = new ArrayList<RacesMostPlayedVO>();

		for (Race race:races){
			racesMostPlayed.add(new RacesMostPlayedVO(race.getName(), race.getUsers().size()));
		}

		Collections.sort(racesMostPlayed);
		return racesMostPlayed.subList(0, 5);
	}


	@Override
	public List<UsersDefaultAvatarVO> listUsersDefaultAvatar(){

		List<User> users = userDao.list(User.class);
		List<UsersDefaultAvatarVO> usersDefaultAvatar = new ArrayList<UsersDefaultAvatarVO>();

		for (User user:users){
			if (user.getForumAvatar().equals("/resources/img/default_avatar.png") == true ) {
				usersDefaultAvatar.add(new UsersDefaultAvatarVO(user.getNickname()));
			}
		}

		return usersDefaultAvatar;
	}

}
