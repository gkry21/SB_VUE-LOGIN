package com.vuem.web.article;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ARTICLE")
public class Article {
	@Id
	@GeneratedValue
	@Column(name="ARTSEQ", nullable=false)
	private int artseq;
	@Column(name="IMAGE", nullable=false)
	private int image;
	@Column(name="COMMENTS", nullable=false)
	private String comments;
	@Column(name="MSG", nullable=false)
	private String msg;
	@Column(name="RETING", nullable=false)
	private String reting;
	@Column(name="BOARDTYPE", nullable=false)
	private String boardType;
	@Column(name="TITLE", nullable=false)
	private String title;
	@Column(name="CONTENT", nullable=false)
	private String content;
	@Column(name="CEMAIL", nullable=false)
	private String cemail;
	@Column(name="REGDATE", nullable=false)
	private Date regdate;
}
