DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks
(
	id INT NOT NULL AUTO_INCREMENT,
	task VARCHAR(20) NOT NULL,
	primary key (id)
);