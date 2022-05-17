CREATE DATABASE ovs;
USE ovs;

create table user
(
    uid           integer      not null auto_increment primary key,
    email         varchar(100) not null,
    password      varchar(100) not null,
    f_name        varchar(30)  not null,
    m_name        varchar(30),
    l_name        varchar(30)  not null,
    birth_date    date         not null,
    creation_date date         not null default current_date,
    CONSTRAINT uk_user_email UNIQUE (email)
);

create table user_phone_numbers
(
    pid          integer     not null primary key,
    phone_number varchar(17) not null,
    uid          integer     not null,
    CONSTRAINT fk_user_phone_numbers_uid FOREIGN KEY (uid)
        REFERENCES user (uid) ON DELETE CASCADE
);

create table voter
(
    uid integer not null primary key,
    CONSTRAINT fk_voter_uid FOREIGN KEY (uid)
        REFERENCES user (uid) ON DELETE CASCADE
);

create table admin
(
    uid      integer not null primary key,
    verified boolean not null default false,
    CONSTRAINT fk_admin_uid FOREIGN KEY (uid)
        REFERENCES user (uid) ON DELETE CASCADE
);

create table candidate
(
    uid            integer      not null primary key,
    introduction   varchar(1000),
    address        varchar(400) not null,
    nationality_id varchar(11)  not null,
    verified       boolean      not null default false,
    CONSTRAINT uk_candidate_nationality_id UNIQUE (nationality_id),
    CONSTRAINT fk_candidate_uid FOREIGN KEY (uid)
        REFERENCES user (uid) ON DELETE CASCADE
);

create table candidate_certifications
(
    cert_id      integer     not null auto_increment primary key,
    candidate_id integer     not null,
    name         varchar(40) not null,
    description  varchar(400),
    CONSTRAINT uk_candidate_certifications_candidate_id_name UNIQUE (candidate_id, name),
    CONSTRAINT fk_candidate_certifications_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid) ON DELETE CASCADE
);

create table candidate_schools
(
    sch_id       integer     not null auto_increment primary key,
    candidate_id integer     not null,
    name         varchar(30) not null,
    degree       varchar(30) not null,
    CONSTRAINT uk_candidate_schools_candidate_id_name UNIQUE (candidate_id, name, degree),
    CONSTRAINT fk_candidate_schools_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid) ON DELETE CASCADE
);

create table election
(
    eid              integer      not null primary key,
    creator_admin_id integer      not null,
    title            varchar(100) not null,
    end              timestamp(0) not null default current_timestamp,
    start            timestamp(0) not null default current_timestamp,
    creation_date    date         not null,
    CONSTRAINT fk_election_creator_admin_id FOREIGN KEY (creator_admin_id)
        REFERENCES admin (uid) ON DELETE CASCADE
);

create table election_attenders
(
    election_id  integer not null,
    candidate_id integer not null,
    CONSTRAINT pk_election_attenders PRIMARY KEY (election_id, candidate_id),
    CONSTRAINT fk_election_attenders_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid) ON DELETE CASCADE,
    CONSTRAINT fk_election_attenders_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid) ON DELETE CASCADE
);

create table election_executives
(
    admin_id    integer not null,
    election_id integer not null,
    CONSTRAINT pk_election_executives PRIMARY KEY (admin_id, election_id),
    CONSTRAINT fk_election_executives_admin_id FOREIGN KEY (admin_id)
        REFERENCES admin (uid) ON DELETE CASCADE,
    CONSTRAINT fk_election_executives_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid) ON DELETE CASCADE
);

create table vote
(
    vote_id      integer      not null,
    voter_id     integer      not null,
    election_id  integer      not null,
    candidate_id integer      not null,
    vote_date    timestamp(0) not null default current_timestamp,
    CONSTRAINT pk_vote PRIMARY KEY (vote_id),
    CONSTRAINT uk_vote_voter_id_election_id UNIQUE (voter_id, election_id),
    CONSTRAINT fk_vote_voter_id FOREIGN KEY (voter_id)
        REFERENCES voter (uid) ON DELETE CASCADE,
    CONSTRAINT fk_vote_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid) ON DELETE CASCADE,
    CONSTRAINT fk_vote_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid) ON DELETE CASCADE
);