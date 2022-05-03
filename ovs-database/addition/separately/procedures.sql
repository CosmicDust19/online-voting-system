DELIMITER //

/*What is the most voted candidate in an election?*/
create procedure get_election_votes_by_eid(IN temp_eid integer)
begin
SELECT vote.candidate_id, CONCAT_WS(' ', f_name, IFNULL(m_name, ''), l_name) as name, COUNT(vote_id) as vote_count
FROM vote
         INNER JOIN user ON vote.candidate_id = user.uid
WHERE election_id = temp_eid
GROUP by candidate_id;
end;
//

create procedure get_most_voted_candidate_in_the_election(IN temp_eid integer)
begin
Select candidate_id, name, MAX(vote_count) as winner_vote_count
from (SELECT vote.candidate_id, CONCAT_WS(' ', f_name, IFNULL(m_name, ''), l_name) as name, COUNT(vote_id) as vote_count
      FROM vote
               INNER JOIN user ON vote.candidate_id = user.uid
      WHERE election_id = temp_eid
      GROUP by candidate_id) as winner;
end;
//

/*Is the user an admin?*/
create procedure check_if_user_an_admin(IN temp_uid integer)
begin
SELECT temp_uid as admin_id, IF(EXISTS(SELECT uid FROM admin WHERE uid = temp_uid), 'true', 'false') AS exist;
end;
//

/*When did voter vote the candidate?*/
create procedure get_vote_date(IN temp_voter_id integer, IN temp_election_id integer)
begin
SELECT vote_date from vote WHERE voter_id = temp_voter_id AND election_id = temp_election_id;
end;
//

/*When was an election created, and by whom?*/
create procedure when_was_created_the_election(IN temp_election_id integer)
begin
SELECT creation_date FROM election where eid = temp_election_id;
end;
//

/*Which admins are managing which election?*/
create procedure get_election_managers(IN temp_election_id integer)
begin
SELECT admin_id FROM election_manager where election_id = temp_election_id;
end;
//

/*Which candidates attended which election?*/
create procedure get_election_attenders(IN temp_election_id integer)
begin
SELECT candidate_id FROM election_candidate where election_id = temp_election_id;
end;
//

/*What is the education info of a candidate?*/
create procedure get_schools_by_candidate(IN temp_candidate_id integer)
begin
SELECT s_name, degree FROM school where candidate_id = temp_candidate_id;
end;
//

create procedure get_certifications_by_candidate(IN temp_candidate_id integer)
begin
SELECT c_name, description FROM certification where candidate_id = temp_candidate_id;
end;
//

/*What is information of a user?*/
create procedure get_user_by_uid(IN temp_user_id integer)
begin
SELECT uid, CONCAT_WS(' ', f_name, IFNULL(m_name, ''), l_name) as name, address, birth_date from user where uid = temp_user_id;
end;
//

create procedure get_user_emails(IN temp_user_id integer)
begin
SELECT email from user_emails where uid = temp_user_id;
end;
//

create procedure get_user_phone_numbers(IN temp_user_id integer)
begin
SELECT phone_number from user_phone_numbers where uid = temp_user_id;
end;
//

/*When will an election start and end?*/
create procedure when_will_start_and_end_the_election(IN temp_election_id integer)
begin
SELECT start_date, end_date FROM election where eid = temp_election_id;
end;
//

DELIMITER ;