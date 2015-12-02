package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.synapsegaming.statistiques.service.StatistiquesService;

import fr.synapsegaming.statistiques.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.synapsegaming.user.dao.SpecializationDao;
import fr.synapsegaming.user.entity.Specialization;

import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.entity.Clazz;

import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.entity.Race;

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

	@Autowired
	SpecializationDao specDao;


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

	@Override
	public List<SpecsMostPlayedVO> listFiveSpecsMostPlayed() {

		List<Specialization> specializations = specDao.list(Specialization.class);
		List<SpecsMostPlayedVO> specsMostPlayed = new ArrayList<SpecsMostPlayedVO>();

		for (Specialization spe:specializations){
			specsMostPlayed.add(new SpecsMostPlayedVO(spe.getName(), spe.getUsers().size()));
		}
		Collections.sort(specsMostPlayed);

		return specsMostPlayed.subList(0,5);
	}

	@Override
	public List<UsersMostActiveVO> listFiveUsersMostActive() {

		List<User> users = userDao.list(User.class);
		List<UsersMostActiveVO> usersMostActive = new ArrayList<UsersMostActiveVO>();

		for (User user:users){

			int numberOfArticles = user.getArticles().size();
			int numberOfPosts = user.getPosts().size();
			int numberOfComments = user.getReplies().size();

			int socialPoints = numberOfArticles*3 + numberOfPosts*2 + numberOfComments;

			usersMostActive.add(new UsersMostActiveVO(user.getNickname(), socialPoints  ));
		}

		Collections.sort(usersMostActive);

		return usersMostActive.subList(0,5);
	}

}
