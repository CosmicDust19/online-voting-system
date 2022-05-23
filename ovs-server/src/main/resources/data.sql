INSERT IGNORE INTO authority(authority_id, name)
VALUES (1, 'ROLE_VOTER');
INSERT IGNORE INTO authority(authority_id, name)
VALUES (2, 'ROLE_CANDIDATE');
INSERT IGNORE INTO authority(authority_id, name)
VALUES (3, 'ROLE_ADMIN');

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (1, '2001-07-29', DEFAULT, 'smh01.2019@gmail.com', true, 'Semih', 'Kayan', null, '$2a$10$TQyglUp29jSQ.l7htuj2wOIE47snlhkqLXhFrsi2W3CYBg4axq0Fa');
INSERT IGNORE INTO ovs.admin (uid)
VALUES (1);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (1, 3);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (2, '2000-01-01', DEFAULT, 'admin@ovs.com', true, 'Adminfn', 'Adminln', null, '$2a$12$eyVjYLPSxOs3dQ8YhNCZK.YNQ4aYJ43HTjU2mQqMzMbdT19a.MHyO');
INSERT IGNORE INTO ovs.admin (uid)
VALUES (2);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (2, 3);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (3, '2000-01-01', DEFAULT, 'cand1@ovs.com', true, 'Candfn', 'Candln', null, '$2a$12$eyVjYLPSxOs3dQ8YhNCZK.YNQ4aYJ43HTjU2mQqMzMbdT19a.MHyO');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (3, 'candidate_address_candidate_address', 'candidate_introduction', '11111111111');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (3, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (4, '2000-01-01', DEFAULT, 'cand2@ovs.com', true, 'Candfn', 'Candln', null, '$2a$12$eyVjYLPSxOs3dQ8YhNCZK.YNQ4aYJ43HTjU2mQqMzMbdT19a.MHyO');
INSERT IGNORE INTO ovs.candidate (uid, address, introduction, nationality_id)
VALUES (4, 'candidate_address_candidate_address', 'candidate_introduction', '22222222222');
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (4, 2);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (5, '2000-01-01', DEFAULT, 'voter1@ovs.com', true, 'Voterfn', 'Voterln', null, '$2a$12$eyVjYLPSxOs3dQ8YhNCZK.YNQ4aYJ43HTjU2mQqMzMbdT19a.MHyO');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (5);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (5, 1);

INSERT IGNORE INTO ovs.user (uid, birth_date, creation_date, email, enabled, f_name, l_name, m_name, password)
VALUES (6, '2000-01-01', DEFAULT, 'voter2@ovs.com', true, 'Voterfn', 'Voterln', null, '$2a$12$eyVjYLPSxOs3dQ8YhNCZK.YNQ4aYJ43HTjU2mQqMzMbdT19a.MHyO');
INSERT IGNORE INTO ovs.voter (uid)
VALUES (6);
INSERT IGNORE INTO ovs.user_authorities (uid, auth_id)
VALUES (6, 1);