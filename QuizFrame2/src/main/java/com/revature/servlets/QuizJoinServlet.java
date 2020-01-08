package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.daos.QuizJoinDao;

import com.revature.models.QuizJoin;

public class QuizJoinServlet extends HttpServlet {

	private QuizJoinDao quizJD = QuizJoinDao.currentImplementation;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("To context param: " + req.getServletContext().getInitParameter("To"));

		
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<QuizJoin> quizJoin;

		String userIdStr = req.getParameter("userId");

		if (userIdStr != null) { // find by Author name
			int userId = Integer.parseInt(userIdStr);
			quizJoin = quizJD.findByAuthorId(userId);
		} else { // find all
			quizJoin = quizJD.findAll();
		}

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(quizJoin);

		resp.addHeader("content-type", "application/json");
		resp.getWriter().write(json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		QuizJoin r = (QuizJoin) om.readValue(req.getReader(), QuizJoin.class);
		System.out.println("we RE HERES");
		System.out.println(r);

		quizJD.save(r);

		String json = om.writeValueAsString(r);

		resp.getWriter().write(json);
		resp.setStatus(201); // created status code

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper om = new ObjectMapper();
		QuizJoin r = (QuizJoin) om.readValue(req.getReader(), QuizJoin.class);

		quizJD.update(r);

		resp.setStatus(201);
	}

}

