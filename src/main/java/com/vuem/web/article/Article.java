package com.vuem.web.article;

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
	private Long artseq;
	@Column(name="IMAGE", nullable=false)
	private Long image;
	@Column(name="COMMENTS", nullable=false)
	private Long comments;
	@Column(name="MSG", nullable=false)
	private Long msg;
	@Column(name="RETING", nullable=false)
	private Long reting;
	@Column(name="BOARDTYPE", nullable=false)
	private Long boardType;
	@Column(name="TITLE", nullable=false)
	private Long title;
	@Column(name="CONTENT", nullable=false)
	private Long content;
	@Column(name="CEMAIL", nullable=false)
	private Long cemail;
	@Column(name="REGDATE", nullable=false)
	private Long regdate;
}
