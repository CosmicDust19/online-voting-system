CREATE DATABASE OVS;
USE OVS;

create table user
(
    uid            integer,
    f_name         varchar(20) not null,
    m_name         varchar(20),
    l_name         varchar(20) not null,
    address        varchar(200),
    password       varchar(50) not null,
    nationality_id varchar(11),
    birth_date     date,
    CONSTRAINT pk_user PRIMARY KEY (uid)
    /*,CONSTRAINT uk_user_nationality_id UNIQUE (nationality_id)*/
);

create table user_emails
(
    email_id integer,
    uid      integer,
    email    varchar(50) not null,
    CONSTRAINT pk_user_emails PRIMARY KEY (email_id),
    /*CONSTRAINT uk_user_email UNIQUE (email),*/
    CONSTRAINT fk_user_emails_uid FOREIGN KEY (uid)
        REFERENCES user (uid)
        ON DELETE CASCADE
);

create table user_phone_numbers
(
    phone_number_id integer,
    uid             integer,
    phone_number    varchar(13) not null,
    CONSTRAINT pk_user_phone_numbers PRIMARY KEY (phone_number_id),
    /*CONSTRAINT uk_user_phone_number UNIQUE (phone_number),*/
    CONSTRAINT fk_user_phone_numbers_uid FOREIGN KEY (uid)
        REFERENCES user (uid)
        ON DELETE CASCADE
);

create table voter
(
    uid integer,
    CONSTRAINT pk_voter PRIMARY KEY (uid),
    CONSTRAINT fk_voter_uid FOREIGN KEY (uid)
        REFERENCES user (uid)
        ON DELETE CASCADE
);

create table admin
(
    uid integer,
    CONSTRAINT pk_admin PRIMARY KEY (uid),
    CONSTRAINT fk_admin_uid FOREIGN KEY (uid)
        REFERENCES user (uid)
        ON DELETE CASCADE
);

create table candidate
(
    uid          integer,
    introduction varchar(500),
    CONSTRAINT pk_candidate PRIMARY KEY (uid),
    CONSTRAINT fk_candidate_uid FOREIGN KEY (uid)
        REFERENCES user (uid)
        ON DELETE CASCADE
);

create table election
(
    eid              integer,
    creator_admin_id integer not null,
    creation_date    date    not null,
    start_date       date    not null,
    end_date         date    not null,
    CONSTRAINT pk_election PRIMARY KEY (eid),
    CONSTRAINT fk_election_creator_admin_id FOREIGN KEY (creator_admin_id)
        REFERENCES admin (uid)
        ON DELETE CASCADE
);

create table vote
(
    vote_id      integer,
    voter_id     integer,
    election_id  integer,
    candidate_id integer,
    vote_date    date not null,
    CONSTRAINT pk_vote PRIMARY KEY (vote_id),
    CONSTRAINT uk_vote_voter_id_election_id UNIQUE (voter_id, election_id),
    CONSTRAINT fk_vote_voter_id FOREIGN KEY (voter_id)
        REFERENCES voter (uid),
    CONSTRAINT fk_vote_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid),
    CONSTRAINT fk_vote_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid)

);

create table election_candidate
(
    election_id  integer,
    candidate_id integer,
    CONSTRAINT pk_election_candidate PRIMARY KEY (election_id, candidate_id),
    CONSTRAINT fk_election_candidate_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid),
    CONSTRAINT fk_election_candidate_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid)
);

create table election_manager
(
    admin_id    integer,
    election_id integer,
    CONSTRAINT pk_election_manager PRIMARY KEY (admin_id, election_id),
    CONSTRAINT fk_election_manager_admin_id FOREIGN KEY (admin_id)
        REFERENCES admin (uid),
    CONSTRAINT fk_election_manager_election_id FOREIGN KEY (election_id)
        REFERENCES election (eid)
);

create table certification
(
    candidate_id integer,
    c_name       varchar(20) not null,
    description  varchar(200),
    CONSTRAINT pk_certification PRIMARY KEY (candidate_id, c_name),
    CONSTRAINT fk_certification_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid)
);

create table school
(
    candidate_id integer,
    s_name       varchar(20) not null,
    degree       varchar(20),
    CONSTRAINT pk_school PRIMARY KEY (candidate_id, s_name),
    CONSTRAINT fk_school_candidate_id FOREIGN KEY (candidate_id)
        REFERENCES candidate (uid)
);