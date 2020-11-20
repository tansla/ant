package ant;

import ant.controllers.AntController;
import ant.dto.IncomingDTO;
import ant.dto.OutcomingDTO;
import ant.model.*;
import ant.service.PathFinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://habr.com/ru/post/444828/#:~:text=%D0%9F%D0%BE%D0%B8%D1%81%D0%BA%20%D0%BF%D1%83%D1%82%D0%B8%20%E2%80%94%20%D1%8D%D1%82%D0%BE%20%D0%BE%D0%B4%D0%BD%D0%B0%20%D0%B8%D0%B7,%D0%B1%D0%BE%D0%BB%D1%8C%D1%88%D0%B8%D0%B5%20%D1%81%D0%BB%D0%BE%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D0%B8%20%D0%B4%D0%BB%D1%8F%20%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%D0%BE%D0%B2%20%D0%B8%D0%B3%D1%80.
//https://www.gabrielgambetta.com/generic-search.html
@SpringBootApplication
public class AntApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntApplication.class, args);


		OutcomingDTO request = new OutcomingDTO();
		IncomingDTO answer;
		RandomField antMap = new RandomField();
		Coordinate nextStep;
		Coordinate currentPoint;

		// Get Map and started points
		answer =  AntController.helloRequest(request);

		antMap.setGoalPoint(answer.getCurrent_target());
		antMap.setStartPoint(answer.getStart_coords());
		currentPoint = answer.getStart_coords();
		antMap.fillMap(answer.getMap());

		antMap.print("started Map");

		// Looking for the Path

		PathFinder.exploreTheMap(antMap);
		List<Coordinate> thePath = PathFinder.findThePath(antMap);

		nextStep = thePath.remove(0);
		request.setNext_step_coords(nextStep);

		/*

		int[][] mapFromPost = new int[21][21]; // todo get info from POST
		Coordinate start = new Coordinate(); // todo get start_coords from POST
		Coordinate currentTarget = new Coordinate(); // todo get current_target from POST

		PathFinder.exploreTheMap(antMap);

		//PathFinder.exploreTheMap(myMap);
		//PathFinder.printThePath(myMap);
		//System.out.println(myMap.getTree(myMap.getGoalPoint()));
		//PathFinder.drawMap(myMap);
		myMap.print("Path");
		//PathFinder.printThePath(myMap);


		 */

	}


	}


