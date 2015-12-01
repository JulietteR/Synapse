package fr.synapsegaming.statistiques.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.synapsegaming.commons.service.AbstractServiceTest;

public class StatistiquesServiceTest extends AbstractServiceTest {

	private static final int RECORD_NUMBER_EXPECTED = 5;
	
	@Autowired
	StatistiquesService statistiquesService;

	@Test
	public void testlistFiveClassesMostPlayed() {
		assertTrue(statistiquesService.listFiveClassesMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}

	@Test
	public void testlistFiveRacesMostPlayed() {
		assertTrue(statistiquesService.listFiveRacesMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}




}
