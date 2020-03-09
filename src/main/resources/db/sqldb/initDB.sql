DROP TABLE types IF EXISTS;
DROP TABLE roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE projects IF EXISTS;
DROP TABLE bids IF EXISTS;

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);

CREATE TABLE projects (
  id         INTEGER IDENTITY PRIMARY KEY,
  project_name       VARCHAR(30),
  submition_lastdate DATE,
  username    VARCHAR(20) NOT NULL,
  description VARCHAR(100)
  max_budget  DECIMAL NOT NULL
);
ALTER TABLE projects ADD CONSTRAINT fk_projects_users FOREIGN KEY (username) REFERENCES users (username);

CREATE TABLE bids (
  id          INTEGER IDENTITY PRIMARY KEY,
  project_id      INTEGER NOT NULL,
  //username VARCHAR(20) NOT NULL,
  estimated_days INTEGER NOT NULL,
  bid_date  DATE,
  bid_amount DECIMAL NOT NULL
  desc_proposal VARCHAR(255)
);
ALTER TABLE bids ADD CONSTRAINT fk_bids_projects FOREIGN KEY (project_id) REFERENCES projects (id);
//ALTER TABLE bids ADD CONSTRAINT fk_bids_users FOREIGN KEY (username) REFERENCES users (username);

CREATE  TABLE users (
  username    VARCHAR(20) NOT NULL ,
  password    VARCHAR(20) NOT NULL ,
  enabled     BOOLEAN DEFAULT TRUE NOT NULL ,
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  PRIMARY KEY (username)
);

CREATE TABLE roles (
  id              INTEGER IDENTITY PRIMARY KEY,
  username        VARCHAR(20) NOT NULL,
  role            VARCHAR(20) NOT NULL
);
ALTER TABLE roles ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username);
CREATE INDEX fk_username_idx ON roles (username);

