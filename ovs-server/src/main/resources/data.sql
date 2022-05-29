

/* Roles */
INSERT IGNORE INTO authority(authority_id, name)
VALUES (1, 'ROLE_VOTER');
INSERT IGNORE INTO authority(authority_id, name)
VALUES (2, 'ROLE_CANDIDATE');
INSERT IGNORE INTO authority(authority_id, name)
VALUES (3, 'ROLE_ADMIN');


/* Admins */
INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (2, '2000-01-01', DEFAULT, 'admin@ovs.com', true, 'Adminfn', 'Adminln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.admin (uid)
VALUES (2);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (2, 3);


/* Candidates */
INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (3, '2000-01-01', DEFAULT, 'cand1@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (3, 'candidate_address_candidate_address', 'candidate_introduction', '11111111111');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (3, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (4, '2000-01-01', DEFAULT, 'cand2@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (4, 'candidate_address_candidate_address', 'candidate_introduction', '22222222222');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (4, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (5, '2000-01-01', DEFAULT, 'cand3@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (5, 'candidate_address_candidate_address', 'candidate_introduction', '33333333333');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (5, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (6, '2000-01-01', DEFAULT, 'cand4@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (6, 'candidate_address_candidate_address', 'candidate_introduction', '44444444444');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (6, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (7, '2000-01-01', DEFAULT, 'cand5@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (7, 'candidate_address_candidate_address', 'candidate_introduction', '55555555555');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (7, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (8, '2000-01-01', DEFAULT, 'cand6@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (8, 'candidate_address_candidate_address', 'candidate_introduction', '66666666666');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (8, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (9, '2000-01-01', DEFAULT, 'cand7@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (9, 'candidate_address_candidate_address', 'candidate_introduction', '77777777777');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (9, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (10, '2000-01-01', DEFAULT, 'cand8@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (10, 'candidate_address_candidate_address', 'candidate_introduction', '88888888888');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (10, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (11, '2000-01-01', DEFAULT, 'cand9@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (11, 'candidate_address_candidate_address', 'candidate_introduction', '99999999999');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (11, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (12, '2000-01-01', DEFAULT, 'cand10@ovs.com', true, 'Candfn', 'Candln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (12, 'candidate_address_candidate_address', 'candidate_introduction', '10101010101');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (12, 2);


/* Voters */
INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (13, '2000-01-01', DEFAULT, 'voter1@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (13);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (13, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (14, '2000-01-01', DEFAULT, 'voter2@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (14);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (14, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (15, '2000-01-01', DEFAULT, 'voter3@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (15);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (15, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (16, '2000-01-01', DEFAULT, 'voter4@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (16);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (16, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (17, '2000-01-01', DEFAULT, 'voter5@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (17);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (17, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (18, '2000-01-01', DEFAULT, 'voter6@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (18);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (18, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (19, '2000-01-01', DEFAULT, 'voter7@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (19);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (19, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (20, '2000-01-01', DEFAULT, 'voter8@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (20);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (20, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (21, '2000-01-01', DEFAULT, 'voter9@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (21);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (21, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (22, '2000-01-01', DEFAULT, 'voter10@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (22);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (22, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (23, '2000-01-01', DEFAULT, 'voter11@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (23);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (23, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (24, '2000-01-01', DEFAULT, 'voter12@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (24);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (24, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (25, '2000-01-01', DEFAULT, 'voter13@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (25);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (25, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (26, '2000-01-01', DEFAULT, 'voter14@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (26);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (26, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (27, '2000-01-01', DEFAULT, 'voter15@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (27);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (27, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (28, '2000-01-01', DEFAULT, 'voter16@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (28);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (28, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (29, '2000-01-01', DEFAULT, 'voter17@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (29);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (29, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (30, '2000-01-01', DEFAULT, 'voter18@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (30);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (30, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (31, '2000-01-01', DEFAULT, 'voter19@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (31);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (31, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (32, '2000-01-01', DEFAULT, 'voter20@ovs.com', true, 'Voterfn', 'Voterln', null,
        '$2a$12$a85fqCNeqjISP1gF4FLmXODBSfdA3/ovFqqlOWP/DyHwwC2FykOqi');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (32);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (32, 1);


/* Elections */
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (1, DEFAULT, DEFAULT, DEFAULT, 'Title1', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (2, DEFAULT, DEFAULT, DEFAULT, 'Title2', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (3, DEFAULT, DEFAULT, DEFAULT, 'Title3', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (4, DEFAULT, DEFAULT, DEFAULT, 'Title4', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (5, DEFAULT, DEFAULT, DEFAULT, 'Title5', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (6, DEFAULT, DEFAULT, DEFAULT, 'Title6', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (7, DEFAULT, DEFAULT, DEFAULT, 'Title7', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (8, DEFAULT, DEFAULT, DEFAULT, 'Title8', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (9, DEFAULT, DEFAULT, DEFAULT, 'Title9', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (10, DEFAULT, DEFAULT, DEFAULT, 'Title10', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (11, DEFAULT, DEFAULT, DEFAULT, 'Title11', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (12, DEFAULT, DEFAULT, DEFAULT, 'Title12', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (13, DEFAULT, DEFAULT, DEFAULT, 'Title13', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (14, DEFAULT, DEFAULT, DEFAULT, 'Title14', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (15, DEFAULT, DEFAULT, DEFAULT, 'Title15', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (16, DEFAULT, DEFAULT, DEFAULT, 'Title16', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (17, DEFAULT, DEFAULT, DEFAULT, 'Title17', 1);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (18, DEFAULT, DEFAULT, DEFAULT, 'Title18', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (19, DEFAULT, DEFAULT, DEFAULT, 'Title19', 2);
INSERT IGNORE INTO ovs.election (eid, creation_date, end, start, title, creator_admin_id)
VALUES (20, DEFAULT, DEFAULT, DEFAULT, 'Title20', 1);


/* Attenders */
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 3);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 4);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 5);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 6);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 7);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 8);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 9);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 10);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 11);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (1, 12);

INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 3);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 4);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 5);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 6);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 7);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 8);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 9);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 10);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 11);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 12);

INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 3);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 4);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 5);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 6);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 7);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 8);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 9);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 10);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (3, 11);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (2, 12);

INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 3);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 4);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 5);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 6);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 7);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 8);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (4, 9);

INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 3);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 4);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 5);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 6);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 7);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 8);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 9);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 10);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 11);
INSERT IGNORE INTO ovs.election_attenders(election_id, candidate_id)
VALUES (5, 12);

/* Executives */
INSERT IGNORE INTO ovs.election_executives (election_id, admin_id)
VALUES (2, 1);
INSERT IGNORE INTO ovs.election_executives (election_id, admin_id)
VALUES (3, 1);
INSERT IGNORE INTO ovs.election_executives (election_id, admin_id)
VALUES (4, 1);
INSERT IGNORE INTO ovs.election_executives (election_id, admin_id)
VALUES (5, 2);

/* Votes */
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (1, DEFAULT, 4, 1, 13);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (2, DEFAULT, 4, 1, 14);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (3, DEFAULT, 4, 1, 15);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (4, DEFAULT, 4, 1, 16);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (5, DEFAULT, 4, 1, 17);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (6, DEFAULT, 4, 1, 18);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (7, DEFAULT, 5, 1, 19);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (8, DEFAULT, 5, 1, 20);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (9, DEFAULT, 3, 1, 21);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (10, DEFAULT, 3, 1, 22);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (11, DEFAULT, 3, 1, 23);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (12, DEFAULT, 3, 1, 24);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (13, DEFAULT, 3, 1, 25);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (14, DEFAULT, 3, 1, 26);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (15, DEFAULT, 3, 1, 27);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (16, DEFAULT, 3, 1, 28);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (17, DEFAULT, 4, 1, 29);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (18, DEFAULT, 4, 1, 30);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (19, DEFAULT, 4, 1, 31);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (20, DEFAULT, 4, 1, 32);

INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (21, DEFAULT, 5, 2, 13);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (22, DEFAULT, 5, 2, 14);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (23, DEFAULT, 5, 2, 15);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (24, DEFAULT, 5, 2, 16);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (25, DEFAULT, 5, 2, 17);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (26, DEFAULT, 5, 2, 18);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (27, DEFAULT, 6, 2, 19);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (28, DEFAULT, 6, 2, 20);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (29, DEFAULT, 4, 2, 21);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (30, DEFAULT, 4, 2, 22);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (31, DEFAULT, 4, 2, 23);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (32, DEFAULT, 4, 2, 24);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (33, DEFAULT, 4, 2, 25);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (34, DEFAULT, 4, 2, 26);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (35, DEFAULT, 4, 2, 27);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (36, DEFAULT, 4, 2, 28);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (37, DEFAULT, 5, 2, 29);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (38, DEFAULT, 5, 2, 30);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (39, DEFAULT, 5, 2, 31);
INSERT IGNORE INTO ovs.vote (vote_id, vote_date, candidate_id, election_id, voter_id)
VALUES (40, DEFAULT, 5, 2, 32);