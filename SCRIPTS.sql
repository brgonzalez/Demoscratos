CREATE TABLE rings (
	id VARCHAR(30) NOT NULL PRIMARY KEY,
	member1 VARCHAR(30) NOT NULL,
	member2 VARCHAR(30) NOT NULL,
	member3 VARCHAR(30) NOT NULL);
	
CREATE TABLE topics (
	id varchar(30) NOT NULL PRIMARY KEY,
	private varchar(6) NOT NULL,
	type varchar(10) NOT NULL,
	question varchar(40));
	
CREATE TABLE options (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    topic varchar(30), 
    opt varchar(30) NOT NULL,
    FOREIGN KEY (topic) 
        REFERENCES topics(id)
        ON DELETE CASCADE);

CREATE TABLE multiple_votes (
    topic varchar(30),
	opt INT, 
    email varchar(30) NOT NULL,
    PRIMARY KEY(topic, opt, email),
    FOREIGN KEY (opt) 
        REFERENCES options(id)
        ON DELETE CASCADE,
    FOREIGN KEY (topic) 
        REFERENCES topics(id)
        ON DELETE CASCADE);

CREATE TABLE unique_votes (
    topic varchar(30),
	opt INT, 
    email varchar(30) NOT NULL,
    PRIMARY KEY(topic, email),
    FOREIGN KEY (opt) 
        REFERENCES options(id)
        ON DELETE CASCADE,
    FOREIGN KEY (topic) 
        REFERENCES topics(id)
        ON DELETE CASCADE);
        
INSERT INTO topics(id, private, type, question) VALUES('0', 'true', 'simple', NULL);
INSERT INTO options(topic, opt) VALUES('0', 'positivo');
INSERT INTO options(topic, opt) VALUES('0', 'negativo');
INSERT INTO options(topic, opt) VALUES('0', 'abstención');
INSERT INTO options(topic, opt) VALUES('0', 'nulo');
ALTER TABLE topics ADD COLUMN approved varchar(6) DEFAULT 'false';

CREATE TABLE given_votes (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    topic varchar(30),
	opt INT, 
    email_user varchar(30) NOT NULL,
    email_member varchar(30) NOT NULL,
    FOREIGN KEY (opt) 
        REFERENCES options(id)
        ON DELETE CASCADE,
    FOREIGN KEY (topic) 
        REFERENCES topics(id)
        ON DELETE CASCADE);