package com.jlearn.jdbc.pojo;

import java.sql.Timestamp;

public class ShowDtls {

	private int id;

	private int movieId;

	private int screenId;

	private Timestamp showTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public Timestamp getShowTime() {
		return showTime;
	}

	public void setShowTime(Timestamp showTime) {
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "ShowDtls [id=" + id + ", movieId=" + movieId + ", screenId=" + screenId + ", showTime=" + showTime
				+ "]";
	}

}
