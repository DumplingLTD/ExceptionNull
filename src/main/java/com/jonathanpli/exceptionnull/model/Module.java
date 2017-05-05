package com.jonathanpli.exceptionnull.model;

import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;
import static com.jonathanpli.mysql.Attribute.FOREIGN_KEY;
import static com.jonathanpli.mysql.Attribute.INDEXED;
import static com.jonathanpli.mysql.Attribute.NOT_NULL;
import static com.jonathanpli.mysql.Attribute.PRIMARY_KEY;
import static com.jonathanpli.mysql.Attribute.UNIQUE;
import static com.jonathanpli.mysql.DataType.DATETIME;
import static com.jonathanpli.mysql.DataType.INT;
import static com.jonathanpli.mysql.DataType.TINYINT;
import static com.jonathanpli.mysql.DataType.VARCHAR;

/**
 * Contains metadata associated to a module. A module contains one or more lessons, which contain
 * one or more cards.
 * Keep up-to-date with table/module.sql.
 */
@Table(name = "module")
public class Module {
	@Column(name = "id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { PRIMARY_KEY, AUTO_INCREMENT, NOT_NULL })
	public int id;

	@Column(name = "language_id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { FOREIGN_KEY, INDEXED, UNIQUE, NOT_NULL })
	public int languageId;

	@Column(name = "owner_user_id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { FOREIGN_KEY, INDEXED, NOT_NULL })
	public int ownerUserId;

	@Column(name = "title",
			dataType = VARCHAR,
			datatypeParams = { 128 },
			attributes = { INDEXED, UNIQUE, NOT_NULL })
	public String title;

	@Column(name = "description", dataType = VARCHAR, datatypeParams = { 1024 })
	public String description;

	@Column(name = "date_created", dataType = DATETIME, attributes = { NOT_NULL })
	public long dateCreated;

	@Column(name = "image_thumbnail_url", dataType = VARCHAR, datatypeParams = { 2048 })
	public String imageThumbnailUrl;

	@Column(name = "image_banner_url", dataType = VARCHAR, datatypeParams = { 2048 })
	public String imageBannerUrl;

	@Column(name = "is_author_hidden",
			dataType = TINYINT,
			datatypeParams = { 1 },
			attributes = { NOT_NULL })
	public boolean isAuthorHidden;

	@Column(name = "is_published",
			dataType = TINYINT,
			datatypeParams = { 1 },
			attributes = { NOT_NULL })
	public boolean isPublished;

	@Column(name = "is_premium",
			dataType = TINYINT,
			datatypeParams = { 1 },
			attributes = { NOT_NULL })
	public boolean isPremium;
}
